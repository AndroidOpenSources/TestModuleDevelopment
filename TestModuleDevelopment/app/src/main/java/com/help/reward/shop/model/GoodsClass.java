package com.help.reward.shop.model;

import java.util.Arrays;

/**
 * Created by wwb on 2017/3/25.
 * 类别
 */

public class GoodsClass {
    private int gc_id;
    private String gc_name;
    private int type_id;
    private String type_name;
    private int gc_parentId;
    private double commis_rate;
    private int gc_sort;
    private int gc_virtual;
    private String gc_title;
    private String[] gc_keyWords;
    private String gc_description;
    private int gc_show;

    public int getGc_id() {
        return gc_id;
    }

    public void setGc_id(int gc_id) {
        this.gc_id = gc_id;
    }

    public String getGc_name() {
        return gc_name;
    }

    public void setGc_name(String gc_name) {
        this.gc_name = gc_name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public int getGc_parentId() {
        return gc_parentId;
    }

    public void setGc_parentId(int gc_parentId) {
        this.gc_parentId = gc_parentId;
    }

    public double getCommis_rate() {
        return commis_rate;
    }

    public void setCommis_rate(double commis_rate) {
        this.commis_rate = commis_rate;
    }

    public int getGc_sort() {
        return gc_sort;
    }

    public void setGc_sort(int gc_sort) {
        this.gc_sort = gc_sort;
    }

    public int getGc_virtual() {
        return gc_virtual;
    }

    public void setGc_virtual(int gc_virtual) {
        this.gc_virtual = gc_virtual;
    }

    public String getGc_title() {
        return gc_title;
    }

    public void setGc_title(String gc_title) {
        this.gc_title = gc_title;
    }

    public String[] getGc_keyWords() {
        return gc_keyWords;
    }

    public void setGc_keyWords(String[] gc_keyWords) {
        this.gc_keyWords = gc_keyWords;
    }

    public String getGc_description() {
        return gc_description;
    }

    public void setGc_description(String gc_description) {
        this.gc_description = gc_description;
    }

    public int getGc_show() {
        return gc_show;
    }

    public void setGc_show(int gc_show) {
        this.gc_show = gc_show;
    }

    @Override
    public String toString() {
        return "GoodsClass{" +
                "gc_id=" + gc_id +
                ", gc_name='" + gc_name + '\'' +
                ", type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                ", gc_parentId=" + gc_parentId +
                ", commis_rate=" + commis_rate +
                ", gc_sort=" + gc_sort +
                ", gc_virtual=" + gc_virtual +
                ", gc_title='" + gc_title + '\'' +
                ", gc_keyWords=" + Arrays.toString(gc_keyWords) +
                ", gc_description='" + gc_description + '\'' +
                ", gc_show=" + gc_show +
                '}';
    }
}
