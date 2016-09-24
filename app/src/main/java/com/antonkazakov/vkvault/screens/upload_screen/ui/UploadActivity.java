package com.antonkazakov.vkvault.screens.upload_screen.ui;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AlertDialog;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.antonkazakov.vkvault.R;
import com.antonkazakov.vkvault.base.activities.BaseActivity;
import com.antonkazakov.vkvault.screens.upload_screen.presenters.UploadPresenterImpl;
import com.antonkazakov.vkvault.screens.upload_screen.views.UploadView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;



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
    private String mimetype;
    private String size;
    private String type;
    private String extension;
    private static HashMap<String, String> types = new HashMap<>();
    private AlertDialog.Builder ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mPresenter = new UploadPresenterImpl(this);
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
        Toast.makeText(getApplicationContext(), "Загрузка начата",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading(){
        Toast.makeText(getApplicationContext(), "Загрузка завершена",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(){

    }

    @Override
    public void onNoConnectionError(){

    }

    public void mimeInit(){
        types.put("doc","application/msword");
        types.put("docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        types.put("xls","application/vnd.ms-excel");
        types.put("xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        types.put("ppt","application/vnd.ms-powerpoint");
        types.put("pptx","application/vnd.openxmlformats-officedocument.presentationml.presentation");
        types.put("rtf","application/rtf");
        types.put("pdf","application/pdf");
        types.put("png","image/png");
        types.put("jpeg","image/jpeg");
        types.put("jpg","image/jpeg");
        types.put("gif","image/gif");
        types.put("psd","application/octet-stream");
        types.put("rar","application/x-rar-compressed");
        types.put("zip","application/zip");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri selectedFile = data.getData();
            File f = new File(selectedFile.getPath());
            extension = selectedFile.toString().substring(selectedFile.toString().lastIndexOf(".") + 1, selectedFile.toString().length());
            mimetype = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            ParcelFileDescriptor mInputPFD;
            size = "Превышен допустимый размер файла.";
            if(f.length()/1000000 < 199) {
                size = "Размер файла: " + String.valueOf(f.length()/1000000) + " Мб";
            }
            if(mimetype != null) {
                type = "Выбран недопустимый тип файла. (" + mimetype.split("/")[1] + ")";
                mimeInit();
                if (types.get(mimetype.split("/")[1]) != null) {
                    type = "Тип файла: " + mimetype.split("/")[1];
                }
            } else {
                type = "Выбран недопустимый тип файла.";
            }

            try {
                mInputPFD = getContentResolver().openFileDescriptor(selectedFile, "r");
                mRestTitle.setText(f.getName());
                mRest1.setText(size);
                mRest2.setText(type);
                mRest3.setText("Авторство проверить мы не можем!");
                if(mimetype != null && f.length()/1000000 < 199){
                    ad = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
                    ad.setTitle("Загрузка файла на сервер");  // заголовок
                    ad.setMessage("Подтвердите загрузку файла"); // сообщение
                    ad.setPositiveButton("Да", (dialog, arg1) -> {
                        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), f);
                        MultipartBody.Part body = MultipartBody.Part.createFormData("file", f.getName(), requestFile);
                        mPresenter.uploadFile(body,f.getName());
                    });
                    ad.setNegativeButton("Нет", (dialog, arg1) -> showRestricion());
                    ad.setCancelable(true);
                    ad.setOnCancelListener(dialog -> showRestricion());
                    ad.show();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                mRestTitle.setText("Критическая ошибка. Попробуйте ещё...");
            }
            //FileDescriptor fd = mInputPFD != null ? mInputPFD.getFileDescriptor() : null;

        }
    }
}
