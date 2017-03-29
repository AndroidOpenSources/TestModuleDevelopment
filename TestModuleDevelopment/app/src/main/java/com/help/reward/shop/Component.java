package com.help.reward.shop;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ListView;

import com.help.reward.shop.datastore.translate.SpInfoKey;
import com.help.reward.shop.fragment.BaseFragment;
import com.help.reward.shop.module.BaseModule;
import com.help.reward.shop.module.MainModule;
import com.help.reward.shop.module.SpCartModule;
import com.help.reward.shop.utils.GlobalParams;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static android.R.attr.fragment;

/**
 * Created by richsjeson on 17/3/22.
 * 组件入口类，管理application和context，以及activity的生命
 */

public class Component {

    private List<String> mNavigationItems;

    private List<ListView> mViews;

    private static Retrofit retrofit;

    private static Context mContext;

    private static FragmentActivity mActivity;

    private static Component mComponent;

    private List<BaseModule> mModules;

    private int id;
    /**
     * 获取当前的模块
     */
    private BaseModule module;

    private static final String TAG=Component.class.getSimpleName();
    private static final String LOAD_TAG="组件装载过程：%s";

    private RefWatcher refWatcher;

    private Component(Context mContext,FragmentActivity activity) {

        this.mContext=mContext;
        this.mActivity=activity;
        mModules=new ArrayList<BaseModule>();
//        refWatcher = LeakCanary.install(mActivity.getApplication());
//        refWatcher.watch(activity);
    }

    public static Context getContext() {

        return mContext;
    }


    public Component bindID(int id){
        this.id=id;
        return this;
    }

    public  static  Component getInstance(Context context,FragmentActivity activity){

        if(mComponent==null){
            mComponent=new Component(context,activity);
        }
        return mComponent;
    }

    void addModule(BaseModule module){

        if(!mModules.contains(module)){
            mModules.add(module);
        }
    }
    //装载模块
    public void init(){

        addModule(initMainModule());
        addModule(new SpCartModule());
        android.util.Log.i(TAG,String.format(LOAD_TAG,"初始化装载组件"));
    }
    //初始化第一个moduleId
    BaseModule initMainModule(){
        MainModule mainModule=new MainModule();
        Bundle  bundle=new Bundle();
        bundle.putInt(SpInfoKey.GoodsKey.GOODS_ID,id);
        mainModule.setArguments(bundle);
        mainModule.bindModule(0);
        module=mainModule;
        return module;
    }
    //初始化装载
    public void load(){
        android.util.Log.i(TAG,String.format(LOAD_TAG,"读取组件"));
        try {
            FragmentTransaction transaction = mActivity.getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frl_launcher_sh, (Fragment) mModules.get(0));
            transaction.commitAllowingStateLoss();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadModule(int index){
        BaseModule baseModule=mModules.get(index);
        if(!baseModule.findModule(index)){
            baseModule.bindModule(index);
        }
        BaseFragment currentFragment= (BaseFragment) module;
        BaseFragment toFragment=(BaseFragment) baseModule;
        baseModule.repleace(currentFragment,toFragment,R.id.frl_launcher_sh);
    }

    public void removeModule(){
        //从堆栈移除
        if(mActivity.getSupportFragmentManager().getBackStackEntryCount()>0) {
            mActivity.getSupportFragmentManager().popBackStackImmediate();
            android.util.Log.i(TAG,String.format(LOAD_TAG,"返回上一页面"));
        }else {
            //遍历所有操作
            mActivity.finish();
            //如果当前的Fragment
            module.uninstall();
            android.util.Log.i(TAG,String.format(LOAD_TAG,"移除所有组件"));
        }
    }

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(GlobalParams.DOMAIN).addConverterFactory(ScalarsConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static FragmentActivity getActivity(){
        return mActivity;
    }

    /**
     * <p>获取Item列表的参数集合</p>
     *
     * @return
     */
    public List<String> getNavigationItems() {
        if (mNavigationItems == null) {

            mNavigationItems = new ArrayList<String>();
            mNavigationItems.add(mContext.getResources().getString(R.string.navigation_bar_title_info));
            mNavigationItems.add(mContext.getResources().getString(R.string.navigation_bar_title_detail));
            mNavigationItems.add(mContext.getResources().getString(R.string.navigation_bar_title_remark));
        }
        return mNavigationItems;
    }

    /**
     * <p>获取页面</p>
     *
     * @return
     */
    public List<ListView> getPage() {

        if (mViews == null) {
            mViews = new ArrayList<ListView>();
            mViews.add(new ListView(mContext));
            mViews.add(new ListView(mContext));
            mViews.add(new ListView(mContext));
        }
        return mViews;
    }


    public int getBtnBottomWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels / 2 + 100;
    }

    public int getIconBottomWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels / 2 - 100;
    }

    //商品Loader的键值对
    public static class LoaderMapKey {
        //商品详情
        public static final int SHOP_INFO = 1;
        //商品评价
        public static final int SHOP_REMARK = 2;
        public static final int SHOP_INSTRODUCE = 3;
    }

    /**
     * @see <p>将制定的参数对应到该页面中</p>
     */
    public static class ShopStyleParams {
        /**
         * @see <p>颜色</p>
         */
        public static String color = "1";
        /**
         * @see <p>尺码</p>
         */
        public static String size = "15";
        /**
         * @see <p>材质</p>
         */
        public static String material = "16";
    }

    /**
     * @see <p>根据dp转px</p>
     * @param dps
     * @return
     */
    public static int dpToPx(int dps) {
        return Math.round(mContext.getResources().getDisplayMetrics().density * (float)dps);
    }


    public static void logInfo(String msg){
        android.util.Log.i(TAG,String.format(LOAD_TAG,msg));
    }
}



