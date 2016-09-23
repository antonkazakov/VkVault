package com.antonkazakov.vkvault.screens.files_screen.views;

import com.antonkazakov.vkvault.base.views.BaseView;
import com.antonkazakov.vkvault.models.docs.get.DocListItem;

import java.util.List;

/**
 * Created by antonkazakov on 23.09.16.
 */

public interface DocsView extends BaseView{

    void getDocs(List<DocListItem> docListItems);

}
