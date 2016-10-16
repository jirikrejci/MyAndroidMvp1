package com.jksoft.myandroidmvp1.login;

import android.content.Context;

import com.jksoft.myandroidmvp1.R;

/**
 * Created by Jirka on 15.10.2016.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener{

    private LoginView loginView = null;
    private Context context = null;
    private LoginInteractorImpl loginInteractorImpl = null;

    public  LoginPresenterImpl (LoginView loginView) {
        this.loginView = loginView;
        this.context = (Context) loginView;
        this.loginInteractorImpl = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractorImpl.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;

    }

    @Override
    public void onUsernameError() {
        if (null != loginView) {
            loginView.setUsernameError(context.getString(R.string.error_username));
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (null != loginView) {
            loginView.setPasswordError(context.getString(R.string.error_password));
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (null != loginView) {
            loginView.navigateToMainActivity();
        }
    }
}
