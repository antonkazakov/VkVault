package com.antonkazakov.vkvault.screens.files_screen.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antonkazakov.vkvault.R;
import com.antonkazakov.vkvault.models.docs.get.DocListItem;
import com.antonkazakov.vkvault.screens.files_screen.presenters.DocsPresenterImpl;
import com.antonkazakov.vkvault.screens.files_screen.views.DocsView;
import com.antonkazakov.vkvault.utils.recyclerstuff.ClickListener;
import com.antonkazakov.vkvault.utils.recyclerstuff.DividerItemDecoration;
import com.antonkazakov.vkvault.utils.recyclerstuff.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DocsFragment extends Fragment implements DocsView{

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    DocsAdapter docsAdapter;

    DocsPresenterImpl docsPresenter;

    List<DocListItem> docListItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_docs, container, false);
        ButterKnife.bind(this,view);
        initRecyclerView();
        docsPresenter.getDocuments();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        docsPresenter = new DocsPresenterImpl(this);
        docsAdapter = new DocsAdapter(docListItems);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private void initRecyclerView(){

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(() -> docsPresenter.getDocuments());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(docsAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }

            @Override
            public void onDoubleClick(View view, int position) {

            }
        }));

    }


    @Override
    public void getDocs(List<DocListItem> docListItems1) {
        Log.i("BLA", "getDocs: " + docListItems1.size());
        docListItems.clear();
        docListItems.addAll(docListItems1);
        docsAdapter.notifyDataSetChanged();
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
