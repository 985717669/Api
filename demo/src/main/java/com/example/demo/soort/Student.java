package com.example.demo.soort;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @Author fengjf
 * @Desc
 **/

@Data
public class Student extends BaseRowModel {

    @ExcelProperty(value = "ID", index = 0)
    private int id;

    @ExcelProperty(value = "年龄", index = 1)
    private int age;

    @ExcelProperty(value = "姓名", index = 2)
    private String name;


    public Student() {
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}
