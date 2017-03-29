package com.help.reward.shop.fragment.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.help.reward.shop.R;

/**
 * Created by richsjeson on 17/3/22.
 */

@SuppressLint("ValidFragment")
public class SpDetailFragment extends Fragment {

    public SpDetailFragment(int shopId) {
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sp_detail,null);
        return view;
    }
}
