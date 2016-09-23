package com.antonkazakov.vkvault.repository;

import android.support.annotation.NonNull;

import com.antonkazakov.vkvault.models.docs.get.DocListItem;

import java.util.List;

import rx.Observable;


/**
 * Created by antonkazakov on 23.09.16.
 */

public interface DocsRepository {

    @NonNull
    Observable<List<DocListItem>> documents(String owner_id);

}
