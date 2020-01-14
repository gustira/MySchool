package com.enigma.bootcamp.helper.response;

public class CommonResponse<T> {

    private Integer status;
    private String message;
    private T data;

    // deggfault common response without data
    public CommonResponse() {
        this.status = 200;
        this.message = "Ok";
    }

    // success respose with data
    public CommonResponse(T data) {
        this.status = 200;
        this.message = "Ok";
        this.data = data;
    }

    // custom status and message
    public CommonResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    // custom status, message and data
    public CommonResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
