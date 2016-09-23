package com.antonkazakov.vkvault.screens.upload_screen.presenters;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.antonkazakov.vkvault.screens.upload_screen.views.UploadView;

/**
 * Created by shara on 22.09.2016.
 */

public class UploadPresenterImpl implements UploadPresenter {

    private final UploadView mUploadView;

    public UploadPresenterImpl(@NonNull UploadView uploadView) {
        mUploadView = uploadView;
    }

    public void init() {
        mUploadView.showRestricion();
    }

    public void  chooseFile(){
        Intent intent = new Intent (Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                | Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);

        mUploadView.showChooser(intent,"Выберите файл...",1);
    }
}
