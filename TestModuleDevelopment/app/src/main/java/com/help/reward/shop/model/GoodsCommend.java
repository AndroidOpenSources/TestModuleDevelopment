package com.help.reward.shop.model;

/**
 * Created by wwb on 2017/3/23.
 * goods推荐
 */

public class GoodsCommend {
    private int id;
    private String name;
    private double promotionPrice;
    private String imageUrl;

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

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "GoodsCommend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", promotionPrice=" + promotionPrice +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
