package com.antonkazakov.vkvault.api;

import com.antonkazakov.vkvault.models.docs.get.GetDocsResponse;
import com.antonkazakov.vkvault.models.getserver.GetUploadServerUrl;
import com.antonkazakov.vkvault.models.savefile.SaveFileResponse;
import com.antonkazakov.vkvault.models.uploadfile.UploadFileResponse;


import okhttp3.MultipartBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;


/**
 * Created by antonkazakov on 19.09.16.
 */
public interface RetrofitService {


    @GET("docs.get")
    Observable<Response<GetDocsResponse>> getDocs(@Query("owner_id") String owner_id,@Query("v") String version, @Query("access_token") String token);


    @GET("docs.getUploadServer")
    Observable<Response<GetUploadServerUrl>> getUploadUrl(@Query("access_token") String token);


    @Multipart
    @POST
    Observable<Response<UploadFileResponse>> uploadFile(@Url String url, @Part MultipartBody.Part file, @Part("access_token") String token);

    @GET("docs.save")
    Observable<Response<SaveFileResponse>> saveFile(@Query("file") String file, @Query("title") String title, @Query("") String tags, @Part("access_token") String token);

}
