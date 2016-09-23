package com.antonkazakov.vkvault.screens.files_screen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.antonkazakov.vkvault.ApplicationSingleton;
import com.antonkazakov.vkvault.R;

import com.antonkazakov.vkvault.models.docs.get.DocListItem;
import com.antonkazakov.vkvault.api.RetrofitService;

import com.antonkazakov.vkvault.screens.files_screen.presenters.DocsPresenterImpl;
import com.antonkazakov.vkvault.screens.files_screen.views.DocsView;
import com.antonkazakov.vkvault.screens.upload_screen.ui.UploadActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DocsActivity extends AppCompatActivity implements DocsView{

    @OnClick(R.id.fab1)
    public void onFabClick(){
        Intent intent = new Intent(this, UploadActivity.class);
        startActivity(intent);
    }
    DocsPresenterImpl docsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docs);
        ButterKnife.bind(this);
        docsPresenter = new DocsPresenterImpl(this);
        docsPresenter.getDocuments();

    }

    @Override
    public void getDocs(List<DocListItem> docListItems) {
        Log.i("HAHAH", "getDocs: " + docListItems.size());
    }

    @Override
    public void onError() {

    }

    @Override
    public void onNoConnectionError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
