package com.jksoft.myandroidmvp1.main;

import java.util.List;

/**
 * Created by Jirka on 16.10.2016.
 */

public interface MainView {
    void showProgress();
    void hideProgress ();
    void showMessage (String text);
    void setListItems (List<String> list);
}
