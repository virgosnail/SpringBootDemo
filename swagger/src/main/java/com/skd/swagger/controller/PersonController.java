package com.skd.swagger.controller;

import com.skd.swagger.model.request.Person;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author virgosnail
 * @Date 2019/4/10 22:07
 */
@Api(value = "test controller")
@RestController
public class PersonController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getPerson(@ModelAttribute Person request){

    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void postPerson(@RequestBody Person request){

    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void putPerson(@RequestBody Person request){

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deletePerson(@ModelAttribute Person request){

    }
}
