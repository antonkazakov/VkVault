package com.antonkazakov.vkvault.screens.files_screen.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.antonkazakov.vkvault.ApplicationSingleton;
import com.antonkazakov.vkvault.R;

import com.antonkazakov.vkvault.models.docs.get.DocListItem;
import com.antonkazakov.vkvault.api.RetrofitService;

import com.antonkazakov.vkvault.screens.files_screen.presenters.DocsPresenterImpl;
import com.antonkazakov.vkvault.screens.files_screen.views.DocsView;

import java.util.List;

import javax.inject.Inject;

public class DocsActivity extends AppCompatActivity implements DocsView{


    DocsPresenterImpl docsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docs);
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
