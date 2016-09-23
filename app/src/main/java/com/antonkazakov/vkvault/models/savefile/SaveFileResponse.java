package com.antonkazakov.vkvault.models.savefile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonkazakov on 23.09.16.
 */

public class SaveFileResponse {

    @SerializedName("response")
    @Expose
    private List<SaveFileData> response = new ArrayList<SaveFileData>();

    /**
     *
     * @return
     * The response
     */
    public List<SaveFileData> getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(List<SaveFileData> response) {
        this.response = response;
    }

}
