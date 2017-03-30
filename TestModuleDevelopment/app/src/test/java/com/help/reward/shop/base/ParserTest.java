package com.help.reward.shop.base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.help.reward.shop.datastore.cloud.parser.ParserUtils;
import com.help.reward.shop.datastore.translate.SpInfoKey;
import com.help.reward.shop.model.GoodsClass;
import com.help.reward.shop.model.GoodsCommend;
import com.help.reward.shop.model.GoodsHairInfo;
import com.help.reward.shop.model.GoodsInfo;
import com.help.reward.shop.model.HistorySearch;
import com.help.reward.shop.model.ShopInfo;
import com.help.reward.shop.model.StCredit;
import com.help.reward.shop.model.StDeliverycredit;
import com.help.reward.shop.model.StDesccredit;
import com.help.reward.shop.model.StServicecredit;
import com.help.reward.shop.model.StoreInfo;
import com.help.reward.shop.utils.JsonUtil;
import com.help.reward.shop.utils.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.help.reward.shop.datastore.cloud.parser.ParserUtils.parserBaseJson;
import static com.help.reward.shop.utils.JsonUtil.getMapForJson;

/**
 * Created by wwb on 2017/3/23.
 */

public class ParserTest {

    public static ShopInfo parserShopInfo(String json) {
        String shopjson = ParserUtils.parserBaseJson(json);//返回data里面的内容
        ShopInfo shopInfo = new ShopInfo();

        GoodsInfo goodsInfo = new GoodsInfo();
        StoreInfo storeInfo = new StoreInfo();
        GoodsHairInfo goodsHairInfo = new GoodsHairInfo();
        List<GoodsCommend> goodsCommends;
        Map<String, Object> keyMap = null;
        try {
            JSONObject dataJson = new JSONObject(shopjson);
            //goodsHairInfo
            if (dataJson.optJSONObject(SpInfoKey.GOODS_HAIR_INFO) != null) {
                JSONObject info = dataJson.optJSONObject(SpInfoKey.GOODS_HAIR_INFO);
                goodsHairInfo.setContent(info.optString(SpInfoKey.GoodsKey.GOODS_CONTENT));
                goodsHairInfo.setAreaName(info.optString(SpInfoKey.GoodsKey.GOODS_AREA_NAME));
            }
            //goodsInfo
            if (dataJson.optJSONObject(SpInfoKey.GOODS_INFO) != null) {
                JSONObject info = dataJson.optJSONObject(SpInfoKey.GOODS_INFO);

                goodsInfo.setId(info.optInt(SpInfoKey.GoodsKey.GOODS_ID));
                goodsInfo.setJingle(info.optString(SpInfoKey.GoodsKey.GOODS_JINGLE));
                goodsInfo.setPrice(info.optDouble(SpInfoKey.GoodsKey.GOODS_PRICE));
                goodsInfo.setCostprice(info.optDouble(SpInfoKey.GoodsKey.GOODS_COSTPRICE));
                goodsInfo.setClick(info.optInt(SpInfoKey.GoodsKey.GOODS_CLICK));
                goodsInfo.setPromotionPrice(info.optDouble(SpInfoKey.GoodsKey.GOODS_PROMOTIONPRICE));
                goodsInfo.setSalenum(info.optInt(SpInfoKey.GoodsKey.GOODS_SALENUM));
                goodsInfo.setImage(StringUtil.splitImageStr(dataJson.optString(SpInfoKey.GoodsKey.GOODS_IMAGE), ","));
                goodsInfo.setName(info.optString(SpInfoKey.GoodsKey.GOOD_NAME));
                goodsInfo.setMarketprice(info.optDouble(SpInfoKey.GoodsKey.GOODS_MARKET_PRICE));
                goodsInfo.setContent(goodsHairInfo.getContent());
                goodsInfo.setAreaName(goodsHairInfo.getAreaName());

                Map<String, Map<String, Object>> valueMap = new HashMap<>();
                //先将spec_name转成map，看可以获取到里面的key和value；
                if (info.optString(SpInfoKey.SPEC_NAME) != null && (!info.optString(SpInfoKey.SPEC_NAME).equalsIgnoreCase(""))) {
                    keyMap = JsonUtil.getMapForJson(info.optString(SpInfoKey.SPEC_NAME));
                }

                //先将spec_value转成对象，然后遍历上面的map通过key获取对应的string，然后再转成map
                if (info.optJSONObject(SpInfoKey.SPEC_VALUE) != null) {
                    JSONObject valueObj = info.optJSONObject(SpInfoKey.SPEC_VALUE);
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
            if (dataJson.optJSONObject(SpInfoKey.STORE_INFO) != null) {
                JSONObject info = dataJson.optJSONObject(SpInfoKey.STORE_INFO);
                storeInfo.setId(info.optInt(SpInfoKey.StoreKey.STORE_ID));
                storeInfo.setName(info.optString(SpInfoKey.StoreKey.STORE_NAME));
                storeInfo.setMemberId(info.optInt(SpInfoKey.StoreKey.MEMBER_ID));
                StCredit stCredit = new StCredit();
                if (info.optJSONObject(SpInfoKey.StoreKey.STORE_CREDIT) != null) {
                    JSONObject stCreditJosnObj = info.optJSONObject(SpInfoKey.StoreKey.STORE_CREDIT);
                    if (stCreditJosnObj.optJSONObject(SpInfoKey.StoreKey.STORE_DESCCREDIT) != null) {
                        JSONObject stDes = stCreditJosnObj.optJSONObject(SpInfoKey.StoreKey.STORE_DESCCREDIT);
                        StDesccredit stDesccredit = new StDesccredit();
                        stDesccredit.setCredit(stDes.optDouble(SpInfoKey.StoreKey.CREDIT));
                        stCredit.setStoreDesccredit(stDesccredit);
                    }
                    if (stCreditJosnObj.optJSONObject(SpInfoKey.StoreKey.STORE_SERVICECREDIT) != null) {
                        JSONObject stService = stCreditJosnObj.optJSONObject(SpInfoKey.StoreKey.STORE_SERVICECREDIT);
                        StServicecredit stServicecredit = new StServicecredit();
                        stServicecredit.setCredit(stService.optDouble(SpInfoKey.StoreKey.CREDIT));
                        stCredit.setStoreServicecredit(stServicecredit);
                    }
                    if (stCreditJosnObj.optJSONObject(SpInfoKey.StoreKey.STORE_DELIVECREDIT) != null) {
                        JSONObject stdelive = stCreditJosnObj.optJSONObject(SpInfoKey.StoreKey.STORE_DELIVECREDIT);
                        StDeliverycredit stDeliverycredit = new StDeliverycredit();
                        stDeliverycredit.setCredit(stdelive.optDouble(SpInfoKey.StoreKey.CREDIT));
                        stCredit.setStoreDeliverycredit(stDeliverycredit);
                    }

                }
                storeInfo.setStoreCredit(stCredit);
                shopInfo.setStoreInfo(storeInfo);
            }
            //commendlist
            if (dataJson.optJSONArray(SpInfoKey.GOODS_COMMEND_LIST) != null) {
                JSONArray array = dataJson.optJSONArray(SpInfoKey.GOODS_COMMEND_LIST);
                if (array != null && array.length() > 0) {
                    goodsCommends = new ArrayList<GoodsCommend>();
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject commend = array.getJSONObject(i);
                        GoodsCommend goodsCommend = new GoodsCommend();
                        goodsCommend.setId(commend.optInt(SpInfoKey.GoodCommend.GOOD_COMMEND_ID));
                        goodsCommend.setName(commend.optString(SpInfoKey.GoodCommend.GOOD_COMMEND_NAME));
                        goodsCommend.setPromotionPrice(commend.optDouble(SpInfoKey.GoodCommend.GOOD_COMMEND_PROMOTIONPRICE));
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
                    goodsInfo.setImage(StringUtil.splitImageStr(goodsObj.optString(SpInfoKey.GoodsKey.GOODS_IMAGE), ","));
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

    public static HistorySearch ParserHistorySearch(String json) {
        HistorySearch historySearch = new HistorySearch();
        try {
            JSONObject dataJson = new JSONObject(ParserUtils.parserBaseJson(json));

            if (dataJson.optJSONArray(SpInfoKey.HIS_LIST) != null && (dataJson.optJSONArray(SpInfoKey.HIS_LIST).length() > 0)) {
                JSONArray hisArray = dataJson.optJSONArray(SpInfoKey.HIS_LIST);
                List<String> hisList = new ArrayList<>();
                for (int i = 0; i < hisArray.length(); i++) {
                    hisList.add(hisArray.optString(i));
                }
                historySearch.setHis_list(hisList);
            }
            if (dataJson.optJSONArray(SpInfoKey.LIST) != null && (dataJson.optJSONArray(SpInfoKey.LIST).length() > 0)) {
                JSONArray array = dataJson.optJSONArray(SpInfoKey.LIST);
                List<String> list = new ArrayList<>();
                for (int i = 0; i < array.length(); i++) {
                    list.add(array.optString(i));
                }
                historySearch.setHis_list(list);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return historySearch;
    }

    public static List<GoodsClass> ParserGoodsClassList(String json) {
        List<GoodsClass> goodsClases = null;
        try {
            JSONObject dataJson = new JSONObject(parserBaseJson(json));
            JSONArray jsonArray = dataJson.optJSONArray(SpInfoKey.CLASSLIST);
            if (jsonArray != null && jsonArray.length() > 0) {
                goodsClases = new Gson().fromJson(dataJson.optString(SpInfoKey.CLASSLIST),
                        new TypeToken<List<GoodsClass>>() {
                        }.getType());
                //                for (int i = 0; i < jsonArray.length(); i++) {
                //                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                //
                //                }


            }


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return goodsClases;
    }


}