package com.help.reward.shop.datastore.cloud.loader;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.help.reward.shop.Component;
import com.help.reward.shop.datastore.cloud.parser.ParserUtils;
import com.help.reward.shop.datastore.cloud.restapi.RequestShopRestApi;
import com.help.reward.shop.model.ShopInfo;

import retrofit2.Call;

/**
 * Created by richsjeson on 17/3/25.
 * 商品详情
 *
 * 状态机：
 *   1）获取数据失败时，返回触发重试操作 用户手动操作
 *   2) 获取数据成功，处理数据
 *   3）ID数据刷新。
 */

public class SpInfoLoader extends AsyncTaskLoader<ShopInfo> {

    private int shopId;
    private ShopInfo mData;

    public SpInfoLoader(Context context,int shopId) {
        super(context);
        this.shopId=shopId;
    }

    @Override
    public ShopInfo loadInBackground() {
        RequestShopRestApi requestSerives= Component.getRetrofit().create(RequestShopRestApi.class);
        Call<String> call=requestSerives.getShopInfo(shopId);
        //这层交给你去解析，把解析的数据放到该层中
        //mData数据给予
        return null;
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if(mData != null){
            //如果mData不需要刷新数据，那么则再次处理以往的旧数据
            deliverResult(mData);
        }else{
            forceLoad();
        }

    }

    @Override
    public void deliverResult(ShopInfo data) {
        super.deliverResult(data);
    }

    /**
     * 操作请求 ，当切换商品的时候，需要切换shopId
     * @param shopId
     */
    public void requestLoadId(int shopId){

        this.shopId=shopId;
        forceLoad();
    }
}
