package com.skd.swagger.util;

import com.github.liaochong.myexcel.core.ExcelBuilder;
import com.github.liaochong.myexcel.core.FreemarkerExcelBuilder;
import com.github.liaochong.myexcel.core.WorkbookType;
import com.github.liaochong.myexcel.utils.AttachmentExportUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Describe: Excel或PDF导出工具类
 * @Author: chenfan
 * @Date: 2020/3/27 18:21
 */
@Slf4j
@Component
public class ExportUtil {

    public static final String SHEET_NAME = "sheetName";
    public static final String TITLES = "titles";
    public static final String LIST = "list";
    public static final String MEMO = "memo";


    @Autowired
    PdfUtil pdfUtil;

    /**
     * @param sheetNameKey
     * @param data
     * @param titles
     * @param startTime
     * @param endTime
     * @param templateFilepath
     * @param response
     */
    public void excel(String sheetNameKey, List data, List<String> titles, String startTime, String endTime, String templateFilepath,
                      String filename, HttpServletResponse response) {
        try (ExcelBuilder excelBuilder = new FreemarkerExcelBuilder()) {
            Map param = getParam(sheetNameKey, data, titles, startTime, endTime);
            Workbook workbook = excelBuilder.classpathTemplate(templateFilepath).workbookType(WorkbookType.XLSX).build(param);
            AttachmentExportUtil.export(workbook, filename, response);
        } catch (Exception e) {
            log.warn("export excel occur a exception",e);
        }
    }

    /**
     * @param sheetNameKey
     * @param data
     * @param titles
     * @param startTime
     * @param endTime
     * @param templateFilepath
     * @return
     */
    public ByteArrayOutputStream pdf(String sheetNameKey, List data, List<String> titles, String startTime, String endTime, String templateFilepath) {
        Map param = getParam(sheetNameKey, data, titles, startTime, endTime);
        ByteArrayOutputStream pdf = pdfUtil.getPdf(templateFilepath, param);
        return pdf;
    }

    /**
     * @param sheetNameKey
     * @param data
     * @param titles
     * @param startTime
     * @param endTime
     * @return
     */
    public Map getParam(String sheetNameKey, List data, List<String> titles, String startTime, String endTime) {
        Map<String, Object> rstMap = new ConcurrentHashMap<>(4);
        List<String> memoList = new ArrayList<>(4);
        memoList.add("startTime");
        memoList.add("endTime");
        memoList.add(startTime);
        memoList.add(endTime);
        rstMap.put(MEMO, memoList);
        rstMap.put(LIST, data);
        rstMap.put(SHEET_NAME, sheetNameKey);
        rstMap.put(TITLES, titles);
        return rstMap;
    }
}
