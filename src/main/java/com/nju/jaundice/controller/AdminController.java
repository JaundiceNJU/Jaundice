package com.nju.jaundice.controller;

import com.nju.jaundice.blservice.AdminBLService;
import com.nju.jaundice.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @Autowired
    private AdminBLService adminBLService;



    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String adminLoginPage(){
        return "Login";
    }

}
