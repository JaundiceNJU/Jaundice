package com.nju.jaundice.dao;

import com.nju.jaundice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "admin")
public interface AdminDao extends JpaRepository<Admin,String> {
}
