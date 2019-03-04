package com.nju.jaundice.controller;

import com.nju.jaundice.blservice.MeasureBLService;
import com.nju.jaundice.entity.Measure;
import com.nju.jaundice.vo.MeasureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "/measure")
public class MeasureController {

    @Autowired
    private MeasureBLService measureBLService;

    @RequestMapping(value = "/newRecord",method = RequestMethod.POST)
    public @ResponseBody
    void newRecord(String telephone,double jaundice, double height,double weight,String diet){
        measureBLService.recordMeasure(telephone, jaundice, height, weight, diet);
    }

    @RequestMapping(value = "/getMeasureByUser",method = RequestMethod.POST)
    public @ResponseBody
    List<Measure> getMeasureListByUsername(String username){
        return measureBLService.getMeasureListByUsername(username);
    }

    @RequestMapping(value = "/getDataList",method = RequestMethod.POST)
    public @ResponseBody List<MeasureVO> getDataList(){
        return measureBLService.getMeasureList();
    }
}
