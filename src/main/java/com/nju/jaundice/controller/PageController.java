package com.nju.jaundice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/jaundice",method = RequestMethod.GET)
    public String getIntroducePage(){
        return "user/Login";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getRegisterPage(){
        return "user/Register";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getHomePage(){
        return "admin_page/Home";
    }

    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public String getData(){
        return "admin_page/Data";
    }

    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public String getStatistics(){
        return "admin_page/Statistics";
    }


    @RequestMapping(value = "/userHome",method = RequestMethod.GET)
    public String getUserHome(){
        return "user_page/UserHome";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String getPersonalPage(){
        return "user_page/PersonalPage";
    }


}
