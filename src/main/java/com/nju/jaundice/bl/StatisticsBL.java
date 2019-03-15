package com.nju.jaundice.bl;

import com.nju.jaundice.blservice.StatisticsBLService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StatisticsBL implements StatisticsBLService {
    @Override
    public int[] divideByWeeks() {
        return new int[0];
    }

    @Override
    public int[] divideByBloodType() {
        return new int[0];
    }

    @Override
    public int[] divideBySex() {
        return new int[0];
    }

    @Override
    public Map<String, Integer> divideByArea() {
        return null;
    }
}
