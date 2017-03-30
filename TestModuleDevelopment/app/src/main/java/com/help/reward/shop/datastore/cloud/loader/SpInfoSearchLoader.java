package com.help.reward.shop.datastore.cloud.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.help.reward.shop.Component;
import com.help.reward.shop.datastore.cloud.parser.SpSearchParser;
import com.help.reward.shop.datastore.cloud.restapi.RequestShopRestApi;
import com.help.reward.shop.model.GoodsInfo;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by wwb on 2017/3/29.
 */

public class SpInfoSearchLoader extends AsyncTaskLoader<List<GoodsInfo>> {
    private List<GoodsInfo> goodsInfos;

    private String key;//不填或填错 默认综合排序；salenum 销量 clicknum 人气 price 价格order desc降序asc升序；默认 降序

    private double price_from;//价格区间
    private double price_to;

    private int b_id;
    private String keyword;
    private String service;//freight 包邮 COD 货到付款 refund 急速退款 protection 消费者保障  quality 正品保障 sevenDay 7天无理由退货

    public SpInfoSearchLoader(Context context, String key, double price_from, double price_to, int b_id, String keyword, String service) {
        super(context);
        this.key = key;
        this.price_from = price_from;
        this.price_to = price_to;
        this.b_id = b_id;
        this.keyword = keyword;
        this.service = service;
    }

    @Override
    public List<GoodsInfo> loadInBackground() {

        RequestShopRestApi requestSerives = Component.getRetrofit().create(RequestShopRestApi.class);
        Call<String> call = requestSerives.getShopList(null, null, null, null, null, null);
        try {
            Response<String> response = call.execute();

            goodsInfos = SpSearchParser.parserGoodsInfoList(response.body());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return goodsInfos;
    }
}
