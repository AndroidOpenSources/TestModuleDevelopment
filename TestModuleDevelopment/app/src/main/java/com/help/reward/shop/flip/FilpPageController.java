package com.help.reward.shop.flip;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.help.reward.shop.fragment.detail.ShopDetailFragment;
import com.help.reward.shop.fragment.detail.ShopInfoFragment;
import com.help.reward.shop.fragment.detail.ShopRemarkFragment;

import java.util.List;

/**
 * Created by richsjeson on 17/3/22.
 * @see <p>控制页</p>
 */

public class FilpPageController extends FragmentStatePagerAdapter {


    private List<String> mTitles;
    private FragmentManager mManager;

    public FilpPageController(FragmentManager fragmentManager,List<String> mTitles){
        super(fragmentManager);
        this.mTitles=mTitles;
    }

    public FilpPageController(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new ShopInfoFragment();
                break;
            case 1:
                fragment=new ShopDetailFragment();
                break;
            case 2:
                fragment=new ShopRemarkFragment();
                return fragment;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
