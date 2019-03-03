package com.nju.jaundice.entity;

import com.nju.jaundice.util.Blood;
import com.nju.jaundice.util.Role;
import com.nju.jaundice.util.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "baby")
public class Baby {

    @Id
    private String id;//用户ID，为注册时手机号

    private String password;//登录密码

    private Role parent;//父亲or母亲

    private String nickname;//宝宝昵称

    private Sex sex;//宝宝性别

    private int week;//孕周

    private Blood blood;//血型

    private Date bornTime;//出生时间

    private double height;//出生身长

    private double weight;//出生体重

    private String area;//出生地区

    private String hospital;//出生医院

    public Baby(String telephone,String password){
        this.id=telephone;
        this.password=password;
    }
}
