package com.antonkazakov.vkvault.screens.upload_screen.views;

import android.content.Intent;

import com.antonkazakov.vkvault.base.views.BaseView;



public interface UploadView extends BaseView {

    void showRestricion();
    void showChooser(Intent intent, String TitleChooser, int num);
}
