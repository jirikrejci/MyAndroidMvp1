package com.jksoft.myandroidmvp1.main;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jirka on 16.10.2016.
 */

public class FindItemsInteractorImpl implements FindItemsInteractor {
    private List<String> listItems = null;

    public FindItemsInteractorImpl() {
        listItems = new ArrayList<>();
        for (int i=0;i<20; i++) {
            listItems.add("List item " + Integer.toString(i));
        }
    }


    @Override
    public void getAllListItems(final OnFinishedListener listener) {

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<String> outputList = new ArrayList<>();
                outputList.addAll(listItems);
                listener.onFinishedGetAllItems(outputList);
            }
        };
        handler.postDelayed(runnable, 600);
    }

    @Override
    public void getListItem(int p, OnFinishedListener listener) {
        listener.onFinishedGetItem(listItems.get(p));
    }
}
