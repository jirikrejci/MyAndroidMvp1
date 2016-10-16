package com.jksoft.myandroidmvp1.main;

import java.util.List;

/**
 * Created by Jirka on 16.10.2016.
 */

public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {
    private MainView mainView;
    private FindItemsInteractor findItemsInteractor;


    public MainPresenterImpl (MainView mainView, FindItemsInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }
        findItemsInteractor.getAllListItems(this);

    }

    @Override
    public void onDestroy() {
        mainView = null;

    }

    @Override
    public void onItemClicked(int position) {
        findItemsInteractor.getListItem(position, this);
    }

    @Override
    public void onFinishedGetAllItems(List<String> items) {
        if (null != mainView) {
            mainView.setListItems(items);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFinishedGetItem(String item) {
        if (null != mainView) {
            mainView.showMessage("Clicked on " + item);

        }
    }
}
