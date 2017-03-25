package com.help.reward.shop.model;

/**
 * Created by wwb on 2017/3/23.
 * desc:服务态度
 */

public class StServicecredit {
    private String text;
    private double credit;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "StServicecredit{" +
                "text='" + text + '\'' +
                ", credit=" + credit +
                '}';
    }
}
