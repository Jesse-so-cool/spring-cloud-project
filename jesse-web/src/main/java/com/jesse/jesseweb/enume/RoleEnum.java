package com.jesse.jesseweb.enume;

/**
 * @author Jesse
 */

public enum RoleEnum {
    //user admin
    USER("USER"),

    ADMIN("ADMIN");

    private String code;

    RoleEnum(String code) {
        this.code = code;
    }

    ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
