package com.example.demo.easyExcel;

import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengjf
 * @Desc 监听类，可以自定义
 **/

public  class ExcelListener<T extends BaseRowModel>  extends AnalysisEventListener<T> {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<T> datas = new ArrayList<>();


    private void doSomething(Object object) {
    }

    @Override
    public void invoke(T object, AnalysisContext context) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        datas.add(object);
        //根据自己业务做处理
        doSomething(object);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }


    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
