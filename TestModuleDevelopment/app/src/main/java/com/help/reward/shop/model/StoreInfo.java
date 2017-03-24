package com.help.reward.shop.model;

/**
 * Created by wwb on 2017/3/23.
 */

public class StoreInfo {
    private int id;
    private String name;
    private int memberId;
    private StCredit storeCredit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public StCredit getStoreCredit() {
        return storeCredit;
    }

    public void setStoreCredit(StCredit storeCredit) {
        this.storeCredit = storeCredit;
    }
}
