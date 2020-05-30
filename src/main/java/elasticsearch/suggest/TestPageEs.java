package elasticsearch.suggest;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * 分页查询
 * @link https://www.cnblogs.com/wangrudong003/p/10959525.html
 * @author haxe
 * @date created at 2019/12/26 11:36
 */
public class TestPageEs {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("172.16.0.2", 9200)));

        //        main.createType(client);
//        main.addData(client);
        String indexName = "t_waybill_order";
        String typeName = "camphor_tree";


        // 指定索引
        SearchRequest request = new SearchRequest(indexName);
        // 指定类型
        request.types(typeName);
        // 构建
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();


        //查询条件，可以参考官网手册
        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.types(typeName);
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//        boolQuery.must(QueryBuilders.wildcardQuery("host", "10.229.208.*"));
//        boolQuery.must(QueryBuilders.matchQuery("message", "DISPLAY_CMDRECORD"));
//        boolQuery.must(QueryBuilders.matchQuery("message", "SUPPRESS_LOG"));
        boolQuery.must(QueryBuilders.termQuery("billNo", "SF74444021038411727"));
//        boolQuery.filter(QueryBuilders.rangeQuery("@timestamp").gte(start).lte(end));
        MatchAllQueryBuilder matchAllQuery = QueryBuilders.matchAllQuery();
//        TermQueryBuilder termQuery = QueryBuilders.termQuery("id",414820864915542016L);
//        searchSourceBuilder.query(termQuery);
        searchSourceBuilder.query(boolQuery);
//        searchSourceBuilder.query(matchAllQuery);
        //返回:包含字段,移除字段
//        String[] includeFields = new String[] {};
        String[] excludeFields = new String[] {"*"};
        searchSourceBuilder.fetchSource(null, excludeFields);
        //设置分页参数 todo pageIndex计算
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10);
        //默认根据主键倒序排列
        searchSourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.DESC));
        searchRequest.source(searchSourceBuilder);
        try {
            // 构建查询体
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit hit : searchHits) {
                System.out.println(hit.getSourceAsString());
            }
        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        throw new UnsupportedOperationException("");
    }
}
