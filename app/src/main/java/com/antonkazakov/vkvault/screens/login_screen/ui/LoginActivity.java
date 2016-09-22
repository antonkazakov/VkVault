package com.antonkazakov.vkvault.screens.login_screen.ui;

import android.content.Intent;

import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;


import com.antonkazakov.vkvault.R;
import com.antonkazakov.vkvault.base.activities.BaseActivity;

import com.antonkazakov.vkvault.screens.upload_screen.ui.UploadActivity;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;


import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @OnClick(R.id.login_button)
    public void onLoginButtonClick(){
        VKSdk.login(this,"docs");
    }

    @OnClick(R.id.fab)
    public void onFabClick(){
        Intent intent = new Intent(this, UploadActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_login2;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {

            }
            @Override
            public void onError(VKError error) {

            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
