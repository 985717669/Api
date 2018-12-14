package com.example.demo.soort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengjf
 * @Desc
 */
public class CollTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i+"");
        }

        List<String> strings = list.subList(0,2);
        System.out.println(strings);
    }
}
