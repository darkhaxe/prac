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
    public static void main(String[] args) {
        TestSuggest main = new TestSuggest();
//        main.createSchema();
//        main.addData();
        main.queryData();
        main.wrongSpell();
        main.highlight();
    }

    public RestHighLevelClient getClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("172.16.0.2", 9200))
        );
        return client;
    }

    void wrongSpell() {
        try (RestHighLevelClient client = this.getClient()) {
            SearchRequest request = new SearchRequest("news_website");

            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            SuggestBuilder suggestBuilder = new SuggestBuilder();

            TermSuggestionBuilder termSuggestionBuilder =
                    SuggestBuilders.termSuggestion("title.suggest").text("cxk长跳rwp");
            suggestBuilder.addSuggestion("title_suggest", termSuggestionBuilder);
            searchSourceBuilder.suggest(suggestBuilder);
            request.source(searchSourceBuilder);
            SearchResponse search = client.search(request, RequestOptions.DEFAULT);
            if (search.status().equals(RestStatus.OK)) {
                Suggest suggest = search.getSuggest();
                //获取建议结果
                TermSuggestion title_suggest = suggest.getSuggestion("title_suggest");
                title_suggest.getEntries().forEach(s -> {
                    System.out.println("您输入的是 : " + s.getText());
                    s.forEach(o -> {
                        System.out.println("你是不是要找 : " + o.getText());
                    });
                });
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void highlight() {
        try (RestHighLevelClient client = this.getClient();) {
            // 指定索引
            SearchRequest request = new SearchRequest("news_website");
            // 指定类型
            request.types("news");
            // 构建
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            //构建查询体
            MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "小说");
            searchSourceBuilder.query(matchQueryBuilder);
            // 构建高亮设置
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            //如果置为true，除非该字段的查询结果不为空才会被高亮
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

            SearchResponse search = client.search(request, RequestOptions.DEFAULT);

            SearchHits hits = search.getHits();

            hits.forEach(hit -> {
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                System.out.println(hit.getSourceAsString());
                HighlightField highlight = highlightFields.get("content");
                if (highlight != null) {
                    Text[] fragments = highlight.fragments();
                    if (fragments != null) {
                        for (int i = 0; i < fragments.length; i++) {
                            System.out.println("content highlight :" + fragments[i]);
                        }
                    }
                }

                HighlightField highlight_title = highlightFields.get("title");
                if (highlight != null) {
                    Text[] fragments = highlight_title.fragments();
                    if (fragments != null) {
                        for (int i = 0; i < fragments.length; i++) {
                            System.out.println("title highlight :" + fragments[i]);
                        }
                    }
                }
                System.out.println("----------------------");
            });
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * 创建schema
     */
    void createSchema() {
        try (RestHighLevelClient client = this.getClient()) {
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

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // 创建数据
    private static String[] getData() {
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

    void addData() {
        try (RestHighLevelClient client = this.getClient();) {
            // 批量插入数据
            BulkRequest bulkRequest = new BulkRequest();
            // 获取数据
            String[] datas = getData();
            // 循环添加任务
            for (int i = 0; i < datas.length; i++) {
                bulkRequest.add(
                        new IndexRequest("news_website", "news", i + 1 + "").
                                source(datas[i], XContentType.JSON)
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
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void queryData() {
        try (RestHighLevelClient client = this.getClient();) {
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
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
