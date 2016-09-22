package com.antonkazakov.vkvault.screens.login_screen.ui;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;


import com.antonkazakov.vkvault.R;
import com.antonkazakov.vkvault.base.activities.BaseActivity;

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

    @OnClick(R.id.choose_button)
    public void onChooseButtonClick(){
        Intent intent = new Intent (Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

            startActivityForResult(Intent.createChooser(intent, "Select files"), 1);

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
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri selectedFile = data.getData();
            Toast.makeText(this,selectedFile.toString(),Toast.LENGTH_LONG).show();
        }
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
