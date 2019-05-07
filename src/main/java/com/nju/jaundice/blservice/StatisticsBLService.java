package com.nju.jaundice.blservice;

import java.util.Map;

public interface StatisticsBLService {

    //平台用户总数
    int babyNum();

    //总数增长曲线
    int[] userIncrease(int year);

    Map<String,Integer> getBabyIncrease();

    Map<String,Integer> getLocation();

    int[] getBabySex();

    int[] getBabyBlood();

    int[] getBabyWeek();

    int getDataSum();

    int[] getDataIncrease(int year);


    int[] divideByWeeks();

    int[] divideByBloodType();

    int[] divideBySex();

    Map<String , Integer> divideByArea();
}
