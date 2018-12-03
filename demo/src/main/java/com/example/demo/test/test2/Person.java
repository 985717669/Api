package com.example.demo.test.test2;

import lombok.Data;

/**
 * @Author fengjf
 * @Date 18-9-30
 * @Desc
 **/
@Data
public class Person {
    String name;

    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
