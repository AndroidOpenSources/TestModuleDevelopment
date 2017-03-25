package com.help.reward.shop.datastore.cloud.restapi;

/**
 * Created by wwb on 2017/3/23.
 */

public class BusinessCode {

    private int code;
    private String msg;
    private String data;
    private boolean hashmore;
    private int page_total;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isHashmore() {
        return hashmore;
    }

    public void setHashmore(boolean hashmore) {
        this.hashmore = hashmore;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    @Override
    public String toString() {
        return "BusinessCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                ", hashmore=" + hashmore +
                ", page_total=" + page_total +
                '}';
    }
}
