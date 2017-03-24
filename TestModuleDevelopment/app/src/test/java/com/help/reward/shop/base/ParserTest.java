package com.help.reward.shop.base;

import com.help.reward.shop.datastore.translate.ShopInfoKey;
import com.help.reward.shop.model.GoodsCommend;
import com.help.reward.shop.model.GoodsHairInfo;
import com.help.reward.shop.model.GoodsInfo;
import com.help.reward.shop.model.ShopInfo;
import com.help.reward.shop.model.StCredit;
import com.help.reward.shop.model.StDeliverycredit;
import com.help.reward.shop.model.StDesccredit;
import com.help.reward.shop.model.StServicecredit;
import com.help.reward.shop.model.StoreInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wwb on 2017/3/23.
 */

public class ParserTest {
    public static String parserBaseJson(String json) {
        try {
            JSONObject resultJson = new JSONObject(json);
            if (resultJson != null) {
                //判断返回码
                if (resultJson.optInt("code") == 200) {
                    if (resultJson.optString("data") != null && (!resultJson.optString("data").equalsIgnoreCase(""))) {
                        return resultJson.getString("data");
                    }
                } else {
                    return "error";
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static ShopInfo parserShopInfo(String json) {
        String shopjson = parserBaseJson(json);//返回data里面的内容
        ShopInfo shopInfo = new ShopInfo();

        GoodsInfo goodsInfo = new GoodsInfo();
        StoreInfo storeInfo = new StoreInfo();
        GoodsHairInfo goodsHairInfo = new GoodsHairInfo();
        List<GoodsCommend> goodsCommends;
        Map<String, Object> keyMap = null;
        try {
            JSONObject dataJson = new JSONObject(shopjson);
            //goodsHairInfo
            if (dataJson.optJSONObject(ShopInfoKey.GOODS_HAIR_INFO) != null) {
                JSONObject info = dataJson.optJSONObject(ShopInfoKey.GOODS_HAIR_INFO);
                goodsHairInfo.setContent(info.optString(ShopInfoKey.GoodsKey.GOODS_CONTENT));
                goodsHairInfo.setAreaName(info.optString(ShopInfoKey.GoodsKey.GOODS_AREA_NAME));
            }
            //goodsInfo
            if (dataJson.optJSONObject(ShopInfoKey.GOODS_INFO) != null) {
                JSONObject info = dataJson.optJSONObject(ShopInfoKey.GOODS_INFO);

                goodsInfo.setId(info.optInt(ShopInfoKey.GoodsKey.GOODS_ID));
                goodsInfo.setJingle(info.optString(ShopInfoKey.GoodsKey.GOODS_JINGLE));
                goodsInfo.setPrice(info.optDouble(ShopInfoKey.GoodsKey.GOODS_PRICE));
                goodsInfo.setCostprice(info.optDouble(ShopInfoKey.GoodsKey.GOODS_COSTPRICE));
                goodsInfo.setClick(info.optInt(ShopInfoKey.GoodsKey.GOODS_CLICK));
                goodsInfo.setPromotionPrice(info.optDouble(ShopInfoKey.GoodsKey.GOODS_PROMOTIONPRICE));
                goodsInfo.setSalenum(info.optInt(ShopInfoKey.GoodsKey.GOODS_SALENUM));
                goodsInfo.setImage(splitStr(dataJson.optString(ShopInfoKey.GoodsKey.GOODS_IMAGE), ","));
                goodsInfo.setName(info.optString(ShopInfoKey.GoodsKey.GOOD_NAME));
                goodsInfo.setMarketprice(info.optDouble(ShopInfoKey.GoodsKey.GOODS_MARKET_PRICE));
                goodsInfo.setContent(goodsHairInfo.getContent());
                goodsInfo.setAreaName(goodsHairInfo.getAreaName());

                Map<String, Map<String, Object>> valueMap = new HashMap<>();
                //先将spec_name转成map，看可以获取到里面的key和value；
                if (info.optString(ShopInfoKey.SPEC_NAME) != null && (!info.optString(ShopInfoKey.SPEC_NAME).equalsIgnoreCase(""))) {
                    keyMap = getMapForJson(info.optString(ShopInfoKey.SPEC_NAME));
                }

                //先将spec_value转成对象，然后遍历上面的map通过key获取对应的string，然后再转成map
                if (info.optJSONObject(ShopInfoKey.SPEC_VALUE) != null) {
                    JSONObject valueObj = info.optJSONObject(ShopInfoKey.SPEC_VALUE);
                    //遍历上面那个map
                    if (keyMap != null) {
                        for (String key : keyMap.keySet()) {
                            Map<String, Object> map = getMapForJson(valueObj.optString(key));
                            //然后这里是保存key和map
                            //相当于map<15,map2<string,object>>;
                            //然后循环遍历map2可以得到里面的key和value比如 <"439","M">;<"440","L">
                            valueMap.put(key, map);
                        }

                    }
                }

                shopInfo.setMap(valueMap);
                shopInfo.setGoodsInfo(goodsInfo);

            }

            //storeInfo
            if (dataJson.optJSONObject(ShopInfoKey.STORE_INFO) != null) {
                JSONObject info = dataJson.optJSONObject(ShopInfoKey.STORE_INFO);
                storeInfo.setId(info.optInt(ShopInfoKey.StoreKey.STORE_ID));
                storeInfo.setName(info.optString(ShopInfoKey.StoreKey.STORE_NAME));
                storeInfo.setMemberId(info.optInt(ShopInfoKey.StoreKey.MEMBER_ID));
                StCredit stCredit = new StCredit();
                if (info.optJSONObject(ShopInfoKey.StoreKey.STORE_CREDIT) != null) {
                    JSONObject stCreditJosnObj = info.optJSONObject(ShopInfoKey.StoreKey.STORE_CREDIT);
                    if (stCreditJosnObj.optJSONObject(ShopInfoKey.StoreKey.STORE_DESCCREDIT) != null) {
                        JSONObject stDes = stCreditJosnObj.optJSONObject(ShopInfoKey.StoreKey.STORE_DESCCREDIT);
                        StDesccredit stDesccredit = new StDesccredit();
                        stDesccredit.setCredit(stDes.optDouble(ShopInfoKey.StoreKey.CREDIT));
                        stCredit.setStoreDesccredit(stDesccredit);
                    }
                    if (stCreditJosnObj.optJSONObject(ShopInfoKey.StoreKey.STORE_SERVICECREDIT) != null) {
                        JSONObject stService = stCreditJosnObj.optJSONObject(ShopInfoKey.StoreKey.STORE_SERVICECREDIT);
                        StServicecredit stServicecredit = new StServicecredit();
                        stServicecredit.setCredit(stService.optDouble(ShopInfoKey.StoreKey.CREDIT));
                        stCredit.setStoreServicecredit(stServicecredit);
                    }
                    if (stCreditJosnObj.optJSONObject(ShopInfoKey.StoreKey.STORE_DELIVECREDIT) != null) {
                        JSONObject stdelive = stCreditJosnObj.optJSONObject(ShopInfoKey.StoreKey.STORE_DELIVECREDIT);
                        StDeliverycredit stDeliverycredit = new StDeliverycredit();
                        stDeliverycredit.setCredit(stdelive.optDouble(ShopInfoKey.StoreKey.CREDIT));
                        stCredit.setStoreDeliverycredit(stDeliverycredit);
                    }

                }
                storeInfo.setStoreCredit(stCredit);
                shopInfo.setStoreInfo(storeInfo);
            }
            //commendlist
            if (dataJson.optJSONArray(ShopInfoKey.GOODS_COMMEND_LIST) != null) {
                JSONArray array = dataJson.optJSONArray(ShopInfoKey.GOODS_COMMEND_LIST);
                if (array != null && array.length() > 0) {
                    goodsCommends = new ArrayList<GoodsCommend>();
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject commend = array.getJSONObject(i);
                        GoodsCommend goodsCommend = new GoodsCommend();
                        goodsCommend.setId(commend.optInt(ShopInfoKey.GoodCommend.GOOD_COMMEND_ID));
                        goodsCommend.setName(commend.optString(ShopInfoKey.GoodCommend.GOOD_COMMEND_NAME));
                        goodsCommend.setPromotionPrice(commend.optDouble(ShopInfoKey.GoodCommend.GOOD_COMMEND_PROMOTIONPRICE));
                        goodsCommends.add(goodsCommend);
                    }
                    shopInfo.setGoodsCommends(goodsCommends);
                }
            }


            return shopInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] splitStr(String s, String flag) {
        return s.split(flag);
    }


    public static Map<String, Object> getMapForJson(String jsonStr) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonStr);

            Iterator<String> keyIter = jsonObject.keys();
            String key;
            Object value;
            Map<String, Object> valueMap = new HashMap<String, Object>();
            while (keyIter.hasNext()) {
                key = keyIter.next();
                value = jsonObject.get(key);
                valueMap.put(key, value);
            }
            return valueMap;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

}