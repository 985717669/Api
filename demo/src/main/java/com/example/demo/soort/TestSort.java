package com.example.demo.soort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengjf
 * @Desc
 **/

public class TestSort {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(4, 32, "袁绍"));
        list.add(new Student(6, 16, "曹操"));
        list.add(new Student(1, 25, "关羽"));
        list.add(new Student(2, 21, "张飞"));
        list.add(new Student(3, 18, "刘备"));
        list.add(new Student(5, 36, "赵云"));

//        System.out.println("==============排序前================");
//        list.forEach(student -> System.out.println(student.toString()));
//
//
//        //根据age排序
////        Collections.sort(list, Comparator.comparingInt(com.test.soort.Student::getId));
//
//        Collections.sort(list,Comparator.comparingInt(com.test.soort.Student::getAge).reversed());
//
//        System.out.println("==============排序后==========");
//        list.forEach(student -> System.out.println(student.toString()));
//
//
//
//        Map<Integer, List<com.test.soort.Student>> collect = list.stream().collect(Collectors.groupingBy(com.test.soort.Student::getAge));
//        System.out.println(collect);

        list.forEach(System.out::println);

    }
}
