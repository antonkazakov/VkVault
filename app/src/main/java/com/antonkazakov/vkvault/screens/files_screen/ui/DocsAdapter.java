package com.antonkazakov.vkvault.screens.files_screen.ui;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.antonkazakov.vkvault.R;
import com.antonkazakov.vkvault.models.docs.get.DocListItem;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by antonkazakov on 29.07.16.
 */
public class DocsAdapter extends RecyclerView.Adapter<DocsAdapter.DocsViewHolder>{

    List<DocListItem> docListItems;

    public DocsAdapter(List<DocListItem> docListItems){
        this.docListItems=docListItems;
    }

    @Override
    public DocsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DocsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.docslist_item,parent,false));
    }

    @Override
    public void onBindViewHolder(DocsViewHolder holder, int position) {

        holder.tv_name.setText(docListItems.get(position).getTitle());
        holder.tv_size.setText(docListItems.get(position).getSize()/1024/1024 + " мб.");

    }

    @Override
    public int getItemCount() {

        return docListItems.size();
    }



    public class DocsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_size)
        TextView tv_size;

        @BindView(R.id.img_type)
        ImageView img_type;

        public DocsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
