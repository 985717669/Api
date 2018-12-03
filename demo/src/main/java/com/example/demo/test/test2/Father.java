package com.example.demo.test.test2;

/**
 * @Author fengjf
 * @Date 18-9-30
 * @Desc static关键字 测试
 **/

public class Father {
    static {
        System.out.println("Father 的 静态方法执行了");
    }
    public Father() {
        System.out.println("Father  的构造方法执行了");
    }




}
