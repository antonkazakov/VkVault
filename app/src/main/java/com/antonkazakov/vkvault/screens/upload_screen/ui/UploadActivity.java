package com.antonkazakov.vkvault.screens.upload_screen.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.antonkazakov.vkvault.R;
import com.antonkazakov.vkvault.base.activities.BaseActivity;
import com.antonkazakov.vkvault.screens.upload_screen.presenters.UploadPresenterImpl;
import com.antonkazakov.vkvault.screens.upload_screen.views.UploadView;

import butterknife.BindView;
import butterknife.OnClick;
import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.arturvasilov.rxloader.LoaderLifecycleHandler;

public class UploadActivity  extends BaseActivity implements UploadView {

    @BindView(R.id.choose_button)
    Button mChooseButton;

    @BindView(R.id.restTitle)
    TextView mRestTitle;
    @BindView(R.id.rest1)
    TextView mRest1;
    @BindView(R.id.rest2)
    TextView mRest2;
    @BindView(R.id.rest3)
    TextView mRest3;

    @OnClick(R.id.choose_button)
    public void onChooseButtonClick(){
        mPresenter.chooseFile();
    }

    private UploadPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LifecycleHandler lifecycleHandler = LoaderLifecycleHandler.create(this, getSupportLoaderManager());
        mPresenter = new UploadPresenterImpl(lifecycleHandler, this);
        mPresenter.init();
    }

    public void showRestricion(){
        mRestTitle.setText(R.string.rest_title);
        mRest1.setText(R.string.rest1);
        mRest2.setText(R.string.rest2);
        mRest3.setText(R.string.rest3);
    }

    public void showChooser(Intent intent, String TitleChooser, int num){
        startActivityForResult(Intent.createChooser(intent, TitleChooser), num);
    }

    @Override
    public int getLayout() {
        return R.layout.upload_layout;
    }

    @Override
    public void showLoading(){

    }

    @Override
    public void hideLoading(){

    }

    @Override
    public void onError(){

    }

    @Override
    public void onNoConnectionError(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri selectedFile = data.getData();
            Toast.makeText(this, selectedFile.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
