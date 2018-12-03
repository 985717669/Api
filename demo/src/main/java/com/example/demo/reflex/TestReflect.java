package com.example.demo.reflex;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author fengjf
 * @Desc   反射测试
 **/

public class TestReflect {
    public static void main(String[] args) throws Exception {
        Person person = new Person("zhangsan", 23);

        Class clazz = person.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(person);

            System.out.println(key + ":" + value+" type: "+field.getType());

        }

    }
}
