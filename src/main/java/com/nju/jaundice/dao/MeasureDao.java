package com.nju.jaundice.dao;

import com.nju.jaundice.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "measure")
public interface MeasureDao extends JpaRepository<Measure,Long> {

    @Query(value = "select m from Measure m where m.baby=:username order by m.date desc")
    List<Measure> findByUsername(String username);
}
