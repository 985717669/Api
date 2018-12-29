package com.example.demo.redis;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * Author fengjf
 * Desc redis测试
 */
public class RedisTest {
    public static void main(String[] args) {
        String regular = "(1|2)$";
        String picType = "2";
        boolean matches = Pattern.matches(regular, picType);
        System.out.println(matches);

    }
}
