package com.nju.jaundice.bl;

import com.nju.jaundice.blservice.UserBLService;
import com.nju.jaundice.dao.BabyDao;
import com.nju.jaundice.entity.Baby;
import com.nju.jaundice.util.Blood;
import com.nju.jaundice.util.ResultMessage;
import com.nju.jaundice.util.Role;
import com.nju.jaundice.util.Sex;
import com.nju.jaundice.vo.BabyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class UserBL implements UserBLService {

    @Autowired
    private BabyDao babyDao;

    @Override
    public ResultMessage login(String telephone, String password) {
        Baby baby=babyDao.getOne(telephone);
        if(baby==null){
            return ResultMessage.NOTEXIST;
        }else{
            if(baby.getPassword().equals(password)){
                return ResultMessage.SUCCESS;
            }else{
                return ResultMessage.PASSERROR;
            }
        }
    }

    @Override
    public ResultMessage register(String telephone, String password) {
        try{
            Baby baby=babyDao.getOne(telephone);
            if(baby!=null){
                return ResultMessage.EXIST;
            }else{
                Baby newBaby=new Baby(telephone,password);
                babyDao.save(newBaby);
                return ResultMessage.SUCCESS;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultMessage.FAIL;
        }
    }

    @Override
    public ResultMessage completeInfo(String telephone, Role parent, String nickname, Sex sex, int week, Blood blood, Date bornTime,double height,double weight,String area,String hospital) {
        try{
            Baby baby=babyDao.getOne(telephone);
            baby.setParent(parent);
            baby.setNickname(nickname);
            baby.setSex(sex);
            baby.setWeek(week);
            baby.setBlood(blood);
            baby.setBornTime(bornTime);
            baby.setHeight(height);
            baby.setWeight(weight);
            baby.setArea(area);
            baby.setHospital(hospital);
            babyDao.save(baby);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultMessage.FAIL;
        }
    }

    @Override
    public ArrayList<BabyVO> getUserInfoList() {
        ArrayList<Baby> babyArrayList=new ArrayList<>(babyDao.findAll());
        ArrayList<BabyVO> babyVOS=new ArrayList<>();
        for(Baby b:babyArrayList){
            babyVOS.add(new BabyVO(b));
        }
        return babyVOS;
    }
}
