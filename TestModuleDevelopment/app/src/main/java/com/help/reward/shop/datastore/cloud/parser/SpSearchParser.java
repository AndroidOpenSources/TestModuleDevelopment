package com.help.reward.shop.datastore.cloud.parser;

import com.help.reward.shop.datastore.translate.SpInfoKey;
import com.help.reward.shop.model.GoodsInfo;
import com.help.reward.shop.utils.StringUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wwb on 2017/3/29.
 */

public class SpSearchParser {
    //获取全部商品搜索
    public static List<GoodsInfo> parserGoodsInfoList(String json) {
        String goodsListJson = ParserUtils.parserBaseJson(json);
        List<GoodsInfo> goodsInfos = new ArrayList<>();
        try {
            JSONObject dataJson = new JSONObject(goodsListJson);
            if (dataJson.optJSONArray(SpInfoKey.GOODS_LIST) != null && dataJson.optJSONArray(SpInfoKey.GOODS_LIST).length() > 0) {
                for (int i = 0; i < dataJson.optJSONArray(SpInfoKey.GOODS_LIST).length(); i++) {
                    JSONObject goodsObj = dataJson.optJSONArray(SpInfoKey.GOODS_LIST).getJSONObject(i);
                    GoodsInfo goodsInfo = new GoodsInfo();
                    goodsInfo.setId(goodsObj.optInt(SpInfoKey.GoodsKey.GOODS_ID));
                    goodsInfo.setJingle(goodsObj.optString(SpInfoKey.GoodsKey.GOODS_JINGLE));
                    goodsInfo.setPrice(goodsObj.optDouble(SpInfoKey.GoodsKey.GOODS_PRICE));
                    goodsInfo.setCostprice(goodsObj.optDouble(SpInfoKey.GoodsKey.GOODS_COSTPRICE));
                    goodsInfo.setClick(goodsObj.optInt(SpInfoKey.GoodsKey.GOODS_CLICK));
                    goodsInfo.setPromotionPrice(goodsObj.optDouble(SpInfoKey.GoodsKey.GOODS_PROMOTIONPRICE));
                    goodsInfo.setSalenum(goodsObj.optInt(SpInfoKey.GoodsKey.GOODS_SALENUM));
                    goodsInfo.setImage(StringUtil.splitImageStr((goodsObj.optString(SpInfoKey.GoodsKey.GOODS_IMAGE)), ","));
                    goodsInfo.setName(goodsObj.optString(SpInfoKey.GoodsKey.GOOD_NAME));
                    goodsInfo.setMarketprice(goodsObj.optDouble(SpInfoKey.GoodsKey.GOODS_MARKET_PRICE));
                    goodsInfos.add(goodsInfo);
                }
            }

            return goodsInfos;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
