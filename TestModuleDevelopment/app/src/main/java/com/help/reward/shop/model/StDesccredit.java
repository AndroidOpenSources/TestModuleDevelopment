package com.help.reward.shop.model;

/**
 * Created by wwb on 2017/3/23.
 * desc:发货速度
 */

public class StDesccredit {
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
        return "StDesccredit{" +
                "text='" + text + '\'' +
                ", credit=" + credit +
                '}';
    }
}
