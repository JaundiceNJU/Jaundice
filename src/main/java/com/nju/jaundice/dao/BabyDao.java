package com.nju.jaundice.dao;

import com.nju.jaundice.entity.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "baby")
public interface BabyDao extends JpaRepository<Baby,String> {
}
