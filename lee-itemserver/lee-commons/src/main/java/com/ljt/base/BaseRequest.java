package com.ljt.base;

import java.io.Serializable;

public class BaseRequest<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tokenKey;
    private T requestData;

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public T getRequestData() {
        return requestData;
    }

    public void setRequestData(T requestData) {
        this.requestData = requestData;
    }

}
