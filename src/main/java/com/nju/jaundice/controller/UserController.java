package com.nju.jaundice.controller;

import com.nju.jaundice.blservice.UserBLService;
import com.nju.jaundice.entity.Baby;
import com.nju.jaundice.util.Blood;
import com.nju.jaundice.util.ResultMessage;
import com.nju.jaundice.util.Role;
import com.nju.jaundice.util.Sex;
import com.nju.jaundice.vo.BabyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller(value = "/user")
public class UserController {

    @Autowired
    private UserBLService userBLService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage register(String telephone,String password){
        return userBLService.register(telephone,password);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage login(String telephone,String password){
        return userBLService.login(telephone,password);
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

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public @ResponseBody
    List<Integer> test(){
        List<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        return a;
    }
}
