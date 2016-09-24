package com.antonkazakov.vkvault.screens.files_screen.presenters;

import android.util.Log;

import com.antonkazakov.vkvault.BuildConfig;
import com.antonkazakov.vkvault.api.ApiFactory;
import com.antonkazakov.vkvault.models.docs.get.DocListItem;
import com.antonkazakov.vkvault.models.savefile.SaveFileResponse;
import com.antonkazakov.vkvault.models.uploadfile.UploadFileResponse;
import com.antonkazakov.vkvault.repository.DocsRepository;
import com.antonkazakov.vkvault.repository.DocsRepositoryProvider;
import com.antonkazakov.vkvault.screens.files_screen.views.DocsView;
import com.vk.sdk.VKSdk;

import java.util.List;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import retrofit2.Response;
import rx.Observer;
import rx.functions.Action0;

/**
 * Created by antonkazakov on 23.09.16.
 */

public class DocsPresenterImpl implements DocsPresenter{

    DocsView docsView;

    public DocsPresenterImpl(DocsView docsView){
        this.docsView = docsView;
    }

    @Override
    public void getDocuments() {
        DocsRepositoryProvider.provideGithubRepository()
                .documents(VKSdk.getAccessToken().userId)
                .doOnSubscribe(() -> docsView.showLoading())
                .doOnTerminate(() -> docsView.hideLoading())
                .subscribe(new Observer<List<DocListItem>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("BLA", "onError: ",e );
                    }

                    @Override
                    public void onNext(List<DocListItem> docListItems) {
                        docsView.getDocs(docListItems);
                        Log.d("SHARAPOV", String.valueOf(docListItems.size()));
                    }
                });
    }

    @Override
    public void uploadFile(MultipartBody.Part part) {
        DocsRepositoryProvider.provideGithubRepository()
                .uploadFile(part)
                .doOnSubscribe(() -> docsView.showLoading())
                .doOnTerminate(() -> docsView.hideLoading())
                .subscribe(new Observer<Response<UploadFileResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<UploadFileResponse> uploadFileResponseResponse) {

                    }
                });
    }


    @Override
    public void saveFile(String file, String title, String tags) {
        DocsRepositoryProvider.provideGithubRepository()
                .saveFile(file,title,tags)
                .doOnSubscribe(() -> docsView.showLoading())
                .doOnTerminate(() -> docsView.hideLoading())
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
