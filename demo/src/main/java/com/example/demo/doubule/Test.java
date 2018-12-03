package com.example.demo.doubule;

import java.math.BigDecimal;

/**
 * @Author fengjf
 * @Desc
 **/

public class Test {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(Double.toString(4.5555D));
        BigDecimal b2 = new BigDecimal(Double.toString(5.200D));
        double doubleValue = b1.add(b2).doubleValue();
        System.out.println(doubleValue);
    }
}
