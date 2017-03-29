package com.help.reward.shop.fragment.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.help.reward.shop.Component;
import com.help.reward.shop.R;
import com.help.reward.shop.datastore.cloud.loader.SpInfoLoader;
import com.help.reward.shop.datastore.translate.SpInfoKey;
import com.help.reward.shop.model.ShopInfo;
import com.help.reward.shop.utils.GlobalParams;

/**
 * Created by richsjeson on 17/3/22.
 * 创建一个 商品介绍页面
 */

@SuppressLint("ValidFragment")
public class SpInfoFragment extends Fragment implements  LoaderManager.LoaderCallbacks<ShopInfo> {

    private SpInfoLoader mLoader;

    @SuppressLint("ValidFragment")
    public SpInfoFragment(int shopId) {

        Bundle args = new Bundle();
        args.putInt(SpInfoKey.GoodsKey.GOODS_ID, shopId);
        setArguments(args);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sp_introduce,null);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(Component.LoaderMapKey.SHOP_INFO,null,this).forceLoad();

    }

    @Override
    public Loader<ShopInfo> onCreateLoader(int id, Bundle args) {
        if(mLoader == null){
            mLoader=new SpInfoLoader(getActivity(),getArguments().getInt(SpInfoKey.GoodsKey.GOODS_ID));
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<ShopInfo> loader, ShopInfo data) {
        //处理结果返回的数据，更新至UI层
    }

    @Override
    public void onLoaderReset(Loader<ShopInfo> loader) {

    }
}
