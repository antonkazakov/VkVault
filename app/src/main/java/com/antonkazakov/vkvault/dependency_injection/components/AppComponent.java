package com.antonkazakov.vkvault.dependency_injection.components;

import com.antonkazakov.vkvault.dependency_injection.modules.AppModule;
import com.antonkazakov.vkvault.dependency_injection.modules.NetworkModule;
import com.antonkazakov.vkvault.dependency_injection.modules.RepositoryModule;
import com.antonkazakov.vkvault.screens.login_screen.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by antonkazakov on 19.09.16.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, RepositoryModule.class})
public interface AppComponent {

    void inject(LoginActivity loginActivity);

}
