package com.nju.jaundice.blservice;

import java.util.Map;

public interface StatisticsBLService {

    int[] divideByWeeks();

    int[] divideByBloodType();

    int[] divideBySex();

    Map<String , Integer> divideByArea();
}
