package com.antonkazakov.vkvault.screens.files_screen.presenters;

import okhttp3.MultipartBody;

/**
 * Created by antonkazakov on 23.09.16.
 */

public interface DocsPresenter {

    void getDocuments();

    void uploadFile(MultipartBody.Part part);

}
