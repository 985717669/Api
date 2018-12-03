package com.example.demo.test.test1;

/**
 * @Author fengjf
 * @Date 18-9-30
 * @Desc
 **/

public class Base {
    static {
        System.out.println("父类代码静态方法");
    }

    public Base() {
        System.out.println("父类的构造方法执行了");
    }
}
