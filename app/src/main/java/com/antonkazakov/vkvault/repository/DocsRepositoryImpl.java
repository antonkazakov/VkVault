package com.antonkazakov.vkvault.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.antonkazakov.vkvault.api.ApiFactory;
import com.antonkazakov.vkvault.api.RetrofitService;
import com.antonkazakov.vkvault.models.docs.get.DocListItem;
import com.antonkazakov.vkvault.models.docs.get.GetDocsResponse;
import com.antonkazakov.vkvault.models.getserver.GetUploadServerUrl;
import com.antonkazakov.vkvault.models.savefile.SaveFileData;
import com.antonkazakov.vkvault.models.savefile.SaveFileResponse;
import com.antonkazakov.vkvault.models.uploadfile.UploadFileResponse;
import com.vk.sdk.VKSdk;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by antonkazakov on 23.09.16.
 */

public class DocsRepositoryImpl implements DocsRepository {

    @NonNull
    @Override
    public Observable<List<DocListItem>> documents(@NonNull final String owner_id) {
        return ApiFactory.getRetrofitService().getDocs(owner_id, "5.53",VKSdk.getAccessToken().accessToken)
                .flatMap(getDocsResponseResponse -> Observable.just(getDocsResponseResponse.body().getResponse().getItems()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    @Override
    public Observable<Response<UploadFileResponse>> uploadFile(MultipartBody.Part part) {
        return ApiFactory.getRetrofitService().getUploadUrl(VKSdk.getAccessToken().accessToken)
                .flatMap(getUploadServerUrlResponse ->
                        ApiFactory.getRetrofitService().uploadFile(getUploadServerUrlResponse.body().getResponse().getUploadUrl(),part,""))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @NonNull
    @Override
    public Observable<Response<SaveFileResponse>> saveFile(String file, @Nullable String title, @Nullable String tag) {
        return ApiFactory.getRetrofitService().saveFile(file,title,tag,VKSdk.getAccessToken().accessToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
