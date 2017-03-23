package com.help.reward.shop.flip;

/**
 *
 *  <p>页面跳转控制</p>
 *  需要用全局堆栈进行管理
 */
public interface IntentTransfer {
    //跳转主页
    public void goMainPage();
    //跳转购物车
    public void goShopCartPage();
    //跳转订单页面
    public void goOrderPage();
}
