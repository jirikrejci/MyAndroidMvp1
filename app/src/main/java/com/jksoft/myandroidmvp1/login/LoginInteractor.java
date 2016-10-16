package com.jksoft.myandroidmvp1.login;

/**
 * Created by Jirka on 15.10.2016.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        public void onUsernameError();
        public void onPasswordError();
        public void onSuccess ();
    }

    void login (String userName, String password, OnLoginFinishedListener onLoginFinishedListener);
}
