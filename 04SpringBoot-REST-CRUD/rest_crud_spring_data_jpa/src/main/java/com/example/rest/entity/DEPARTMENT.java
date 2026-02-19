package com.example.rest.entity;

import java.util.Random;

public enum DEPARTMENT {

    SALES,PRODUCT,HR,FINANCE;

    private static final Random random=new Random();
    public static DEPARTMENT getDept(){
        DEPARTMENT[] depts=values();
        return depts[random.nextInt(DEPARTMENT.values().length)];
    }
}
