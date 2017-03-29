package com.help.reward.shop.module;

import com.help.reward.shop.fragment.BaseFragment;

/**
 * Created by richsjeson on 17/3/29.
 * 基于OSGI的装载体系
 */

public interface BaseModule {

     void bindModule(int id);

     Boolean findModule(int id);
    //模块装载
     void install();
     void resolved();
    //卸载模块
     void uninstall();
    //模块重启
     void restart();
    //模块关闭
     void stop();
    //模块启动
     void start();
    //替换模块
     void repleace(BaseFragment fragment, BaseFragment toFragment, int fragmentid);
}
