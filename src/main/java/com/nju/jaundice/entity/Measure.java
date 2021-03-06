package com.nju.jaundice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "measure")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String baby;//测量的婴儿的ID

    private double ice_lesion;//黄疸值

    private Date date;//测量时间

    private double height;//身高，单位cm

    private double weight;//体重，单位kg

    private String diet;//近期饮食

    private boolean isExceed;//黄疸值是否超标

    public Measure(String baby,double ice_lesion,double height,double weight,String diet){
        this.baby=baby;
        this.ice_lesion=ice_lesion;
        this.height=height;
        this.weight=weight;
        this.diet=diet;
    }

    public Measure(String tel, double ice_lesion, Date messure_time, double height, double weight, String diet,boolean isExceed){
        this.baby=tel;
        this.ice_lesion=ice_lesion;
        this.date=messure_time;
        this.height=height;
        this.weight=weight;
        this.diet=diet;
        this.isExceed=isExceed;

    }

}
