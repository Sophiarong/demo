package com.example.demo.entity;

public class Resp {
    private Integer status;
    private String msg;
    String msg1 = "it successes";
    String msg2 = "it doesn't success";
    private Object obj;

    public Resp(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getStatus() {
        return status;
    }

    public Resp setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Resp setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public Resp setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
