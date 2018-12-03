package com.example.demo.reflex;

import lombok.Data;

/**
 * @Author fengjf
 * @Desc 反射实体
 **/
@Data
public class Person {
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
