package com.help.reward.shop.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by richsjeson on 17/3/22.
 * 主Fragment页面，承载着3个fragment
 */

public class MainFragment extends Fragment {


    public MainFragment(){

    }

    @SuppressLint("ValidFragment")
    public MainFragment(int id){



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return super.onCreateView(inflater, container, savedInstanceState);

    }

}
