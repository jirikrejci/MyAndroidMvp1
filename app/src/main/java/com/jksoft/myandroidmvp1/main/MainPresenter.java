package com.jksoft.myandroidmvp1.main;

/**
 * Created by Jirka on 16.10.2016.
 */

public interface MainPresenter {
    void onResume ();
    void onDestroy ();
    void onItemClicked (int position);
    //void getAllListviewItems ();
}
