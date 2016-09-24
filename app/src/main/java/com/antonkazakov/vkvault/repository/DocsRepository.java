package com.antonkazakov.vkvault.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.antonkazakov.vkvault.models.docs.get.DocListItem;
import com.antonkazakov.vkvault.models.savefile.SaveFileData;
import com.antonkazakov.vkvault.models.savefile.SaveFileResponse;
import com.antonkazakov.vkvault.models.uploadfile.UploadFileResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Response;
import rx.Observable;


/**
 * Created by antonkazakov on 23.09.16.
 */

public interface DocsRepository {

    @NonNull
    Observable<List<DocListItem>> documents(String owner_id);

    @NonNull
    Observable<Response<UploadFileResponse>> uploadFile(MultipartBody.Part part);

    @NonNull
    Observable<Response<SaveFileResponse>> saveFile(String file, @Nullable String title , @Nullable String tag);



}
