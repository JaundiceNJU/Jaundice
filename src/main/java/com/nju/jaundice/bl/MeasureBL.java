package com.nju.jaundice.bl;

import com.nju.jaundice.blservice.MeasureBLService;
import com.nju.jaundice.dao.MeasureDao;
import com.nju.jaundice.entity.Measure;
import com.nju.jaundice.util.ResultMessage;
import com.nju.jaundice.vo.MeasureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MeasureBL implements MeasureBLService {

    @Autowired
    private MeasureDao measureDao;

    @Override
    public void recordMeasure(String telephone, double jaundice, double height, double weight, String diet) {
        Measure measure=new Measure(telephone,jaundice,height,weight,diet);
        measure.setDate(new Date());
        measureDao.save(measure);
    }

    @Override
    public List<Measure> getMeasureListByTime() {
        return null;
    }

    @Override
    public List<MeasureVO> getMeasureListByUsername(String username) {
        System.out.println("username:"+username);
        List<Measure> measures= measureDao.findByUsername(username);
        System.out.println(measures.size());
        List<MeasureVO> vos=new ArrayList<>();
        for(Measure m:measures){
            System.out.println(m.toString());
            vos.add(new MeasureVO(m));
        }
        return vos;
    }

    @Override
    public List<MeasureVO> getMeasureList() {
        List<Measure> measures=measureDao.findAll();
        List<MeasureVO> measureVOS=new ArrayList<>();
        for(Measure m:measures){
            measureVOS.add(new MeasureVO(m));
        }
        return measureVOS;
    }

    @Override
    public ResultMessage saveNewData(String tel, double ice_lesion, String messure_time, double height, double weight, String diet){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Measure measure= null;
        try {
            measure = new Measure(tel,ice_lesion,sdf.parse(messure_time),height,weight,diet,isExceed(ice_lesion));
            measureDao.saveAndFlush(measure);
            return ResultMessage.SUCCESS;
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultMessage.FAIL;
        }

    }

    @Override
    public ResultMessage deleteData(String[] id) {
        for(int i=0;i<id.length;i++){
            measureDao.deleteById(Integer.parseInt(id[i]));
        }
        return ResultMessage.SUCCESS;
    }

    //要写算法判断
    private boolean isExceed(double value){
        return false;
    }
}
