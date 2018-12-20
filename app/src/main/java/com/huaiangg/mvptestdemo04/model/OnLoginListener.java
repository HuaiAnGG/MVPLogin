package com.huaiangg.mvptestdemo04.model;

import com.huaiangg.mvptestdemo04.bean.User;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2018-12-20 20:18
 */
public interface OnLoginListener {

    /**
     * 登陆成功
     * @param user 用户
     */
    void loginSuccess(User user);

    /**
     * 登陆失败
     */
    void loginFail();
}
