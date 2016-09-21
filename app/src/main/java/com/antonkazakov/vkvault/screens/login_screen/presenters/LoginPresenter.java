package com.antonkazakov.vkvault.screens.login_screen.presenters;

/**
 * Created by antonkazakov on 20.09.16.
 */
public interface LoginPresenter {

    void logIn(String url,
               String client_id,
               String redirectURI,
               String display,
               String scope,
               String response_type,
               String version);

}
