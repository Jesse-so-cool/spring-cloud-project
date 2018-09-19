package com.jesse.jesseweb.enume;

/**
 * @author Jesse
 */

public enum ArticleStatusEnum {
    //user admin
    PUBLISHED("published"),

    DRAFT("draft");

    private String code;

    ArticleStatusEnum(String code) {
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
