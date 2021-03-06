package com.nju.jaundice.vo;

import com.nju.jaundice.entity.Baby;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: jaundice
 * @description: Baby data for view.
 * @author: Jane
 * @create: 2019-03-03 17:07
 **/

@Data
@AllArgsConstructor
public class BabyVO {

    private String id;//用户ID，为注册时手机号

    private String password;//登录密码

    private String parent;//父亲or母亲

    private String nickname;//宝宝昵称

    private String sex;//宝宝性别

    private int week;//孕周

    private String blood;//血型

    private String bornTime;//出生时间

    private double height;//出生身长

    private double weight;//出生体重

    private String area;//出生地区

    private String hospital;//出生医院

    public BabyVO(){}

    public BabyVO(Baby baby){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.id=baby.getId();
        this.password=baby.getPassword();
        if(baby.getParent()!=null){
            this.parent=baby.getParent().getChinese_name();
        }

        this.nickname=baby.getNickname();
        if(baby.getSex()!=null){
            this.sex=baby.getSex().getToChinese();
        }
        this.week=baby.getWeek();
        if(baby.getBlood()!=null){
            this.blood=baby.getBlood().toString();
        }
        if(baby.getBornTime()!=null){
            this.bornTime=formatter.format(baby.getBornTime());
        }
        this.height=baby.getHeight();
        this.weight=baby.getWeight();
        this.area=baby.getArea();
        this.hospital=baby.getHospital();

    }
}
