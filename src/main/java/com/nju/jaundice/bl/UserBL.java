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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UserBL implements UserBLService {

    @Autowired
    private BabyDao babyDao;

    private final String initPsd="123456";

    @Override
    public ResultMessage login(String telephone, String password) {
        Baby baby=babyDao.find(telephone);
        if(baby==null){
            return ResultMessage.NOTEXIST;
        }else{
            if(baby.getPassword().equals(password)){
                return ResultMessage.USERLOGIN;
            }else{
                return ResultMessage.PASSERROR;
            }
        }
    }

    @Override
    public ResultMessage register(String telephone, String password) {
        try{
            Baby baby=babyDao.find(telephone);
            if(baby!=null){
                return ResultMessage.EXIST;
            }else{
                Baby newBaby=new Baby(telephone,password,new Date());
                babyDao.save(newBaby);
                return ResultMessage.SUCCESS;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultMessage.FAIL;
        }
    }

    @Override
    public ResultMessage completeInfo(String telephone, String parent, String nickname, String sex, int week, String blood, String bornTime,double height,double weight,String area,String hospital) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        if(bornTime.contains("-")){
            sdf=new SimpleDateFormat("yyyy-MM-dd");
        }
        try{
            Baby baby=babyDao.find(telephone);
            baby.setParent(Role.valueOf(parent));
            baby.setNickname(nickname);
            baby.setSex(Sex.valueOf(sex));
            baby.setWeek(week);
            baby.setBlood(Blood.valueOf(blood));
            baby.setBornTime(sdf.parse(bornTime));
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

    @Override
    public BabyVO getOneUserInfo(String username) {
        Baby baby=babyDao.find(username);
        if(baby!=null){
            return new BabyVO(baby);
        }
        return null;
    }

    @Override
    public ResultMessage saveNewUser(String tel, String babyName, int week, double height, double weight, String area, String hospital, String parent, String blood, String birthday,String sex) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        if(birthday.contains("-")){
            sdf=new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            Role role=Role.valueOf(parent);
            Blood babyBlood=Blood.valueOf(blood);
            Sex babySex=Sex.valueOf(sex);
            System.err.print(role+" "+babyBlood+" "+babySex);
            Date date=sdf.parse(birthday);
            Baby baby=new Baby(tel,initPsd,role,babyName,babySex,week,babyBlood,new Date(),date,height,weight,area,hospital);
            babyDao.saveAndFlush(baby);
            return ResultMessage.SUCCESS;
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultMessage.FAIL;
        }

    }

    @Override
    public ResultMessage deleteUser(String[] tel) {
        for(int i=0;i<tel.length;i++){
            Baby baby=babyDao.find(tel[i].substring(1,tel[i].length()-1));
            if(baby!=null){
                babyDao.delete(baby);
            }
        }
        return ResultMessage.SUCCESS;
    }
}
