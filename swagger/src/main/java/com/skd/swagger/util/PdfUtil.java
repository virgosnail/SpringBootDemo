package com.skd.swagger.util;

import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @Filename pdf打印
 * @Description
 * @Version 1.0
 * @Author lx
 * @History <li>Author: lx</li>
 * <li>Date: </li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Component
@Slf4j
public class PdfUtil {

    @Autowired
    private Configuration config;

    public ByteArrayOutputStream getPdf(String pdfTemplatePath, Map<String,Object> rstMap){
        String pdfBase64 = "";
        try {
            Template template = config.getTemplate(pdfTemplatePath);
            template.setEncoding("UTF-8");
            Writer writer = new StringWriter();
            //数据填充模板
            template.process(rstMap, writer);
            String str = writer.toString();
            //pdf生成
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();


            ITextRenderer iTextRenderer = new ITextRenderer();
            iTextRenderer.setDocumentFromString(str);


            //设置字体  其他字体需要添加字体库
            ITextFontResolver fontResolver = iTextRenderer.getFontResolver();
            fontResolver.addFont("/export/font/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            iTextRenderer.setDocument(builder.parse(new ByteArrayInputStream(str.getBytes())), null);
            iTextRenderer.layout();

            //生成PDF
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            iTextRenderer.createPDF(baos);
            baos.close();
            return baos;
//            Base64.Encoder encoder = Base64.getEncoder();
//            pdfBase64 = encoder.encodeToString(baos.toByteArray());
        }catch (Exception e){
            log.error("生成pdf失败：{}",e);
            return null;
        }

    }
}
