package com.antonkazakov.vkvault.screens.upload_screen.presenters;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.antonkazakov.vkvault.screens.upload_screen.views.UploadView;

import ru.arturvasilov.rxloader.LifecycleHandler;

/**
 * Created by shara on 22.09.2016.
 */

public class UploadPresenterImpl implements UploadPresenter {

    private final LifecycleHandler mLifecycleHandler;
    private final UploadView mUploadView;

    public UploadPresenterImpl(@NonNull LifecycleHandler lifecycleHandler,
                         @NonNull UploadView uploadView) {
        mLifecycleHandler = lifecycleHandler;
        mUploadView = uploadView;
    }

    public void init() {
        mUploadView.showRestricion();
    }

    public void  chooseFile(){
        Intent intent = new Intent (Intent.ACTION_GET_CONTENT);
        intent.setType("application/doc|application/docx|application/xls|application/xlsx|application/ppt|application/pptx|application/pdf|application/rtf|application/png|application/jpg|application/gif|application/psd|application/djvu|application/fb2");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        mUploadView.showChooser(intent,"Выберите файл...",1);
    }
}
