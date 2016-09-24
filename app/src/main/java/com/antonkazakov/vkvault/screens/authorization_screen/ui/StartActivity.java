package com.antonkazakov.vkvault.screens.authorization_screen.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antonkazakov.vkvault.screens.maincontainer.ui.MainActivity;
import com.vk.sdk.VKSdk;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (VKSdk.getAccessToken()!=null){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }else{
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
    }

}
