package com.skd.swagger.controller;

import com.skd.starter.service.WrapService;
import com.skd.swagger.model.request.Person;
import com.skd.swagger.util.ExportUtil;
import com.skd.swagger.util.PdfUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author virgosnail
 * @Date 2019/4/10 22:07
 */
@Api(value = "test controller")
@RestController
public class PersonController {

    @Autowired
    private WrapService wrapService;

    @Autowired
    private ExportUtil exportUtil;

    @Autowired
    private PdfUtil pdfUtil;

    public static List<Person> list = new ArrayList();

    @RequestMapping(value = "/wrap", method = RequestMethod.GET)
    public String wrap(String str){
        return wrapService.wrap(str);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getPerson(@ModelAttribute Person request, HttpServletResponse response) throws Exception{
        String sheetName = "用户表";
        List data = list;
        List<String> titles = new ArrayList<>();
        titles.add("user");
        titles.add("age");
        titles.add("phoneNumber");
        String startTime = "2020-04-19 10:00:00";
        String endTime = "2020-04-19 12:00:00";
        String templateFilepath = "export/pdf/line.ftl";
//        response.setContentType("image/jpeg");
        ByteArrayOutputStream stream = exportUtil.pdf(sheetName, data, titles, startTime, endTime, templateFilepath);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(stream.toByteArray());
        outputStream.flush();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void postPerson(@RequestBody Person request){
        list.add(request);
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void putPerson(@RequestBody Person request){

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deletePerson(@ModelAttribute Person request){

    }
}
