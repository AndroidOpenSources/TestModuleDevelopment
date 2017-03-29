package com.help.reward.shop.fragment;

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
import com.help.reward.shop.datastore.cloud.loader.SpInfoSearchLoader;
import com.help.reward.shop.model.GoodsInfo;

import java.util.List;

/**
 * Created by wwb on 17/3/29.
 * 商品搜索页
 */
@SuppressLint("ValidFragment")
public class SpSearchFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<GoodsInfo>> {

    private SpInfoSearchLoader mLoader;


    @SuppressLint("ValidFragment")
    public SpSearchFragment(String key, double price_from, double price_to, int b_id, String keyword, String service) {
        Bundle args = new Bundle();

        args.putString("key", key);
        args.putDouble("price_from", price_from);
        args.putDouble("price_to", price_to);
        args.putInt("b_id", b_id);
        args.putString("keyword", keyword);
        args.putString("service", service);
        setArguments(args);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(Component.LoaderMapKey.SHOP_SEARCH, null, this).forceLoad();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sp_search, container, false);
    }


    @Override
    public Loader<List<GoodsInfo>> onCreateLoader(int id, Bundle args) {
        if (mLoader == null) {
            mLoader = new SpInfoSearchLoader(getActivity(), getArguments().getString("key"), getArguments().getDouble("price_from"), getArguments().getDouble("price_to"), getArguments().getInt("b_id"), getArguments().getString("keyword"), getArguments().getString("service"));
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<GoodsInfo>> loader, List<GoodsInfo> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<GoodsInfo>> loader) {

    }
}
