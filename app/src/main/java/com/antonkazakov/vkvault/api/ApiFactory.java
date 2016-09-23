package com.antonkazakov.vkvault.api;

import android.support.annotation.NonNull;

import com.antonkazakov.vkvault.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by antonkazakov on 23.09.16.
 */

public class ApiFactory {

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor.getLoggingInterceptor())//Logging interceptor
            .addNetworkInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .method(chain.request().method(), chain.request().body())
                        .build();
                return chain.proceed(request);
            })
            //.readTimeout(Config.TIMEOUT, TimeUnit.MILLISECONDS)// timeout to show exception
            //.connectTimeout(Config.TIMEOUT, TimeUnit.MILLISECONDS)// timeout to show exception
            .build();






    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.vk.com/method/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    @NonNull
    public static RetrofitService getRetrofitService() {
       return  retrofit.create(RetrofitService.class);
    }


}
