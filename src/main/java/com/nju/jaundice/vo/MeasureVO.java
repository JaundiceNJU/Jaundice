package com.nju.jaundice.vo;


import com.nju.jaundice.entity.Measure;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;

/**
 * @program: jaundice
 * @description:
 * @author: Jane
 * @create: 2019-03-04 09:35
 **/

@Data
@AllArgsConstructor
public class MeasureVO {

    private int id;

    private String baby;//测量的婴儿的ID

    private double ice_lesion;//黄疸值

    private String date;//测量时间

    private double height;//身高，单位cm

    private double weight;//体重，单位kg

    private String diet;//近期饮食

    private String isExceed;//黄疸值是否超标

    public MeasureVO(Measure measure){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.id=measure.getId();
        this.baby=measure.getBaby();
        this.ice_lesion=measure.getIce_lesion();
        this.date=simpleDateFormat.format(measure.getDate());
        this.height=measure.getHeight();
        this.weight=measure.getWeight();
        this.diet=measure.getDiet();
        if(measure.isExceed()){
            this.isExceed="是";
        }else{
            this.isExceed="否";
        }
    }


}
