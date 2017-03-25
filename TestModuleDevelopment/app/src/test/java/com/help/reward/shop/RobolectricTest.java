package com.help.reward.shop;

import com.help.reward.shop.base.ParserTest;
import com.help.reward.shop.base.RobolectricTestRunner;
import com.help.reward.shop.datastore.cloud.restapi.RequestShopRestApi;
import com.help.reward.shop.model.ShopInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static org.junit.Assert.assertNotNull;

/**
 * Created by richsjeson on 17/3/23.
 */
@RunWith(RobolectricTestRunner.class)
public class RobolectricTest {

    public Retrofit retrofit;

    @Before
    public void setUp() {
        retrofit = new Retrofit.Builder().baseUrl("http://210.72.13.135/").addConverterFactory(ScalarsConverterFactory.create()).build();
    }

    @Test
    public void testGetInfo() throws IOException {
//http://210.72.13.135/mobile/index.php?act=goods&op=goods_detail/goods_id=257
        RequestShopRestApi restApi = retrofit.create(RequestShopRestApi.class);
        Call<String> call = restApi.getShopInfo(257);
        Response<String> response = call.execute();
        System.out.println("s:" + response.body());
        ShopInfo shopInfo = ParserTest.parserShopInfo(response.body());
        System.out.println("shopInfo>>" + shopInfo.toString());
        System.out.println("goodsInfo>>" + shopInfo.getGoodsInfo().toString());
        System.out.println("storeInfo>>" + shopInfo.getStoreInfo().toString());
        System.out.println("stdesc>>" + shopInfo.getStoreInfo().getStoreCredit().getStoreDesccredit().toString());
        System.out.println("stser>>" + shopInfo.getStoreInfo().getStoreCredit().getStoreServicecredit().toString());
        System.out.println("stdeli>>" + shopInfo.getStoreInfo().getStoreCredit().getStoreDeliverycredit().toString());
        System.out.println("commend>>" + shopInfo.getGoodsCommends().get(0).toString());
        System.out.println("commend>>" + shopInfo.getGoodsCommends().get(1).toString());

        assertNotNull(call.request());
    }

}
