package com.example.demo.es.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author fengjf
 * @Desc
 **/
@Document(indexName = "stu", type = "doc")
@Data
public class Stu implements Serializable {


    private static final long serialVersionUID = -8206932750222554594L;
    
    @Id
    @Field
    private Long id;

    @Field()
    private String stuId;

    @Field
    private String stuName;

    @Field
    private Date createTime;




    public Stu() {
    }

    public Stu(Long id, String stuId, String stuName) {
        this.id = id;
        this.stuId = stuId;
        this.stuName = stuName;
    }

}
