package com.antonkazakov.vkvault.repository;

import android.support.annotation.NonNull;

import com.antonkazakov.vkvault.api.ApiFactory;
import com.antonkazakov.vkvault.models.docs.get.DocListItem;
import com.antonkazakov.vkvault.models.docs.get.GetDocsResponse;
import com.vk.sdk.VKSdk;

import java.util.List;

import retrofit2.Response;
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
        return ApiFactory.getRetrofitService().getDocs(owner_id, VKSdk.getAccessToken().accessToken)
                .flatMap(getDocsResponseResponse -> Observable.just(getDocsResponseResponse.body().getResponse().getItems()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
