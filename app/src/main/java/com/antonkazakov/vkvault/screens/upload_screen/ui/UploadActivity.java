package com.antonkazakov.vkvault.screens.upload_screen.ui;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.antonkazakov.vkvault.R;
import com.antonkazakov.vkvault.base.activities.BaseActivity;
import com.antonkazakov.vkvault.screens.upload_screen.presenters.UploadPresenterImpl;
import com.antonkazakov.vkvault.screens.upload_screen.views.UploadView;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;

import butterknife.BindView;
import butterknife.OnClick;


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


        mPresenter = new UploadPresenterImpl(this);
        mPresenter.init();
    }

    public void showRestricion(){
        mRestTitle.setText("sdfsdf");
        mRest1.setText("sd2111f");
        mRest2.setText("sdfsdf2222");
        mRest3.setText("sdfsdf3333");
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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri selectedFile = data.getData();
            File f = new File(selectedFile.getPath());
            long size = f.length();
            ParcelFileDescriptor mInputPFD;
            try {
                mInputPFD = getContentResolver().openFileDescriptor(selectedFile, "r");
                mRestTitle.setText(selectedFile.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                mRestTitle.setText("File not found." + e.getMessage());
                Log.e("MainActivity", "File not found." + e.getMessage());
                return;
            }
            FileDescriptor fd = mInputPFD != null ? mInputPFD.getFileDescriptor() : null;

            Toast.makeText(this, (fd != null ? fd.toString() : null) + "/" + size , Toast.LENGTH_LONG).show();
        }
    }
}
