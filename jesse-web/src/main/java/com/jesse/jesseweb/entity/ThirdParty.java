package com.jesse.jesseweb.entity;

import lombok.Data;

@Data
public class ThirdParty {
    private Integer id;

    private String url;

    private String tag;

    private String parameter;

    private String describe;


    public ThirdParty(Integer id, String url, String tag, String parameter, String describe) {
        this.id = id;
        this.url = url;
        this.tag = tag;
        this.parameter = parameter;
        this.describe = describe;
    }

    public ThirdParty() {

    }
}
