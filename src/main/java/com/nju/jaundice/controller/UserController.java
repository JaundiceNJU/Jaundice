package com.nju.jaundice.controller;

import com.nju.jaundice.blservice.AdminBLService;
import com.nju.jaundice.blservice.UserBLService;
import com.nju.jaundice.entity.Baby;
import com.nju.jaundice.util.Blood;
import com.nju.jaundice.util.ResultMessage;
import com.nju.jaundice.util.Role;
import com.nju.jaundice.util.Sex;
import com.nju.jaundice.vo.BabyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller(value = "/user")
public class UserController {

    @Autowired
    private UserBLService userBLService;
    @Autowired
    private AdminBLService adminBLService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage register(String telephone,String password){
        return userBLService.register(telephone,password);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage login(String username,String password){
        if(username.equals("admin")){
            return adminBLService.adminLogin(username,password);
        }else {
            return userBLService.login(username, password);
        }
    }

    @RequestMapping(value = "/complete",method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage completeInfo(String telephone, Role parent, String nickname, Sex sex, int week, Blood blood,
                                Date bornTime, double height, double weight, String area, String hospital){
        return userBLService.completeInfo(telephone,parent,nickname,sex,week,blood,bornTime,height,weight,area,hospital);
    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<BabyVO> getUserInfo(){
        return userBLService.getUserInfoList();
    }

    @RequestMapping(value = "/getOneUserInfo", method = RequestMethod.POST)
    public @ResponseBody
    BabyVO getOneUserInfo(String username){
        return userBLService.getOneUserInfo(username);
    }

    @RequestMapping(value = "/saveNewUser",method = RequestMethod.POST)
    public @ResponseBody ResultMessage saveNewUser(String tel,String babyName,int week,double height,double weight,String area,String hospital,String parent,String blood,String birthday,String sex){
        return userBLService.saveNewUser(tel, babyName, week, height, weight, area, hospital, parent, blood, birthday, sex);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public @ResponseBody ResultMessage deleteUser(String tel){
        String newTel=tel.substring(1,tel.length()-1);
//        System.err.print(newTel);
        return userBLService.deleteUser(newTel.split(","));
    }

}
