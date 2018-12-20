package com.huaiangg.mvptestdemo04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.huaiangg.mvptestdemo04.bean.User;
import com.huaiangg.mvptestdemo04.presenter.LoginPresenter;
import com.huaiangg.mvptestdemo04.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edUsername;
    private EditText edPassword;
    private Button btnLogin;
    private Button btnCancel;
    private ProgressBar pbDialog;

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    public String getUserName() {
        return edUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return edPassword.getText().toString().trim();
    }

    @Override
    public void showLoginDialog() {
        pbDialog.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginDialog() {
        pbDialog.setVisibility(View.GONE);
    }

    @Override
    public void showErrorToast(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(MainActivity.this, "用户名:" +
                user.getUsername() + "\n登陆成功!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        edUsername.setText("");
    }

    @Override
    public void clearPassword() {
        edPassword.setText("");
    }

    private void initView() {
        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        btnLogin = findViewById(R.id.btn_login);
        btnCancel = findViewById(R.id.btn_cancel);
        pbDialog = findViewById(R.id.pb_dialog);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 静茹点静安寺啊实打实的阿斯顿撒旦");
                loginPresenter.login();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: tyutyutryurtyurtu");
                loginPresenter.clear();
            }
        });
    }

}
