package com.help.reward.shop;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.help.reward.shop.flip.IntentTransfer;
import com.help.reward.shop.fragment.BaseFragment;
import com.help.reward.shop.module.MainModule;
import com.help.reward.shop.module.SpCartModule;

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

public class DefaultMainActivity extends AppCompatActivity implements IntentTransfer,View.OnClickListener {

    private BaseFragment fragment;
    private int S_ID=257;
    //给Fragment中进行复用
    public  static Toolbar mToolBar;
    public  static FrameLayout frlTopbar;
    public  static TextView mToolView;
    private  Component component;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slauncher);
        Component.logInfo(String.valueOf(savedInstanceState==null?true:false));
        //如果当前为空，则初始化操作
        if(savedInstanceState==null){
            component=Component.getInstance(getApplicationContext(),this);
            component.bindID(S_ID);
            component.init();
            component.load();
        }else{
            //获取S_ID的参数，防止activity Home返回或者应用程序被finish后，再次进入时发生NULL

        }
        initView();
    }
    void initView(){
        mToolBar= (Toolbar)findViewById(R.id.tb_common_toolbar_shop);
        mToolBar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_launcher_round));
        mToolView= (TextView) findViewById(R.id.popMenu);
        frlTopbar= (FrameLayout) findViewById(R.id.frl_topbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        mToolView.setOnClickListener(this);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击返回键的处理
                onNavigationClick();
            }
        });
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

    @Override
    public void onClick(View view) {

        //该出仅执行toolbar的操作
        if(view==mToolView){
            //执行操作
            component.loadModule(1);
        }

    }

    public void onNavigationClick(){
        component.removeModule();
    }

    @Override
    public void onBackPressed() {
        component.removeModule();
    }

    @Override
    public void finish() {
        component=null;
        super.finish();
    }
}
