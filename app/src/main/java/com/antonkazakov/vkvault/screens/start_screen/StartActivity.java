package com.antonkazakov.vkvault.screens.start_screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antonkazakov.vkvault.screens.files_screen.ui.DocsActivity;
import com.antonkazakov.vkvault.screens.login_screen.ui.LoginActivity;
import com.vk.sdk.VKSdk;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (VKSdk.getAccessToken()!=null){
            startActivity(new Intent(this,DocsActivity.class));
            finish();
        }else{
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
    }

}
