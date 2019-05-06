package com.nju.jaundice.bl;

import com.nju.jaundice.blservice.StatisticsBLService;
import com.nju.jaundice.dao.BabyDao;
import com.nju.jaundice.dao.MeasureDao;
import com.nju.jaundice.entity.Baby;
import com.nju.jaundice.entity.Measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Service
public class StatisticsBL implements StatisticsBLService {

    @Autowired
    private MeasureDao measureDao;

    @Autowired
    private BabyDao babyDao;

    @Override
    public int babyNum() {
        return (int) babyDao.count();
    }

    @Override
    public int[] userIncrease(int year){
        int[] res=new int[12];
        ArrayList<Baby> getAllDatas= (ArrayList<Baby>) babyDao.findAll();
        String datestr1="";
        String datestr2="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DecimalFormat df=new DecimalFormat("00");
        for(int i=1;i<=12;i++){
            datestr1 = year+"-"+df.format(i)+"-01 00:00:00";
            if(i==12){
                datestr2 = (year+1)+"-01"+"-01 00:00:00";
            }else{
                datestr2 = year+"-"+df.format(i+1)+"-01 00:00:00";
            }

            try {
                res[i-1]=babyDao.findByYear(sdf.parse(datestr1),sdf.parse(datestr2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public Map<String, Integer> getLocation() {
        return null;
    }

    @Override
    public int[] getBabySex() {
        int maleNum=babyDao.getMaleBabyNum();
        int femaleNum=babyDao.getFemaleBabyNum();
//        System.out.println("---");
        return new int[]{maleNum,femaleNum};
    }

    @Override
    public int[] getBabyBlood() {
        return new int[]{babyDao.get_O_Blood(),babyDao.get_A_Blood(),babyDao.get_B_Blood(),babyDao.get_AB_Blood(),babyDao.get_Other_Blood()};
    }

    @Override
    public int[] getBabyWeek() {
        return new int[]{babyDao.getBabyWeek(10,28),babyDao.getBabyWeek(28,37),babyDao.getBabyWeek(37,42),babyDao.getBabyWeek(42,60)};
    }

    @Override
    public int getDataSum() {
        return measureDao.findAll().size();
    }

    @Override
    public int[] getDataIncrease(int year) {
        int[] res=new int[12];
        String datestr1;
        String datestr2;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DecimalFormat df=new DecimalFormat("00");
        for(int i=1;i<=12;i++){
            datestr1 = year+"-"+df.format(i)+"-01 00:00:00";
            if(i==12){
                datestr2 = (year+1)+"-01"+"-01 00:00:00";
            }else{
                datestr2 = year+"-"+df.format(i+1)+"-01 00:00:00";
            }

            try {
                res[i-1]=measureDao.findByYear(sdf.parse(datestr1),sdf.parse(datestr2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int[] divideByWeeks() {
        return new int[0];
    }

    @Override
    public int[] divideByBloodType() {
        return new int[0];
    }

    @Override
    public int[] divideBySex() {
        return new int[0];
    }

    @Override
    public Map<String, Integer> divideByArea() {
        return null;
    }
}
