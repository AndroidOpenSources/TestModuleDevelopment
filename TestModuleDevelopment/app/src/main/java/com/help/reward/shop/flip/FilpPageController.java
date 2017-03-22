package com.help.reward.shop.flip;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
        return null;
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
