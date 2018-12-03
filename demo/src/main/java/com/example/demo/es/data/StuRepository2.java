package com.example.demo.es.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author fengjf
 * @Desc
 **/
@Repository
public interface StuRepository2 extends ElasticsearchRepository<Stu, Long> {

}
