package com.antonkazakov.vkvault.network;

import java.util.Objects;


import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;


/**
 * Created by antonkazakov on 19.09.16.
 */
public interface RetrofitService {


    @GET
    Observable<Response<Object>> authorize(@Url String url,
                                           @Query("client_id") String client_id,
                                           @Query("redirect_uri") String redirectURI,
                                           @Query("display") String display,
                                           @Query("scope") String scope,
                                           @Query("response_type") String response_type,
                                           @Query("v") String version);
}
