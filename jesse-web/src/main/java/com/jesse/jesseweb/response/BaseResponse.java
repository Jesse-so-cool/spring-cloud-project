//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.jesse.jesseweb.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -6686048184626557273L;
    private Boolean isSuccess = true;
    private int responseCode = 0;
    private String responseMsg = "请求成功";

    public BaseResponse() {
    }

    public BaseResponse(Boolean isSuccess, int responseCode, String responseMsg) {
        this.isSuccess = isSuccess;
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public Boolean getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return this.responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
