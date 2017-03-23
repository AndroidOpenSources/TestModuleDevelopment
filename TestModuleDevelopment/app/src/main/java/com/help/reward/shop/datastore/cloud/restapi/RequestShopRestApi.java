package com.help.reward.shop.datastore.cloud.restapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Rest API
 */

public interface RequestShopRestApi {

    @GET("mobile/index.php?act=goods&op=goods_detail")
    Call<String> getShopInfo(@Query("goods_id") Integer id);
    @GET("mobile/index.php?act=goods&op=goods_body_info")
    Call<String> getShopInstroduce(@Query("goods_id") Integer id);

}
