package com.help.reward.shop.model;

import java.util.List;
import java.util.Map;

/**
 * Created by wwb on 2017/3/23.
 */

public class ShopInfo {
    private GoodsInfo goodsInfo;
    private StoreInfo storeInfo;
    private GoodsHairInfo goodsHairInfo;
    private List<GoodsCommend> goodsCommends;

    private Map<String, Map<String, Object>> map;

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public StoreInfo getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        this.storeInfo = storeInfo;
    }

    public GoodsHairInfo getGoodsHairInfo() {
        return goodsHairInfo;
    }

    public void setGoodsHairInfo(GoodsHairInfo goodsHairInfo) {
        this.goodsHairInfo = goodsHairInfo;
    }

    public List<GoodsCommend> getGoodsCommends() {
        return goodsCommends;
    }

    public void setGoodsCommends(List<GoodsCommend> goodsCommends) {
        this.goodsCommends = goodsCommends;
    }

    public Map<String, Map<String, Object>> getMap() {
        return map;
    }

    public void setMap(Map<String, Map<String, Object>> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "goodsInfo=" + goodsInfo +
                ", storeInfo=" + storeInfo +
                ", goodsHairInfo=" + goodsHairInfo +
                ", goodsCommends=" + goodsCommends +
                ", map=" + map +
                '}';
    }
}
