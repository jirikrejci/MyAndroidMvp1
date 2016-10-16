package com.jksoft.myandroidmvp1.main;

import java.util.List;

/**
 * Created by Jirka on 16.10.2016.
 */

public interface FindItemsInteractor {

    interface OnFinishedListener {
        void onFinishedGetAllItems(List<String> items);
        void onFinishedGetItem(String item);
    }


    void getAllListItems(OnFinishedListener listener);
    void getListItem (int p, OnFinishedListener listener);

}
