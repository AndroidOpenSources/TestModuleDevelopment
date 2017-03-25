package com.help.reward.shop.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.help.reward.shop.R;
import com.help.reward.shop.datastore.translate.SpInfoKey;
import com.help.reward.shop.flip.FlipPageController;

import static com.help.reward.shop.DefaultMainActivity.mTabLayout;

/**
 * Created by richsjeson on 17/3/22.
 * 主Fragment页面，承载着3个fragment
 */

public class MainFragment extends BaseFragment implements ViewPager.OnPageChangeListener{

    private FlipPageController controller;

    private ViewPager mViewPager;


    public MainFragment(){

    }

    @SuppressLint("ValidFragment")
    public MainFragment(int id){
        Bundle args = new Bundle();
        args.putInt(SpInfoKey.GOODS_ID, id);
        setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_main,null);
        mViewPager= (ViewPager) view.findViewById(R.id.vp_main_sp);
        mViewPager.setAdapter(controller);
        if(controller==null){
            mTabLayout.setupWithViewPager(mViewPager);
        }
        return view;

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
