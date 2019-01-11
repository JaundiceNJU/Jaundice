package com.nju.jaundice.dao;

import com.nju.jaundice.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "measure")
public interface MeasureDao extends JpaRepository<Measure,Long> {
}
