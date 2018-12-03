package com.example.demo.json;

import com.alibaba.fastjson.JSON;
import com.example.demo.es.transport.Student;

/**
 * @Author fengjf
 * @Desc
 **/


public class JSONTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1L);
        student.setAge(29);


        String s = JSON.toJSONString(student);
//        System.out.println(s);
//        String jsonString = JSONObject.toJSONString(student);
//        System.out.println(jsonString);
//
//        JSONObject jsonObject = JSON.parseObject(s);
//        System.out.println(jsonObject);
        System.out.println(s);
        Student student1 = JSON.parseObject(s, Student.class);
        System.out.println(student1.getName());


        String sss= JSON.toJSONString("中午");
        System.out.println(sss);


    }
}
