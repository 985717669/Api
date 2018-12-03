package com.example.demo.es.transport;

import java.io.IOException;

/**
 * @Author fengjf
 * @Desc es 测试
 **/

public class TransportClientTest {


    public static void main(String[] args) {


        try {
            TransprotClientUtils.addIndexAndType("teest", "test");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        TransprotClientUtils.deleteIndex("test");
//
//
//        Student student = new Student();
//        student.setId(10L);
//        student.setAge(10);
//        student.setName(5.2D);
//        student.setDesc("默哀书");
//        try {
//            TransprotClientUtils.addDocument("comm", "student", student);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        System.out.println("判断inde下指定type是否存在"+transportClientTest.isTypeExist("megacorp", "employee"));
//        System.out.println("执行删除索引");
//        long startTime = System.currentTimeMillis();
//        transportClientTest.deleteIndex("megacorp");
//        long endTime = System.currentTimeMillis();
//        System.out.println("执行删除索引结束, 用时"+(endTime-startTime)+"ms");
//        System.out.println("判断索引是否存在"+transportClientTest.isIndexExist("megacorp"));

//        boolean megacorp = transprotClientUtils.addIndex("megacorp");
//        if(megacorp){
//            System.out.println("新增成功");
//        }
//        System.out.println("判断索引是否存在"+transprotClientUtils.isIndexExist("megacorp"));
//        try {
//            TransprotClientUtils.addIndexAndType("comm","good");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("索引类型是否存在" + TransprotClientUtils.checkTypeExist("comm", "good"));
//        try {
//            System.out.println("新增数据");
//            long startTime = System.currentTimeMillis();
//            TransprotClientUtils.addDocument("comm2", "good");
//            long endTime = System.currentTimeMillis();
//            System.out.println("新增数据, 用时"+(endTime-startTime)+"ms");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//
//        String result = TransprotClientUtils.searchById("comm", "good", "4e6247eb8d3b4716959d512611aea389");
//        if (StringUtils.isNotBlank(result)) {
//            Good student = JSON.parseObject(result, Good.class);
//            System.out.println(student);
//        }


//        System.out.println("新增数据");
//        long startTime = System.currentTimeMillis();
//        List<Object> list = TransprotClientUtils.searchAllQueryInType("comm", "good", Good.class);
//        long endTime = System.currentTimeMillis();
//        System.out.println("新增数据, 用时" + (endTime - startTime) + "ms");
//        System.out.println(list.size());


    }


}
