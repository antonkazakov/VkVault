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
        switch(docListItems.get(position).getType()) {
            case 1:
                holder.img_type.setImageResource(R.drawable.i1);
                break;
            case 2:
                holder.img_type.setImageResource(R.drawable.i2);
                break;
            case 3:
                holder.img_type.setImageResource(R.drawable.i3);
                break;
            case 4:
                holder.img_type.setImageResource(R.drawable.i4);
                break;
            case 5:
                holder.img_type.setImageResource(R.drawable.i5);
                break;
            case 6:
                holder.img_type.setImageResource(R.drawable.i6);
                break;
            case 7:
                holder.img_type.setImageResource(R.drawable.i7);
                break;
            default:
                break;
        }


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
