package com.jesse.jesseweb.response;


import java.io.Serializable;

public class AppResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 8871328696585548402L;

    private Object data;

    public AppResponse() {
        super();
    }

    public AppResponse(Boolean isSuccess, int responseCode, String responseMsg) {
        super(isSuccess, responseCode, responseMsg);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}