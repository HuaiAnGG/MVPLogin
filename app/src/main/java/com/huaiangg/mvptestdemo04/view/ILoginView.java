package com.huaiangg.mvptestdemo04.view;

import com.huaiangg.mvptestdemo04.bean.User;

/**
 * @description: Login接口
 * @author: HuaiAngg
 * @create: 2018-12-20 19:32
 */
public interface ILoginView {

    /**
     * 获取用户名
     */
    String getUserName();

    /**
     * 获取密码
     */
    String getPassword();

    /**
     * 打开登陆动画
     */
    void showLoginDialog();

    /**
     * 隐藏登陆动画
     */
    void hideLoginDialog();

    /**
     * 登陆错误提示
     * @param error
     */
    void showErrorToast(String error);

    /**
     * 登陆成功
     */
    void loginSuccess(User user);

    /**
     * 清空用户名
     */
    void clearUserName();

    /**
     * 清空密码
     */
    void clearPassword();
}
