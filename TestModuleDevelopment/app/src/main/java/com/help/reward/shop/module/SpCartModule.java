package com.help.reward.shop.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.help.reward.shop.Component;
import com.help.reward.shop.R;
import com.help.reward.shop.fragment.BaseFragment;

/**
 * Created by richsjeson on 17/3/29.
 */

public class SpCartModule extends BaseFragment implements BaseModule {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Component.logInfo("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Component.logInfo("onCreateView");
        return getActivity().getLayoutInflater().inflate(R.layout.fragment_sp_card,null);

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
