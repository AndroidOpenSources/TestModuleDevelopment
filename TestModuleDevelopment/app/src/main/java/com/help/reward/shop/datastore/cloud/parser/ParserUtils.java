package com.help.reward.shop.datastore.cloud.parser;

import com.help.reward.shop.datastore.cloud.restapi.BusinessCode;
import com.help.reward.shop.datastore.translate.BusinessCodeKey;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by richsjeson on 17/3/22.
 */

public class ParserUtils {
    public static BusinessCode businessCode = new BusinessCode();

    public static String parserBaseJson(String json) {
        try {
            JSONObject resultJson = new JSONObject(json);
            if (resultJson != null) {
                businessCode.setCode(resultJson.optInt(BusinessCodeKey.CODE));
                businessCode.setMsg(resultJson.optString(BusinessCodeKey.MSG));
                if (resultJson.optBoolean(BusinessCodeKey.HASMORE)) {
                    businessCode.setHashmore(resultJson.optBoolean(BusinessCodeKey.HASMORE));
                }
                if (resultJson.optString(BusinessCodeKey.PAGE_TOTAL) != null) {
                    businessCode.setPage_total(resultJson.optInt(BusinessCodeKey.PAGE_TOTAL));
                }
                //判断返回码
                if (resultJson.optInt("code") == 200) {
                    if (resultJson.optString("data") != null && (!resultJson.optString("data").equalsIgnoreCase(""))) {
                        businessCode.setData(resultJson.optString(BusinessCodeKey.DATA));
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
}
