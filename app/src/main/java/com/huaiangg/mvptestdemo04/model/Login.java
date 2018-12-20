package com.huaiangg.mvptestdemo04.model;

import com.huaiangg.mvptestdemo04.bean.User;

/**
 * @description:  登录实现
 * @author: HuaiAngg
 * @create: 2018-12-20 19:53
 */
public class Login implements ILoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("admin".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    listener.loginSuccess(user);
                }else {
                    listener.loginFail();
                }
            }
        }).start();
    }
}
