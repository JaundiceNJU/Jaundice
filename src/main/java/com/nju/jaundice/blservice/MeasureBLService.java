package com.nju.jaundice.blservice;

import com.nju.jaundice.entity.Measure;
import com.nju.jaundice.vo.MeasureVO;

import java.util.List;

public interface MeasureBLService {

    void recordMeasure(String telephone,double jaundice, double height,double weight,String diet);

    List<Measure> getMeasureListByTime();

    List<Measure> getMeasureListByUsername(String username);

    List<MeasureVO> getMeasureList();
}
