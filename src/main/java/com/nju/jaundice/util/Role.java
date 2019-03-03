package com.nju.jaundice.util;

public enum Role {
    FATHER("父亲"),
    MOTHER("母亲");

    private String chinese_name;

    Role(String name){
        this.chinese_name=name;
    }

    public String getChinese_name() {
        return chinese_name;
    }

}
