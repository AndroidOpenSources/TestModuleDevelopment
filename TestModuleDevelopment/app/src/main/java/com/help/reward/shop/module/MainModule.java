package com.help.reward.shop.module;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.help.reward.shop.Component;
import com.help.reward.shop.R;
import com.help.reward.shop.datastore.translate.SpInfoKey;
import com.help.reward.shop.flip.FlipPageController;
import com.help.reward.shop.fragment.BaseFragment;
import com.help.reward.shop.model.ShopInfo;

import java.lang.reflect.Field;
import java.util.List;

import static com.help.reward.shop.DefaultMainActivity.frlTopbar;


/**
 * Created by richsjeson on 17/3/22.
 * 主Fragment页面，承载着3个fragment
 */

public class MainModule extends BaseFragment implements BaseModule,ViewPager.OnPageChangeListener{

    private FlipPageController controller;

    private ViewPager mViewPager;

    private List<String> mTitles;

    public  TabLayout mTabLayout;


    public MainModule(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitles=Component.getInstance(this.getContext(),getActivity()).getNavigationItems();
        Log.i(this.getClass().getName(),"bundle id:="+getArguments().getInt(SpInfoKey.GoodsKey.GOODS_ID));
        Component.logInfo("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Component.logInfo("onCreateView");
        View view=inflater.inflate(R.layout.fragment_main,null);
        mViewPager= (ViewPager) view.findViewById(R.id.vp_main_sp);
        View mTabBar=getActivity().getLayoutInflater().inflate(R.layout.include_tablayout,null);
        mTabLayout= (TabLayout)mTabBar.findViewById(R.id.tab_common_shop);
        if(controller==null){
            initTabParams();
            controller=new FlipPageController(this.getChildFragmentManager(),mTitles,getArguments().getInt(SpInfoKey.GoodsKey.GOODS_ID));
            mViewPager.setAdapter(controller);
            mTabLayout.setupWithViewPager(mViewPager);
        }
        mViewPager.setCurrentItem(0);
        return view;

    }


    //初始化参数列表
    void initTabParams(){

        mTabLayout.setSelectedTabIndicatorColor(Color.RED);
        mTabLayout.setTabTextColors(getResources().getColor(R.color.navigation_item),getResources().getColor(R.color.navigation_item));
        if(mTabLayout.getTabCount()==0) {
            if (mTitles != null && mTitles.size() > 0) {

                for (String navigationBarItem : mTitles) {

                    mTabLayout.addTab(mTabLayout.newTab().setText(navigationBarItem));
                }
            }
            frlTopbar.addView(mTabLayout);
        }
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

    @Override
    public void bindModule(int id) {
        this.moduleId=id;
    }

    @Override
    public Boolean findModule(int id) {
        if(this.moduleId==id){
            return true;
        }
        return false;
    }

    @Override
    public void install() {

    }

    @Override
    public void resolved() {

    }

    @Override
    public void uninstall() {
        controller=null;
        detach();
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void repleace(BaseFragment oldModule, BaseFragment newModule, int fragmentid) {
        changeFragment(oldModule,newModule,fragmentid);
    }
}
