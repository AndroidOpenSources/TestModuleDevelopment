package com.help.reward.shop.model;

/**
 * Created by wwb on 2017/3/23.
 */

public class StCredit {
    private StDeliverycredit storeDeliverycredit; //描述相符
    private StServicecredit storeServicecredit;//服务态度
    private StDesccredit storeDesccredit;//发货速度

    public StDeliverycredit getStoreDeliverycredit() {
        return storeDeliverycredit;
    }

    public void setStoreDeliverycredit(StDeliverycredit storeDeliverycredit) {
        this.storeDeliverycredit = storeDeliverycredit;
    }

    public StServicecredit getStoreServicecredit() {
        return storeServicecredit;
    }

    public void setStoreServicecredit(StServicecredit storeServicecredit) {
        this.storeServicecredit = storeServicecredit;
    }

    public StDesccredit getStoreDesccredit() {
        return storeDesccredit;
    }

    public void setStoreDesccredit(StDesccredit storeDesccredit) {
        this.storeDesccredit = storeDesccredit;
    }
}
