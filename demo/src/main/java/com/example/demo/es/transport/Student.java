package com.example.demo.es.transport;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author fengjf
 * @Desc
 **/
@Data
public class Student {
    private Long id;
    private long id2;
    private double name;
    private Double name2;
    private Integer age2;
    private int age;
    private Boolean isTrue;
    private boolean isTrue2;
    private Float fa;
    private float fa2;

    private Date birthDay;
    private String desc;
    private BigDecimal salay;


}
