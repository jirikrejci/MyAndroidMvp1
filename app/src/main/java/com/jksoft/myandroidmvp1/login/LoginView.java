package com.jksoft.myandroidmvp1.login;

/**
 * Created by Jirka on 15.10.2016.
 */

public interface LoginView {
    void setUsernameError (String errorString);
    void setPasswordError (String errorString);
    void navigateToMainActivity();
    void showProgress ();
    void hideProgress();

}
