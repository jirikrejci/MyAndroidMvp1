package com.jksoft.myandroidmvp1.login;

/**
 * Created by Jirka on 15.10.2016.
 */

public interface LoginPresenter {
    void validateCredentials (String username, String password);
    void onDestroy ();

}
