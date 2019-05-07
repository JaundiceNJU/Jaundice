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
import java.util.*;

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
    public Map<String, Integer> getBabyIncrease() {
        Map<String,Integer> res=new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String initDateStr="2018-12-01 00:00:00";
        String currentDateStr=sdf.format(new Date());

        int initYear=Integer.parseInt(initDateStr.split(" ")[0].split("-")[0]);
        int currentYear=Integer.parseInt(currentDateStr.split(" ")[0].split("-")[0]);

        int initMonth=Integer.parseInt(initDateStr.split(" ")[0].split("-")[1]);
        int currentMonth=Integer.parseInt(currentDateStr.split(" ")[0].split("-")[1]);

        String tempDate1="";
        String tempDate2="";
        DecimalFormat df=new DecimalFormat("00");

        int init=1;
        int current=12;
        for(int i=initYear;i<=currentYear;i++) {
            if(initYear==currentYear){
                init=initMonth;
                current=currentMonth;
            }else if(i==initYear){
                init=initMonth;
                current=12;
            }else if(i==currentYear){
                init=1;
                current=currentMonth;
            }else{
                init=1;
                current=12;
            }
            for(int j=init;j<=current;j++){
                tempDate1=i+"-"+df.format(j)+"-01 00:00:00";
                if(j==12){
                    tempDate2=(i+1)+"-01-01 00:00:00";
                }else{
                    tempDate2=i+"-"+df.format(j+1)+"-01 00:00:00";
                }

                try {
                    res.put(i+"-"+df.format(j),babyDao.findByYear(sdf.parse(tempDate1),sdf.parse(tempDate2)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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
