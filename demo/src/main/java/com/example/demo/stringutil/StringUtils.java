package com.example.demo.stringutil;

/**
 * @Author fengjf
 * @Desc 字符串工具类
 **/


public class StringUtils {
    public static void main(String[] args) {
        String test = "334";
        System.out.println(org.apache.commons.lang.StringUtils.trimToNull(test));
        System.out.println(test.trim());
        System.out.println(org.apache.commons.lang.StringUtils.leftPad(test,6,"*"));
        System.out.println(org.apache.commons.lang.StringUtils.rightPad(test,6)+"qq");
    }
}
