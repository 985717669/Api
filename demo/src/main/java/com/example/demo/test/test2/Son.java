package com.example.demo.test.test2;

/**
 * @Author fengjf
 * @Date 18-9-30
 * @Desc
 **/

public class Son extends Father {
    static {
        System.out.println("Son 的静态方法执行了" );
    }

    public Son() {
        System.out.println("son 的 构造方法执行了");
    }

}

