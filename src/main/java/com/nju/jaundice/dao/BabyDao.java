package com.nju.jaundice.dao;

import com.nju.jaundice.entity.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Repository
@Table(name = "baby")
public interface BabyDao extends JpaRepository<Baby,String> {

    @Query(value = "select b from Baby b where b.id=:tel")
    Baby find(@Param("tel")String id);

    @Query(value = "select count(b) from Baby b where b.registerTime between ?1 and ?2")
    int findByYear(Date date1,Date date2);

    @Query(value = "select count(b) from Baby b where b.sex=0")
    int getMaleBabyNum();

    @Query(value = "select count(b) from Baby b where b.sex=1")
    int getFemaleBabyNum();

    @Query(value = "select count(b) from Baby b where b.blood=0")
    int get_O_Blood();

    @Query(value = "select count(b) from Baby b where b.blood=1")
    int get_A_Blood();

    @Query(value = "select count(b) from Baby b where b.blood=2")
    int get_B_Blood();

    @Query(value = "select count(b) from Baby b where b.blood=3")
    int get_AB_Blood();

    @Query(value = "select count(b) from Baby b where b.blood=4")
    int get_Other_Blood();

    @Query(value = "select count(b) from Baby b where b.week>=?1 and b.week<?2")
    int getBabyWeek(int week1,int week2);




}
