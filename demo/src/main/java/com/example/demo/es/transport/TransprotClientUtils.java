package com.example.demo.es.transport;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author fengjf
 * @Desc es工具类
 **/
@Component
public class TransprotClientUtils<T> {


    /**
     * ElasticSearch客户端
     * 获取操作连接
     *
     * @return
     */
    public static TransportClient getTransportClient() {
        // 集群设置
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        //添加集群地址和tcp服务端口 IP是由集群的各个node的ip组成的数组
        String[] ips = {"127.0.0.1"};
        try {
            for (int i = 0; i < ips.length; i++) {
                client.addTransportAddresses(new TransportAddress(InetAddress.getByName(ips[i]), 9300));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }


    /**
     * 判断索引是否存在
     */
    public static boolean checkIndexExist(String index) {
        TransportClient client = getTransportClient();
        return client.admin().indices().prepareExists(index).execute().actionGet().isExists();
    }


    /**
     * 判断index下指定type是否存在
     *
     * @param index
     * @param type
     * @return
     */
    public static boolean checkTypeExist(String index, String type) {
        TransportClient client = getTransportClient();
        return checkIndexExist(index) ? client.admin().indices().prepareTypesExists(index).setTypes(type).execute().actionGet().isExists() : false;
    }

    /**
     * 删除索引
     *
     * @param index
     * @return
     */
    public static boolean deleteIndex(String index) {
        TransportClient client = getTransportClient();
        return checkIndexExist(index) ? client.admin().indices().prepareDelete(index).execute().actionGet().isAcknowledged() : false;
    }

    /**
     * 新增索引, 先检查是否存在, 如已经存在,返回 false
     *
     * @param index
     * @return int 1:新增成功, 2:已存在不需要重复新增, 3:失败
     */
    public static Integer addIndex(String index) {
        TransportClient client = getTransportClient();//获得客户端
        if (checkIndexExist(index)) {
            return 2;
        }
        boolean result = client.admin().indices().prepareCreate(index).execute().actionGet().isAcknowledged();
        if (result) {
            return 1;
        } else {
            return 3;
        }
    }

    /**
     * 新增类型
     *
     * @param index
     * @param type
     * @return
     * @throws IOException
     */
    public static boolean addIndexAndType(String index, String type) throws IOException {
        TransportClient client = getTransportClient();
        //创建索引映射,相当于创建数据库中的表操作
        CreateIndexRequestBuilder cib = client.admin().indices().prepareCreate(index);
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("properties")
                .startObject("goodsName").field("type", "text").endObject()
                .startObject("goodsPrice").field("type", "double").endObject()
                .startObject("goodsUser").field("type", "text").endObject()
                .startObject("goodsTime").field("type", "date").field("format", "yyyy-MM-dd HH:mm:ss")
                .endObject()
                .endObject().endObject();
        cib.addMapping(type, mapping);
        return cib.execute().actionGet().isAcknowledged();
    }


    /**
     * 新增一条数据,(索引和类型不存在则创建---使用默认数据类型)
     *
     * @param index
     * @param type
     * @return
     * @throws IOException
     */
    public static long addDocument(String index, String type) throws IOException {
        TransportClient client = getTransportClient();
        // 自定义主键id,这个id也可以不要,让es自动为我们生成id
        String id = UUID.randomUUID().toString().replace("-", "");
        // 创建文档,相当于往表里面insert一行数据
        IndexResponse response = client.prepareIndex(index, type, id).setSource(XContentFactory.jsonBuilder().startObject()// 开始
                .field("goodsName", "大学英语")// 商品名称
                .field("goodsPrice", 22.33)// 商品价格
                .field("goodsUser", "大拿")// 商品主人
                .field("goodsTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))// 商品上架时间
                .endObject()).get();
        return response.getVersion();
    }

    /**
     * 新增一条数据,(索引和类型不存在则创建---使用默认数据类型)
     *
     * @param index
     * @param type
     * @return
     * @throws IOException
     */
    public static long addDocument2(String index, String type) throws IOException {
        TransportClient client = getTransportClient();
        // 自定义主键id,这个id也可以不要,让es自动为我们生成id
        String id = UUID.randomUUID().toString().replace("-", "");
        // 创建文档,相当于往表里面insert一行数据
        IndexResponse response = client.prepareIndex(index, type, id).setSource(XContentFactory.jsonBuilder().startObject()
                .field("goodsName", "大学英语")// 商品名称
                .field("goodsPrice", 22.33)// 商品价格
                .field("goodsUser", "大拿")// 商品主人
                .field("goodsTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))// 商品上架时间
                .endObject()).get();
        return response.getVersion();
    }

    /**
     * 新增数据, 索引/类型不存在,新增
     *
     * @param index 指定索引
     * @param type  指定类型
     * @param date  对象数据
     * @param <T>   支持泛型
     * @return
     * @throws IOException
     */
    public static <T> void addDocument(String index, String type, T date) throws IOException {
        Class<?> aClass = date.getClass();
        System.out.println(aClass);
        checkIndexAndType(index, type, date.getClass());

        TransportClient client = getTransportClient();

        // 自定义主键id,这个id也可以不要,让es自动为我们生成id
//        String id = UUID.randomUUID().toString().replace("-", "");
//        // 创建文档,相当于往表里面insert一行数据
//        IndexResponse response = client.prepareIndex(index, type, id).setSource(XContentFactory.jsonBuilder().startObject()
//                .field("goodsName", "大学英语")// 商品名称
//                .field("goodsPrice", 22.33)// 商品价格
//                .field("goodsUser", "大拿")// 商品主人
//                .field("goodsTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))// 商品上架时间
//                .endObject()).get();

    }

    /**
     * 检查索引和类型是否存在, 不存在则创建
     *
     * @param index
     * @param type
     */
    public static void checkIndexAndType(String index, String type, Class clazz) throws IOException {
        //判断索引是否存在, 不存在则创建索引
        if (!checkIndexExist(index)) {
            Integer result = addIndex(index);
            if (result == null || result == 3) {
                throw new RuntimeException("新增失败");
            }
        }
        /**
         * 校验类型是否存在, 不存在则创建
         */
        if (!checkTypeExist(index, type)) {
            addIndexAndType(index, type, clazz);
        }
    }

    /**
     * 查询指定索引下的所有数据
     *
     * @param index
     */
    public void searchAllQuery(String index) {
        TransportClient client = getTransportClient();
        QueryBuilder query = QueryBuilders.matchAllQuery();
        SearchResponse response = client.prepareSearch(index).setQuery(query).execute().actionGet();
        for (SearchHit searchHit : response.getHits()) {
            String jsonStr = searchHit.getSourceAsString();
            System.out.println(jsonStr);
        }
    }

    /**
     * 查询指定类型下的所有数据
     *
     * @param index
     * @param type
     */
    public static <T> List<T> searchAllQueryInType(String index, String type, Class clazz) {
        TransportClient client = getTransportClient();
        SearchResponse response = client.prepareSearch(index).setTypes(type).execute().actionGet();
        List<T> list = new ArrayList<>();
        for (SearchHit searchHit : response.getHits()) {
            String jsonStr = searchHit.getSourceAsString();
            System.out.println(jsonStr);
            T object = (T) JSON.parseObject(jsonStr, clazz);
            list.add(object);
        }
        return list;
    }

    /**
     * 根据Id删除一个文档
     *
     * @param index
     * @param type
     * @param id
     * @return
     */
    public static String deleteDocument(String index, String type, String id) {
        TransportClient client = getTransportClient();
        return client.prepareDelete(index, type, id).get().getId();
    }


    /**
     * 根据Id查询文档
     *
     * @param index
     * @param type
     * @param id
     */
    public static String searchById(String index, String type, String id) {
        TransportClient client = getTransportClient();
        GetResponse response = client.prepareGet(index, type, id).execute().actionGet();
        String jsonStr = response.getSourceAsString();
        if (jsonStr != null) {
            System.out.println(jsonStr);
            return jsonStr;
        } else {
            System.out.println("没有查到");
            return null;
        }
    }

    /**
     * 新增索引,类型, 泛型
     *
     * @param index 指定索引
     * @param type  指定类型
     * @param clazz 映射对象
     * @return
     */
    public static boolean addIndexAndType(String index, String type, Class clazz) throws IOException {
        TransportClient client = getTransportClient();
        Field[] fields = clazz.getDeclaredFields();
        //创建索引映射,相当于创建数据库中的表操作
        CreateIndexRequestBuilder cib = client.admin().indices().prepareCreate(index);
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("properties");
        mapping.field("goodsName", "大学英语");// 商品名称
//        for (int i = 0; i < fields.length; i++) {
//            String name = fields[i].getName();
//            String fieldTye = getFieldTye(fields[i]);
//            if (fields.equals("date")) {
//                mapping.startObject(name).field("type", "date").field("format", "yyyy-MM-dd HH:mm:ss");
//            } else {
//                mapping.startObject(name).field("type", fieldTye).endObject();
//            }
//
//        }
        mapping.endObject()
                .endObject().endObject();
        cib.addMapping(type, mapping);
        return cib.execute().actionGet().isAcknowledged();
    }


    /**
     * 字段类型映射到 es
     *
     * @param field
     * @return
     */
    private static String getFieldTye(Field field) {
        String targetType = "";
        switch (field.getType().toString().trim()) {
            case "int":
                targetType = "integer";
                break;
            case "class java.lang.Long":
                targetType = "long";
                break;
            case "double":
                targetType = "double";
                break;
            case "long":
                targetType = "long";
                break;
            case "class java.lang.Double":
                targetType = "double";
                break;
            case "class java.lang.Integer":
                targetType = "integer";
                break;
            case "class java.lang.Boolean":
                targetType = "boolean";
                break;
            case "boolean":
                targetType = "boolean";
                break;
            case "class java.lang.Float":
                targetType = "float";
                break;
            case "float":
                targetType = "float";
                break;
            case "class java.lang.String":
                targetType = "text";
                break;
            case "class java.math.BigDecimal":
                targetType = "double";
                break;
            case "class java.util.Date":
                targetType = "date";
                break;
        }
        return targetType;
    }

}