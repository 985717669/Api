package com.example.demo.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author fengjf
 * @Desc 反射测试
 **/

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

//        Class studentClass = Student.class;
        Class studentClass = Class.forName("com.test.soort.Student");
        Field[] declaredFields = studentClass.getDeclaredFields();
        System.out.println("====================类的方法=====================");
        Method[] methods = studentClass.getMethods();//获取累的所有方法
        for (Method method : methods) {
            System.out.print(method+"&&&&");
//            System.out.print(method.getReturnType());
            System.out.println(method.getName());//获得方法名， 包含 get set 以及类的方法
            System.out.println();
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
        }

        System.out.println("====================类的成员变量=====================");
        for (Field declaredField : declaredFields) {

            System.out.print("字段名称:"+declaredField.getName()+", ");
            System.out.println("字段类型:"+declaredField.getType());
        }

        System.out.println("====================类的构造方法=====================");
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.print(constructor.getName()+"(");
            //获取构造函数的参数列表---》得到的是参数雷彪的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName()+",");
            }
            System.out.println(")");
        }

    }
}
