package com.nju.jaundice.blservice;

import com.nju.jaundice.entity.Measure;
import com.nju.jaundice.util.ResultMessage;
import com.nju.jaundice.vo.MeasureVO;

import java.util.List;

public interface MeasureBLService {

    void recordMeasure(String telephone,double jaundice, double height,double weight,String diet);

    List<Measure> getMeasureListByTime();

    List<MeasureVO> getMeasureListByUsername(String username);

    List<MeasureVO> getMeasureList();

    ResultMessage saveNewData(String tel, double ice_lesion, String messure_time, double height, double weight, String diet);

    ResultMessage deleteData(String[] id);
}
