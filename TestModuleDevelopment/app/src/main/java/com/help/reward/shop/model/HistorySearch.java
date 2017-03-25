package com.help.reward.shop.model;

import java.util.List;

/**
 * Created by wwb on 2017/3/25.
 */

public class HistorySearch {
    //历史搜索
    private List<String> his_list;
    //热门搜索
    private List<String> list;

    public List<String> getHis_list() {
        return his_list;
    }

    public void setHis_list(List<String> his_list) {
        this.his_list = his_list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HistorySearch{" +
                "his_list=" + his_list +
                ", list=" + list +
                '}';
    }
}
