package com.nju.jaundice.controller;

import com.nju.jaundice.blservice.AdminBLService;
import com.nju.jaundice.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "/admin")
public class AdminController {

    @Autowired
    private AdminBLService adminBLService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage adminLogin(String username,String password){
        return adminBLService.adminLogin(username,password);
    }

}
