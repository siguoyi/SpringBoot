package com.swad.controller;

import com.swad.model.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenlei on 2017/5/21.
 */

@RestController
public class HelloController {

    @Autowired
    private StudentProperties studentProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        return studentProperties.getSize();
    }
}
