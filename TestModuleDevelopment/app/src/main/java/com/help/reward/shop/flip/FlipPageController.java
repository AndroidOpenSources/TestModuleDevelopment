package com.help.reward.shop.flip;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.help.reward.shop.fragment.detail.SpDetailFragment;
import com.help.reward.shop.fragment.detail.SpInfoFragment;
import com.help.reward.shop.fragment.detail.SpRemarkFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by richsjeson on 17/3/22.
 * @see <p>控制页</p>
 */

public class FlipPageController extends FragmentStatePagerAdapter {


    private List<String> mTitles;
    private FragmentManager mManager;
    private SpInfoFragment mShopInfoFragment;
    private SpDetailFragment mShopDetailFragment;
    private SpRemarkFragment mShopRemarkFragment;
    private ArrayList mFragments;
    private int spId;
    public FlipPageController(FragmentManager fragmentManager, List<String> mTitles,int spId){
        super(fragmentManager);
        this.mTitles=mTitles;
        this.mManager=fragmentManager;
        this.spId=spId;
        this.mFragments=new ArrayList();
    }

    public FlipPageController(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                if(mShopInfoFragment ==null) {
                    mShopInfoFragment = new SpInfoFragment(spId);
                    Map<Integer,Fragment>  map=new HashMap<Integer,Fragment>();
                    map.put(position,fragment);
                    mFragments.add(fragment);
                    fragment=mShopInfoFragment;
                }else{
                    if(mFragments.get(position)!=null){
                        Map<Integer,Fragment> maps= (Map<Integer,Fragment>) mFragments.get(position);
                        if(!maps.isEmpty()) {
                            Map.Entry<Integer, Fragment> fs = (Map.Entry<Integer, Fragment>) maps.entrySet();
                            fragment= fs.getValue();
                        }
                    }else{
                        fragment= null;
                    }
                }
            case 1:

                if(mShopDetailFragment==null){
                    mShopDetailFragment=new SpDetailFragment(spId);
                    Map<Integer,Fragment>  map=new HashMap<Integer,Fragment>();
                    map.put(position,fragment);
                    mFragments.add(fragment);
                    fragment=mShopDetailFragment;
                }else{
                    if(mFragments.get(position)!=null){
                        Map<Integer,Fragment> maps= (Map<Integer,Fragment>) mFragments.get(position);
                        if(!maps.isEmpty()) {
                            Map.Entry<Integer, Fragment> fs = (Map.Entry<Integer, Fragment>) maps.entrySet();
                            fragment= fs.getValue();
                        }
                    }else{
                        fragment= null;
                    }
                }
            case 2:
                if(mShopRemarkFragment==null) {
                    mShopRemarkFragment = new SpRemarkFragment(spId);
                    Map<Integer,Fragment>  map=new HashMap<Integer,Fragment>();
                    map.put(position,fragment);
                    mFragments.add(fragment);
                    fragment= mShopRemarkFragment;
                }else{
                    if(mFragments.get(position)!=null){
                        Map<Integer,Fragment> maps= (Map<Integer,Fragment>) mFragments.get(position);
                        if(!maps.isEmpty()) {
                            Map.Entry<Integer, Fragment> fs = (Map.Entry<Integer, Fragment>) maps.entrySet();
                            fragment= fs.getValue();
                        }
                    }else{
                        fragment=null;
                    }
                }

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
