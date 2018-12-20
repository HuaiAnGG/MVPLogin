package com.huaiangg.mvptestdemo04.model;

/**
 * @description: Model类
 * @author: HuaiAngg
 * @create: 2018-12-20 19:42
 */
public interface ILoginModel {

    /**
     * 登录
     */
    void login(String username, String password, OnLoginListener listener);
}
