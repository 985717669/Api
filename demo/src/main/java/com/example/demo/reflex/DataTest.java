package com.example.demo.reflex;

import java.util.Calendar;

/**
 * @Author fengjf
 * @Desc
 **/

public class DataTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("通过Calendar获得年:" + calendar.get(Calendar.YEAR));
        // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println("通过Calendar获得月:" + month);
        System.out.println("通过Calendar获得日:" + calendar.get(Calendar.DAY_OF_MONTH));
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);

        //求6月的最后一天
        // 假设求6月的最后一天
        int currentMonth = 6;
        // 先求出7月份的第一天，实际中这里6为外部传递进来的currentMonth变量
        // 1
        calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);
        calendar.add(Calendar.DATE, -1);
        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("6月的最后一天为:" + day);

    }
}
