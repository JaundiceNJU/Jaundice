package com.nju.jaundice.controller;

import com.nju.jaundice.blservice.MeasureBLService;
import com.nju.jaundice.entity.Measure;
import com.nju.jaundice.util.ResultMessage;
import com.nju.jaundice.vo.MeasureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    List<MeasureVO> getMeasureListByUsername(String username){
        return measureBLService.getMeasureListByUsername(username);
    }

    @RequestMapping(value = "/getDataList",method = RequestMethod.POST)
    public @ResponseBody List<MeasureVO> getDataList(){
        return measureBLService.getMeasureList();
    }

    @RequestMapping(value = "/saveNewData",method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage saveNewData(String tel, double ice_lesion,String measure_time,double height,double weight,String diet){
        return measureBLService.saveNewData(tel,ice_lesion,measure_time,height,weight,diet);
    }

    @RequestMapping(value = "/deleteData",method = RequestMethod.POST)
    public @ResponseBody ResultMessage deleteData(String tel){
        String newID=tel.substring(1,tel.length()-1);
        String[] ids=newID.split(",");
        return measureBLService.deleteData(ids);
    }
}
