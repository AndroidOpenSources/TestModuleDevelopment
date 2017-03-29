package com.help.reward.shop.utils;

/**
 * Created by wwb on 2017/3/29.
 */

public class StringUtil {

    public static String[] splitImageStr(String s, String flag) {
        if (s.contains(",")) {
            return s.split(flag);
        }
        String[] strings = new String[1];
        strings[0] = s;
        return strings;
    }
}
