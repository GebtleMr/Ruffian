package com.ljt.base;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String respCode;
    private String respMsg;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
    private Date respTime;
    private T respData;

    public BaseResponse(String respCode, String respMsg, Date respTime, T respData) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.respTime = respTime;
        this.respData = respData;
    }

    public static <T> BaseResponse onSuccess(T respData){
        return new BaseResponse("0000","SUCCESS",new Date(),respData);
    }

    public static <T> BaseResponse onSuccess(String respMsg,T respData){
        return new BaseResponse("0000",respMsg,new Date(),respData);
    }

    public static <T> BaseResponse onError(String respMsg,T respData){
        return new BaseResponse("9999",respMsg,new Date(),respData);
    }
    public static <T> BaseResponse onError(T respData){
        return new BaseResponse("9999","ERROR",new Date(),respData);
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public Date getRespTime() {
        return respTime;
    }

    public void setRespTime(Date respTime) {
        this.respTime = respTime;
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }
}
