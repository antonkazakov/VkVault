package com.antonkazakov.vkvault;

import android.app.Application;

import com.antonkazakov.vkvault.dependency_injection.components.AppComponent;
import com.antonkazakov.vkvault.dependency_injection.components.DaggerAppComponent;
import com.antonkazakov.vkvault.dependency_injection.modules.AppModule;
import com.antonkazakov.vkvault.dependency_injection.modules.NetworkModule;
import com.vk.sdk.VKSdk;

/**
 * Created by antonkazakov on 19.09.16.
 */
public class ApplicationSingleton  extends Application {

    AppComponent appComponent;
    public static ApplicationSingleton applicationSingleton;

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate() {
        super.onCreate();

        applicationSingleton = this;

        VKSdk.initialize(getApplicationContext());

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
