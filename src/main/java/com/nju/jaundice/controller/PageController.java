package com.nju.jaundice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/jaundice",method = RequestMethod.GET)
    public String getIntroducePage(){
        return "Jaundice";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getHomePage(){
        return "Home";
    }

    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public String getData(){
        return "Data";
    }


}
