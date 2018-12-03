package com.example.demo.lamda;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author fengjf
 * @Desc
 **/

public class LamdaTest {

    private static final  Consumer<Person> consumer = person1 -> {
        person1.setSalary(200000);
        person1.setName("900");
    };


    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>() {
            {
                add(new Person(1, "Jaycob",  2000));
                add(new Person(2, "Brittany",  1500));
                add(new Person(3, "Donny",  1800));
                add(new Person(4, "Jonie",  1600));
                add(new Person(5, "Hervey",  1200));
                add(new Person(6, "Jaimie", 1900));
                add(new Person(7, "Randall",  2300));
            }
        };


        //consumer用法
        Person person = new Person(8, "张三", 10000);
        System.out.println(person);

        consumer.accept(person);
        System.out.println(person);


        System.out.println("给程序员加薪 5% :");
        Consumer<Person> giveRaise = a -> a.setSalary(a.getSalary() / 100 * 105);
        list.forEach(giveRaise);


        System.out.println("=================过滤===================");
        //filter 过滤
//		list.stream().filter(person1 -> person1.getSalary()>2000).forEach(person1 -> System.out.println(person1));


        //定义一个filter
        Predicate<Person> predicate = p -> p.getSalary()>1500;
        //限制行过滤， 然后执行limit限制
//		list.stream().filter(predicate).forEach(person1 -> System.out.println(person1));
        list.stream().filter(predicate).limit(3).forEach(person1 -> System.out.println(person1));
        System.out.println("=----------------------");
        list.stream().limit(3).filter(predicate).forEach(person1 -> System.out.println(person1));



        //限制前n个
        System.out.println("=============限制前n个===========");
        list.stream().limit(2).forEach(p -> System.out.println(p));


        System.out.println("==============求集合中最大最小值====================");
        Person person1 = list.stream().max((p1, p2) -> (p2.getSalary() - p1.getSalary())).get();
        System.out.println(person1);


        System.out.println("==================排序=========================");
        //根据工资进行排序呢
        List<Person> collect = list.stream().sorted((p1, p2) -> {
            return (p1.getSalary() - p2.getSalary());
        }).collect(Collectors.toList());
        collect.forEach(c -> System.out.println(c) );
        collect.stream().limit(3).forEach(c1 -> System.out.println(c1));//取前三个
        System.out.println("--------------------------------");
        //根据name排序
        List<Person> collect1 = list.stream().sorted((p1, p2) -> (p1.getName().compareTo(p2.getName()))).collect(Collectors.toList());
        collect1.forEach(c2 -> System.out.println(c2));


        System.out.println("==============统计==================");

        IntSummaryStatistics statistics = list.stream().mapToInt((x) -> x.getSalary()).summaryStatistics();
        System.out.println("工资最大:"+statistics.getMax());
        System.out.println("所有人的工资综合"+ statistics.getSum());
        System.out.println("最小的工资" + statistics.getMin());
        System.out.println(statistics.toString());

    }
}
