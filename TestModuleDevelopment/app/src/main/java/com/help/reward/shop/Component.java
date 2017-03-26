package com.help.reward.shop;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.ListView;

import com.help.reward.shop.utils.GlobalParams;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by richsjeson on 17/3/22.
 * 组件入口类，管理application和context，以及activity的生命
 */

public class Component {

    private List<String> mNavigationItems;

    private List<ListView> mViews;

    private static Retrofit retrofit;

    private static Context mContext;

    private static Activity mActivity;

    public Component(Context mContext,Activity activity) {

        this.mContext=mContext;
        this.mActivity=activity;
    }

    public static Context getContext() {

        return mContext;
    }


    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(GlobalParams.DOMAIN).addConverterFactory(ScalarsConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static Activity getActivity(){
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


}



