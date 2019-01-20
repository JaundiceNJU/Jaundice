package com.nju.jaundice.bl;

import com.nju.jaundice.blservice.MeasureBLService;
import com.nju.jaundice.dao.MeasureDao;
import com.nju.jaundice.entity.Measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Measure> getMeasureListByUsername(String username) {
        return measureDao.findByUsername(username);
    }
}
