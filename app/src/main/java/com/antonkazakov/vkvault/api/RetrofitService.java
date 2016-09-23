package com.antonkazakov.vkvault.api;

import com.antonkazakov.vkvault.models.docs.get.GetDocsResponse;


import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by antonkazakov on 19.09.16.
 */
public interface RetrofitService {


    @GET("docs.get")
    Observable<Response<GetDocsResponse>> getDocs(@Query("owner_id") String owner_id, @Query("access_token") String token);


}
