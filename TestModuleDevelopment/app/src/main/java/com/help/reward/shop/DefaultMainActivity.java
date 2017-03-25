package com.help.reward.shop;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.help.reward.shop.flip.IntentTransfer;
import com.help.reward.shop.fragment.MainFragment;

/**
 * Created by richsjeson on 17/3/22.
 * 整体架构：
 *  分层：
 *    mvp
 *  架构属性：
 *    activity fragment 1对多
 *  数据仓储
 *    -data 存储cart数据
 *
 *   -filp层 控制层
 *
 *   -model层 实体层
 *   -ui 层 自定义组件层
 *   -utils 工具层
 *
 */

public class DefaultMainActivity extends AppCompatActivity implements IntentTransfer {

    private MainFragment mainFragment;
    private int S_ID=257;
    //给Fragment中进行复用
    public  static Toolbar mToolBar;
    public  static TabLayout mTabLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolBar= (Toolbar) findViewById(R.id.tb_common_toolbar_shop);
        mTabLayout= (TabLayout) findViewById(R.id.tab_common_shop);
        //如果当前为空，则初始化操作
        if(savedInstanceState==null){
            mainFragment=new MainFragment(S_ID);
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frl_launcher_sh,mainFragment);
            transaction.commitAllowingStateLoss();
        }else{
            //获取S_ID的参数，防止activity Home返回或者应用程序被finish后，再次进入时发生NULL

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("S_ID",S_ID);
    }

    @Override
    public void goMainPage() {

    }

    @Override
    public void goShopCartPage() {

    }

    @Override
    public void goOrderPage() {

    }
}
