package com.nju.jaundice.controller;

import com.nju.jaundice.blservice.StatisticsBLService;
import com.nju.jaundice.dao.BabyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsBLService statisticsBLService;

    @Autowired
    private BabyDao babyDao;

    @RequestMapping(value = "/divideByWeeks",method = RequestMethod.POST)
    public @ResponseBody int[] divideByWeeks(){
        return null;
    }

    //已测试
    @RequestMapping(value = "/getBabySum",method = RequestMethod.GET)
    public @ResponseBody int getBabySum(){
        return statisticsBLService.babyNum();
    }

    //已测试
    //管理员输入年份，返回该年每月用户注册数
    @RequestMapping(value = "/getBabyIncreasePerMonth",method = RequestMethod.GET)
    public @ResponseBody int[] getBabyIncreasePerMonth(int year){
        return statisticsBLService.userIncrease(year);
    }

    //逻辑没写
    @RequestMapping(value = "/getLocation",method = RequestMethod.GET)
    public @ResponseBody
    Map<String,Integer> getLocation(){
        return null;
    }

    //已测试
    //返回一个长度为2的数组，array[0]是男的数量，array[1]是女的数量
    @RequestMapping(value = "/babySex",method = RequestMethod.GET)
    public @ResponseBody int[] getBabySex(){
        return statisticsBLService.getBabySex();
    }

    //已测试
    //array[0]-O型 array[1]-A型 array[2]-B型 array[3]-AB型 array[4]-其他
    @RequestMapping(value = "/babyBlood")
    public @ResponseBody int[] getBabyBlood(){
        return statisticsBLService.getBabyBlood();
    }

    //已测试
    //array[0]-<28周 array[1]-28~37周 array[2]-37~42周 array[3]->42周
    @RequestMapping(value = "/babyWeek")
    public @ResponseBody int[] getBabyWeek(){
        return statisticsBLService.getBabyWeek();
    }

    //已测试
    //平台数据总量
    @RequestMapping(value = "/dataSum")
    public @ResponseBody int getDataSum(){
        return statisticsBLService.getDataSum();
    }

    //已测试
    //数据增长曲线图
    @RequestMapping(value = "/dataIncrease",method = RequestMethod.POST)
    public @ResponseBody int[] getDataIncrease(int year){
        return statisticsBLService.getDataIncrease(year);
    }

}
