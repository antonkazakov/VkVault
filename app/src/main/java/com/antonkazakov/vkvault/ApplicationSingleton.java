package com.antonkazakov.vkvault;

import android.app.Application;
import android.content.Context;


import com.vk.sdk.VKSdk;

/**
 * Created by antonkazakov on 19.09.16.
 */
public class ApplicationSingleton  extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(getApplicationContext());
    }


}
