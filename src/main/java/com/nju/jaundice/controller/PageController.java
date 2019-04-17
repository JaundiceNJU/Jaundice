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
        return "Home";
    }

    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public String getData(){
        return "Data";
    }

    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public String getStatistics(){
        return "Statistics";
    }

    @RequestMapping(value = "/userStatistics",method = RequestMethod.GET)
    public String getUserStatistics(){
        return "UserStatistics";
    }

    @RequestMapping(value = "/userHome",method = RequestMethod.GET)
    public String getUserHome(){
        return "UserHome";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String getPersonalPage(){
        return "PersonalPage";
    }


}
