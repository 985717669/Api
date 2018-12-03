package com.example.demo.es.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author fengjf
 * @Desc jpa 工具类
 **/

public class SpringDataElasticUtils<T> {

    private static StuEsRepository stuEsRepository;

    static {
        if (stuEsRepository == null) {
            stuEsRepository = getEsClintInstance();
        }
    }

    public static StuEsRepository getEsClintInstance() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-es.xml");
        StuEsRepository stuEsRepository = ac.getBean(StuEsRepository.class);
        return stuEsRepository;
    }

    public static <T> void save(Stu data) {
        stuEsRepository.save(data);
    }

}
