package com.antonkazakov.vkvault.base.views;

/**
 * Created by antonkazakov on 19.09.16.
 */
public interface BaseView {

    void onError();

    void onNoConnectionError();

    void showLoading();

    void hideLoading();

}
