package com.example.demo.data;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author fengjf
 * @Desc
 */
public class DateUtil {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        int hours = time.getHours();
        System.out.println(hours);
        if (hours>22 || hours<7){
            System.out.println("夜间兽药");
        }else {
            System.out.println("不是夜间兽药");
        }


        System.out.println(new Date(System.currentTimeMillis() + 60 * 60 * 1));
    }
}
