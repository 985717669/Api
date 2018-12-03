package com.example.demo.easyExcel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

/**
 * @Author fengjf
 * @Desc    easyExcel使用工具类
 **/

public class ExcelUtil {

    /**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param response HttpServletResponse
     * @param list     数据 list，每个元素为一个 BaseRowModel
     * @param fileName 文件名，会自动加上.xlsx
     * @param clazz    list<class> list里泛型对象
     */
    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list, String fileName,
                                  Class clazz) throws IOException {
        if (fileName == null) {
            fileName = UUID.randomUUID().toString().replaceAll("-", "");
        }
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        if (!dbfFile.exists() || dbfFile.isDirectory()) {
            dbfFile.createNewFile();
        }
        fileName = new String(filePath.getBytes(), "ISO-8859-1");
        response.addHeader("Content-Disposition", "filename=" + fileName);
        OutputStream out = response.getOutputStream();
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(1, 0, clazz);
            sheet.setSheetName("sheet");
            writer.write(list, sheet);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                dbfFile.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel       Excel文件
     * @param object      映射对象
     * @param sheetNo     工作表索引
     * @param headlineNum 表头行数
     * @return
     */
    public static <T> List<T> readExcel(MultipartFile excel, BaseRowModel object, int sheetNo, int headlineNum) {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }

        // 第二个参数为表头行数，按照实际设置
        Sheet sheet = new Sheet(sheetNo, headlineNum, object.getClass());
        reader.read(sheet);
        return excelListener.getDatas();
    }

    /**
     * 返回 ExcelReader
     *
     * @param excel         需要解析的 Excel 文件
     * @param excelListener new ExcelListener()
     */
    private static ExcelReader getReader(MultipartFile excel,
                                         ExcelListener excelListener) {
        String filename = excel.getOriginalFilename();
        if (filename == null || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
//            throw new NormalException(BaseResult.ERROR, "文件格式错误！");
            throw new RuntimeException("文件格式错误");
        }

        ExcelTypeEnum excelTypeEnum = ExcelTypeEnum.XLSX;
        if (filename.toLowerCase().endsWith(".xls")) {
            excelTypeEnum = ExcelTypeEnum.XLS;
        }
        InputStream inputStream;
        try {
            inputStream = excel.getInputStream();
            return new ExcelReader(inputStream, excelTypeEnum,
                    null, excelListener);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
