package com.antonkazakov.vkvault.utils.recyclerstuff;

import android.view.View;

/**
 * Created by antonkazakov on 03.07.16.
 */
public interface ClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);

    void onDoubleClick(View view, int position);

}
