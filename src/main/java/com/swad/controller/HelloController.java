package com.swad.controller;

import com.swad.model.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenlei on 2017/5/21.
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private StudentProperties studentProperties;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "100") Integer id){
        return "id: " + id;
    }
}
