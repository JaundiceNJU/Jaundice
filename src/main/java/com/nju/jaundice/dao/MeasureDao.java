package com.nju.jaundice.dao;

import com.nju.jaundice.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Repository
@Table(name = "measure")
public interface MeasureDao extends JpaRepository<Measure, Integer> {

    @Query(value = "select m from Measure m where m.baby=?1 order by m.date asc ")
    List<Measure> findByUsername(String username);

    @Query(value = "select count(m) from Measure m where m.date between ?1 and ?2")
    int findByYear(Date date1, Date date2);
}
