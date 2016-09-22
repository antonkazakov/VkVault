package com.antonkazakov.vkvault.screens.login_screen.presenters;


import com.antonkazakov.vkvault.network.RetrofitService;
import com.antonkazakov.vkvault.screens.login_screen.views.LoginView;


import retrofit2.Response;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by antonkazakov on 20.09.16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    RetrofitService retrofitService;
    LoginView loginView;


    public LoginPresenterImpl(RetrofitService retrofitService, LoginView loginView){
        this.retrofitService = retrofitService;
        this.loginView = loginView;
    }



    @Override
    public void logIn(String url,
                      String client_id,
                      String redirectURI,
                      String display,
                      String scope,
                      String response_type,
                      String version) {

        retrofitService.authorize(url,client_id,redirectURI,display,scope,response_type,version)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> loginView.showLoading())
                .doOnTerminate(() -> loginView.hideLoading())
                .subscribe(new Observer<Response<Object>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<Object> objectResponse) {

                    }
                });
    }


}
