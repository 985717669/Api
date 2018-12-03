package com.example.demo.es.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author fengjf
 * @Desc data接口
 **/
@Repository
public interface StuEsRepository extends ElasticsearchRepository<Stu, Long> {

    /**
     * 根据stuId查询
     *
     * @param stuId
     * @return
     */
    Stu getByStuId(String stuId);

    /**
     * 获取查询列表
     *
     * @param stuName
     * @return
     */
    List<Stu> getListByStuName(String stuName);

    /**
     * 分页查询
     *
     * @param stuName
     * @param pageable
     * @return
     */
    Page<Stu> getPageByStuName(String stuName, Pageable pageable);

}
