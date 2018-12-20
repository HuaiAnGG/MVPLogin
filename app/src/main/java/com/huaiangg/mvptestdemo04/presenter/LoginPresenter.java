package com.huaiangg.mvptestdemo04.presenter;

import android.os.Handler;

import com.huaiangg.mvptestdemo04.bean.User;
import com.huaiangg.mvptestdemo04.model.ILoginModel;
import com.huaiangg.mvptestdemo04.model.Login;
import com.huaiangg.mvptestdemo04.model.OnLoginListener;
import com.huaiangg.mvptestdemo04.view.ILoginView;

/**
 * @description: Presenter类
 * @author: HuaiAngg
 * @create: 2018-12-20 21:17
 */
public class LoginPresenter {

    private ILoginView loginView;
    private ILoginModel loginModel;
    private Handler handler = new Handler();

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new Login();
    }

    public void login() {
        loginView.showLoginDialog();
        loginModel.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.loginSuccess(user);
                        loginView.hideLoginDialog();
                    }
                });
            }

            @Override
            public void loginFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showErrorToast("登陆失败!");
                        loginView.hideLoginDialog();
                    }
                });
            }
        });
    }

    public void clear() {
        loginView.clearUserName();
        loginView.clearPassword();
    }
}
