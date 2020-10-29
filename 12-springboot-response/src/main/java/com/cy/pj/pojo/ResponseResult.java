package com.cy.pj.pojo;
//基于次对象封装服务端响应到客户端信息

public class ResponseResult {
//    状态码
    private   Integer state=1;//1表示ok，0表示error
//    状态码对应的信息
    private   String  message="ok";
//    状态码对应的数据
    private   Object data;
    public ResponseResult(){};

    public ResponseResult(String message) {
        this.message = message;
    }

    public ResponseResult(Object data) {
        this.data = data;
    }

    public ResponseResult(Throwable e) {
        this.state =0;
        this.message=e.getMessage();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
