package com.help.reward.shop.base;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wwb on 2017/3/23.
 */

public class ParserTest {
    public static void paeserShopInfo(String json){
        try {
            JSONObject resultJson = new JSONObject(json);
            if (resultJson != null){
                //判断返回码
                if (resultJson.optInt("code")==200){
                    if (resultJson.optString("data")!=null && (!resultJson.optString("data").equalsIgnoreCase(""))){

                    }
                }
            }

















        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
