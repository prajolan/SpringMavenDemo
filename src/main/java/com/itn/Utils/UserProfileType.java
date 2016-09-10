/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.Utils;

/**
 *
 * @author Hp
 */
public enum UserProfileType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");
    
    private String userProfileType;

    private UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public static UserProfileType getUSER() {
        return USER;
    }

    public static UserProfileType getDBA() {
        return DBA;
    }

    public static UserProfileType getADMIN() {
        return ADMIN;
    }

    public String getUserProfileType() {
        return userProfileType;
    }
    
}
