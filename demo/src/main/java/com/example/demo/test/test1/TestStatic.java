package com.example.demo.test.test1;

/**
 * @Author fengjf
 * @Date 18-9-30
 * @Desc static关键字 测试
 **/

public class TestStatic extends Base {
    static {
        System.out.println("子类的静态方法");
    }

    public TestStatic() {
        System.out.println("子类的构造方法");
    }


}
