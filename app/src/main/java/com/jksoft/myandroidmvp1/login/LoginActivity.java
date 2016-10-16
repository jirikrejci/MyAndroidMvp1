package com.jksoft.myandroidmvp1.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.jksoft.myandroidmvp1.R;
import com.jksoft.myandroidmvp1.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.etUserName)  EditText etUsername;
    @BindView(R.id.etPassword)  EditText etPassword;
    @BindView(R.id.btnLogin)    Button btnLogin;
    @BindView(R.id.pbProgressBar) ProgressBar pbProgressBar;
    LoginPresenterImpl presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    public void setUsernameError(String errorString) {
        etUsername.setError(errorString);
    }

    @Override
    public void setPasswordError(String errorString) {
        etPassword.setError(errorString);
    }

    @OnClick(R.id.btnLogin)
    public void btnLoginOnClick() {
        presenter.validateCredentials(etUsername.getText().toString(), etPassword.getText().toString());
    }


    @Override
    public void navigateToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showProgress() {
        pbProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        pbProgressBar.setVisibility(View.GONE);

    }


}
