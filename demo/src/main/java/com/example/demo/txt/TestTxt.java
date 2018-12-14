package com.example.demo.txt;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author fengjf
 * @Desc 获取字符串中的所有电话号码
 */
public class TestTxt {
    public static void main(String[] args) {
        String text = "13522158842;托尔斯泰,test2;13000002222,17711113313,1995555555u";
        Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[358]\\d{9})|(1[358]\\d{9}))(?!\\d)");

        Matcher matcher = pattern.matcher(text);
        StringBuffer bf = new StringBuffer(64);
        while (matcher.find()) {
            boolean b = matcher.find();
            String group = matcher.group();
            bf.append(matcher.group()).append(",");
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }

        System.out.println(bf.toString());
    }
}
