package com.example.demo.txt;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;

/**
 * @Author fengjf
 * @Desc 获取字符串中的所有电话号码
 */
public class TestTxt {
    public static void main(String[] args) {
        boolean equals = Objects.equals(1L, 1L);
        boolean aNull = Objects.nonNull(null);
        System.out.println(aNull);
        System.out.println(StringUtils.isBlank("dfd"));

    }
}
