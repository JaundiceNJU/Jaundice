package com.nju.jaundice.dao;

import com.nju.jaundice.entity.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "baby")
public interface BabyDao extends JpaRepository<Baby,String> {

    @Query(value = "select b from Baby b where b.id=:tel")
    Baby find(@Param("tel")String id);
}
