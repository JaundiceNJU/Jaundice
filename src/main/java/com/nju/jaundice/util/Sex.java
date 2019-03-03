package com.nju.jaundice.util;

public enum Sex {
    MALE("男"),
    FEMALE("女");

    private String toChinese;

    Sex(String name){
        this.toChinese=name;
    }

    public String getToChinese() {
        return toChinese;
    }
}
