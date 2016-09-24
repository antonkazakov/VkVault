package com.antonkazakov.vkvault.screens.upload_screen.presenters;


import okhttp3.MultipartBody;

public interface UploadPresenter {

    void uploadFile(MultipartBody.Part part, String title);

    void saveFile(String file, String title, String tags);
}
