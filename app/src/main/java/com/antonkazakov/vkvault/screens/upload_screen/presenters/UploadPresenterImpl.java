package com.antonkazakov.vkvault.screens.upload_screen.presenters;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.antonkazakov.vkvault.models.savefile.SaveFileResponse;
import com.antonkazakov.vkvault.models.uploadfile.UploadFileResponse;
import com.antonkazakov.vkvault.repository.DocsRepositoryProvider;
import com.antonkazakov.vkvault.screens.upload_screen.views.UploadView;

import okhttp3.MultipartBody;
import retrofit2.Response;
import rx.Observer;

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
    @Override
    public void uploadFile(MultipartBody.Part part, String titleFile) {
        DocsRepositoryProvider.provideGithubRepository()
                .uploadFile(part)
                .doOnSubscribe(mUploadView::showLoading)
                .doOnTerminate(mUploadView::hideLoading)
                .subscribe(new Observer<Response<UploadFileResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<UploadFileResponse> uploadFileResponseResponse) {
                        saveFile(uploadFileResponseResponse.body().getFile(),"","");
                    }
                });
    }


    @Override
    public void saveFile(String file, String title, String tags) {
        DocsRepositoryProvider.provideGithubRepository()
                .saveFile(file,title,tags)
                .doOnSubscribe(mUploadView::showLoading)
                .doOnTerminate(mUploadView::hideLoading)
                .subscribe(new Observer<Response<SaveFileResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<SaveFileResponse> saveFileResponseResponse) {

                    }
                });
    }

}
