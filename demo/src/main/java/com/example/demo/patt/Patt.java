package com.example.demo.patt;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author fengjf
 * @Desc 正则表达式
 **/

public class Patt {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        map.put("2", "$5");

        String s = JSON.toJSONString(map);

        System.out.println(s);

        Map map1 = JSON.parseObject(s, Map.class);
        System.out.println(map1);

        Long a = -1L;
        boolean re = a.equals(-1L);
        System.out.println("args = [" + re);


        //校验只能输入中文
        String pattern = "[\u4e00-\u9fa5]+";


        boolean isMatch = Pattern.matches(pattern, "椎间 盘+美国沃尔玛".trim().replaceAll(" ", ""));
        System.out.println("校验结果为" + isMatch);


        String p = "newUser|ta|me";

        System.out.println("艳艳结果为：" + Pattern.matches(p, " me ".trim()));


        //居民身份证
        String cdCord = "(^\\d{18}$)|(^\\d{15}$)|(^\\d{17}[xX]$)|(^\\d{14}[xX]$)";
        String cord = "41042219900400x";
        System.out.println("长度" + cord.length());
        boolean matches = Pattern.matches(cdCord, cord);
        System.out.println("是否是身份证" + matches);

        System.out.println("+++=========================");
        String pat = "[00-99]$";
        System.out.println(Pattern.matches(p, "01"));

        String REG_MOBILE = "((13[0-9])|(14[7])|(15([0-3]|[5-9]))|(16[6])|(17[0-9])|(18[0-9])|(19[8|9]))\\d{8}$"; // 手机号码格式;
        String mobile = "16637552980";
        System.out.println(Pattern.matches(REG_MOBILE, mobile));

    }
}
