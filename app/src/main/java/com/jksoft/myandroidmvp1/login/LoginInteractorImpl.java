package com.jksoft.myandroidmvp1.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Jirka on 16.10.2016.
 */

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void login(final String userName, final String password, final OnLoginFinishedListener onLoginFinishedListener) {
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(userName)) {
                    onLoginFinishedListener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)) {
                    onLoginFinishedListener.onPasswordError();
                    error = true;
                }
                if (!error) {
                    onLoginFinishedListener.onSuccess();
                }

            }
        };
        handler.postDelayed(runnable, 1000);

        }
}
