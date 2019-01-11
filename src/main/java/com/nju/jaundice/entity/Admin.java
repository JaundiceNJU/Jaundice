package com.nju.jaundice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private String username;
    private String password;
}
