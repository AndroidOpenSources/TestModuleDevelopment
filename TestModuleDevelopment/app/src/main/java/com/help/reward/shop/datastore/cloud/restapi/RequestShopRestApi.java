package com.help.reward.shop.datastore.cloud.restapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Rest API
 */

public interface RequestShopRestApi {

    //商品详情
    @GET("mobile/index.php?act=goods&op=goods_detail")
    Call<String> getShopInfo(@Query("goods_id") Integer id);

    @GET("mobile/index.php?act=goods&op=goods_body_info")
    Call<String> getShopInstroduce(@Query("goods_id") Integer id);

    //全部商品-搜索
    @GET("/mobile/index.php?act=goods&op=goods_list")
    Call<String> getShopList();

    //获取历史搜索和热门搜索
    @GET("/mobile/index.php?act=index&op=search_key_list")
    Call<String> getSearchKeyList();

    //类别列表
    @GET("/mobile/index.php?act=goods_class&op=index")
    Call<String> getClassList();

}
