package com.help.reward.shop.adapter;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by richsjeson on 17/3/22.
 * 抽象的父适配器
 */

public abstract class AbstractBaseAdapter extends android.widget.BaseAdapter {

    protected AppCompatActivity mContext;

    public AbstractBaseAdapter(AppCompatActivity mContext){

        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            //初始化Layout
            view = newView(mContext,position, parent);
        } else {
            view = convertView;
        }
        //采用ViewHolder绑定数据
        bindView(view,position,mContext);
        return view;
    }

    void bindView(View view, int position, AppCompatActivity mContext) {
        bindView(view,position);
    }

    View newView(AppCompatActivity mContext, int position, ViewGroup parent) {

        return newView(position,parent);
    }

    public abstract View newView(int position,ViewGroup parent);
    public abstract void bindView(View view,int position);

}
