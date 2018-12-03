package com.example.demo.es.transport;//package com.test.es;
//
//import com.alibaba.fastjson.JSON;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpHost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.nio.entity.NStringEntity;
//import org.apache.http.util.EntityUtils;
//import org.elasticsearch.client.Response;
//import org.elasticsearch.client.RestClient;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author fengjf
// * @Desc
// **/
//
//public class TestElastic {
//
//    //初始化一个客户端
//    static RestClient restClient = RestClient.builder(
//            new HttpHost("192.168.0.169", 9200, "http"),
//            new HttpHost("127.0.0.1", 9200, "http")).build();
//
//    public static void main(String[] args) {
//        getDocument();
//    }
//
//    // （2）验证es的某个索引是否存在
//    static void testIndex() throws RuntimeException {
//
//        Response response = null;
//        try {
//            response = restClient.performRequest("HEAD", "megacorp", Collections.<String, String>emptyMap());
//            System.out.println(JSON.toJSON(response));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(response.getStatusLine().getReasonPhrase().equals("OK"));
//
//    }
//
//    //，验证es集群是否搭建成功
//    static void test() {
//        Response response = null;
//        try {
//            response = restClient.performRequest("GET", "/", Collections.singletonMap("pretty", "true"));
//            System.out.println(JSON.toJSON(response));
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    static void del(String id) {
//
//        try {
//            Map<String, String> paramMap = new HashMap<String, String>();
//            paramMap.put("q", "id:" + id);
//            paramMap.put("pretty", "true");
//            Response response = restClient.performRequest("DELETE", "/megacorp/employee", paramMap);
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//    /**
//     * 获取文档
//     *
//     * @throws Exception
//     */
//    public static void getDocument() {
//        String method = "GET";
//        String endpoint = "/megacorp/employee/1";
//        Response response = null;
//        try {
//            response = restClient.performRequest(method, endpoint);
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 查询所有数据
//     *
//     * @throws Exception
//     */
//    public static  void QueryAll() throws Exception {
//        String method = "POST";
//        String endpoint = "/megacorp/employee/_search";
//        HttpEntity entity = new NStringEntity("{\n" +
//                "  \"query\": {\n" +
//                "    \"match_all\": {}\n" +
//                "  }\n" +
//                "}", ContentType.APPLICATION_JSON);
//
//        Response response = restClient.performRequest(method, endpoint, Collections.<String, String>emptyMap(), entity);
//        System.out.println(EntityUtils.toString(response.getEntity()));
//    }
//
//    /**
//     * 根据ID获取
//     *
//     * @throws Exception
//     */
//    public static void QueryByField() throws Exception {
//        String method = "POST";
//        String endpoint = "/megacorp/employee/_search";
//        HttpEntity entity = new NStringEntity("{\n" +
//                "  \"query\": {\n" +
//                "    \"match\": {\n" +
//                "      \"user\": \"kimchy\"\n" +
//                "    }\n" +
//                "  }\n" +
//                "}", ContentType.APPLICATION_JSON);
//
//        Response response = restClient.performRequest(method, endpoint, Collections.<String, String>emptyMap(), entity);
//        System.out.println(EntityUtils.toString(response.getEntity()));
//    }
//
//}
