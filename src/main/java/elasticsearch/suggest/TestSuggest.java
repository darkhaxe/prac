package elasticsearch.suggest;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.elasticsearch.search.suggest.term.TermSuggestion;
import org.elasticsearch.search.suggest.term.TermSuggestionBuilder;

import java.io.IOException;
import java.util.Map;

/**
 * @author haze
 * @date created at 2019-09-11 09:05
 */
@Slf4j
public class TestSuggest {
    public static void main(String[] args) throws IOException {
        TestSuggest main = new TestSuggest();
        try (RestHighLevelClient client = main.getClient("172.16.0.2", 9200)) {

//        main.createType(client);
//        main.addData(client);

            main.queryData(client);
            main.wrongSpell(client);
            main.highlight(client);
            main.suggest(client);
        }
    }


    /**
     * 拼写补全
     * completionSuggestion
     */
    private void suggest(RestHighLevelClient client) throws IOException {
        //从里往外封装查询,最里层使用的是CompletionSuggestionBuilder,最外层是SearchRequest

        String inputText = "大话西游";

        String suggestFieldName = "title.suggest";

        //补全查询builder
        CompletionSuggestionBuilder suggestionBuilder = SuggestBuilders.
                completionSuggestion(suggestFieldName).prefix(inputText);

        //起个别名
        String queryAlias = "title_suggest";
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion(queryAlias, suggestionBuilder);

        //装进SearchSourceBuilder里
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.suggest(suggestBuilder);

        //指定查询的Index,装进SearchRequest里
        String indexName = "news_website";
        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.source(searchSourceBuilder);

        SearchResponse resp = client.search(searchRequest, RequestOptions.DEFAULT);

        if (!RestStatus.OK.equals(resp.status())) {
            throw new RuntimeException("查询失败");
        }

        Suggest suggest = resp.getSuggest();
        CompletionSuggestion completionSuggestion = suggest.getSuggestion(queryAlias);
        completionSuggestion.forEach((CompletionSuggestion.Entry entry) -> {
            System.out.println("  text: " + entry.getText().toString());
            entry.forEach((CompletionSuggestion.Entry.Option option) ->
                    System.out.println("suggest : " + option.getText().toString())
            );
        });
    }

    /**
     * 错误纠正
     * termSuggestion
     */
    private void wrongSpell(RestHighLevelClient client) throws IOException {
        //搜索的文本
        String inputText = "cxk长跳rwp";
        //suggest搜索的字段
        String suggestFieldName = "title.suggest";

        TermSuggestionBuilder termSuggestionBuilder =
                SuggestBuilders.termSuggestion(suggestFieldName).text(inputText);

        //为suggestion的起一个查询别名
        String queryAlias = "title_suggest";
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion(queryAlias, termSuggestionBuilder);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.suggest(suggestBuilder);

        //指定查询的Index,装进SearchRequest里
        String indexName = "news_website";
        SearchRequest request = new SearchRequest(indexName);
        request.source(searchSourceBuilder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        if (!response.status().equals(RestStatus.OK)) {
            throw new RuntimeException("查询失败");
        }

        Suggest suggest = response.getSuggest();
        //获取建议结果
        TermSuggestion termSuggestion = suggest.getSuggestion(queryAlias);
        termSuggestion.getEntries().forEach((TermSuggestion.Entry entry) -> {
            System.out.println("您输入的是 : " + entry.getText());
            entry.forEach((TermSuggestion.Entry.Option option) ->
                    System.out.println("你是不是要找 : " + option.getText())
            );
        });
    }

    /**
     * 高亮关键字
     */
    private void highlight(RestHighLevelClient client) throws IOException {
        // 指定索引
        SearchRequest request = new SearchRequest("news_website");
        // 指定类型
        request.types("news");
        // 构建
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 构建查询体
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "小说");
        searchSourceBuilder.query(matchQueryBuilder);
        // 构建高亮设置
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        // 如果置为true，除非该字段的查询结果不为空才会被高亮
        highlightBuilder.requireFieldMatch(false);
        /*
           单字段单样式展示
           highlightBuilder.field("content").preTags("<hl>").postTags("</hl>");
         */
        // 多字段不同样式高亮展示
        HighlightBuilder.Field content = new HighlightBuilder.Field("content").preTags("<hl>").postTags("</hl>");
        HighlightBuilder.Field title = new HighlightBuilder.Field("title").preTags("<hlt>").postTags("</hlt>");
        highlightBuilder.field(content);
        highlightBuilder.field(title);

        searchSourceBuilder.highlighter(highlightBuilder);
        request.source(searchSourceBuilder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();

        hits.forEach(hit -> {
            System.out.println(hit.getSourceAsString());
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField highlight = highlightFields.get("content");
            if (highlight == null) {
                System.out.println("----------------------");
                return;
            }

            Text[] contentFragments = highlight.fragments();
            if (contentFragments != null) {
                for (Text fragment : contentFragments) {
                    System.out.println("content highlight :" + fragment);
                }
            }

            HighlightField highlightTitle = highlightFields.get("title");
            Text[] titleFragments = highlightTitle.fragments();
            if (titleFragments != null) {
                for (Text titleFragment : titleFragments) {
                    System.out.println("title highlight :" + titleFragment);
                }
            }
            System.out.println("----------------------");
        });
    }

    /**
     * 创建schema
     */
    private void createType(RestHighLevelClient client) throws IOException {
        /*
        {
          "mappings": {
            "news": {
              "properties": {
                "title": {
                  "type": "text",
                  "analyzer": "ik_max_word",
                  "fields": {
                    "suggest": {
                      "type": "completion",
                      "analyzer": "ik_max_word"
                    }
                  }
                },
                "content": {
                  "type": "text",
                  "analyzer": "ik_max_word"
                },
                "core": {
                  "type": "double"
                },
                "group": {
                  "type": "text"
                }
              }
            }
          }
        }
         */
        // 创建索引名
        CreateIndexRequest request = new CreateIndexRequest("news_website");
        String source = "{\n" +
                "      \"properties\" : {\n" +
                "        \"title\" : {\n" +
                "          \"type\": \"text\",\n" +
                "          \"analyzer\": \"ik_max_word\",\n" +
                "          \"fields\": {\n" +
                "            \"suggest\" : {\n" +
                "              \"type\" : \"completion\",\n" +
                "              \"analyzer\": \"ik_max_word\"\n" +
                "            }\n" +
                "          }\n" +
                "        },\n" +
                "        \"content\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "\t\"core\":{\n" +
                "\t\"type\":\"double\"\n" +
                "\t},\n" +
                "\t\"group\":{\n" +
                "\t\"type\":\"text\"\n" +
                "\t}\n" +
                "      }\n" +
                "    }";

        request.mapping("news", source, XContentType.JSON);
        CreateIndexResponse createIndexResponse = client.indices().create(request);
        //处理响应
        boolean acknowledged = createIndexResponse.isAcknowledged();
        boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();
        System.out.println("acknowledged :" + acknowledged + "|  shardsAcknowledged: " + shardsAcknowledged);

    }

    /**
     * 创建数据
     */
    private static String[] testData() {
        String[] strings = new String[5];

        strings[0] = "{\n" +
                "\n" +
                "  \"title\": \"大话西游电影\",\n" +
                "\n" +
                "  \"content\": \"大话西游的电影时隔20年即将在2017年4月重映\",\n" +
                "\n" +
                "  \"core\" : 9.6,\n" +
                "\n" +
                "  \"group\" : \"电影\"\n" +
                "\n" +
                "}";
        strings[1] = "{\n" +
                "\n" +
                "  \"title\": \"大话西游小说\",\n" +
                "\n" +
                "  \"content\": \"某知名网络小说作家已经完成了大话西游同名小说的出版\",\n" +
                "\n" +
                "  \"core\" : 8.7,\n" +
                "\n" +
                "  \"group\" : \"小说\"\n" +
                "\n" +
                "}";
        strings[2] = "{\n" +
                "\n" +
                "  \"title\": \"大话西游手游\",\n" +
                "\n" +
                "  \"content\": \"网易游戏近日出品了大话西游经典IP的手游，正在火爆内测中\",\n" +
                "\n" +
                "  \"core\" : 7.8,\n" +
                "\n" +
                "  \"group\" : \"游戏\"\n" +
                "\n" +
                "}";
        strings[3] = "{\n" +
                "\n" +
                "  \"title\": \"cxk唱跳rap\",\n" +
                "\n" +
                "  \"content\": \"鸡你太美,鸡你实在实在太美!!!\",\n" +
                "\n" +
                "  \"core\" : 7.8,\n" +
                "\n" +
                "  \"group\" : \"游戏\"\n" +
                "\n" +
                "}";
        strings[4] = "{\n" +
                "\n" +
                "  \"title\": \"大话西游手游\",\n" +
                "\n" +
                "  \"content\": \"大话西游手游2也出来了你期待不\",\n" +
                "\n" +
                "  \"core\" : 7.8,\n" +
                "\n" +
                "  \"group\" : \"游戏\"\n" +
                "\n" +
                "}";
        return strings;
    }

    private void addData(RestHighLevelClient client) throws IOException {
        // 批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        // 获取数据
        String[] datas = testData();
        // 循环添加任务
        for (int i = 0; i < datas.length; i++) {
            bulkRequest.add(
                    new IndexRequest("news_website", "news", i + 1 + "").source(datas[i], XContentType.JSON)
            );
        }
        BulkResponse response = null;
        //提交请求
        response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        // 返回请求状态
        if (response != null) {
            response.forEach(b -> {
                DocWriteRequest.OpType opType = b.getOpType();
                if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
                    log.info("创建数据成功!!!");
                } else if (opType == DocWriteRequest.OpType.UPDATE) {
                    log.info("更新数据成功!!!");
                } else if (opType == DocWriteRequest.OpType.DELETE) {
                    log.info("深处数据成功!!!");
                }
            });
        }
    }

    private void queryData(RestHighLevelClient client) throws IOException {

        SearchRequest searchRequest = new SearchRequest("news_website");
        searchRequest.types("news");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        // 处理返回值
        SearchHits hits = search.getHits();
        hits.forEach(hit -> {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
            System.out.println("---------------------------------");
        });
    }

    private RestHighLevelClient getClient(String hostName, Integer port) {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(hostName, port))
        );
    }
}
