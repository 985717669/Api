package com.example.demo.lamda;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author fengjf
 * @Date 18-10-11
 * @Desc 测试排序
 **/

public class TestSort {

    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Person();
        person.setId(1);

        person.setName("fengjf");
        person.setSalary(100000);


        String jsonString = JSON.toJSONString(person);
        HashMap reqMap = JSON.parseObject(jsonString, LinkedHashMap.class);
        String sort = sort(reqMap);
        System.out.println(sort);


        System.out.println("======================");
        sort2(person);

    }


    private static String sort(Map requestParam) {
        Map<String, Object> sortedParams = new TreeMap<String, Object>();
        if ((requestParam != null) && (requestParam.size() > 0)) {
            sortedParams.putAll(requestParam);
        }
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = sortedParams.get(key);
            if (key != null && !"".equals(key) && value != null) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }

        return content.toString();
    }


    private static void sort2(Person person) {
        String s = JSON.toJSONString(person);
        HashMap hashMap = JSON.parseObject(s, HashMap.class);
        Set set = hashMap.keySet();
        List<String> list = new ArrayList<>(set);


        //集合工具类排序方法
        Collections.sort(list);
//        list.forEach(l -> System.out.println(l));
        System.out.println("--------");

        //lamdba 表达式方式排序
        List<String> collect = list.stream().sorted((p1, p2) -> p1.compareTo(p2)).collect(Collectors.toList());
//        collect.forEach(ll -> System.out.println(ll));

        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (int i = 0; i < collect.size(); i++) {
            String key = collect.get(i);
            Object value = hashMap.get(key);
            if (key != null && !"".equals(key) && value != null) {
                sb.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        System.out.println(sb);

        return;
    }


}
