package com.antonkazakov.vkvault.models.getserver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by antonkazakov on 23.09.16.
 */

public class ServerUrlResponse {


    @SerializedName("upload_url")
    @Expose
    private String uploadUrl;

    /**
     *
     * @return
     * The uploadUrl
     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     *
     * @param uploadUrl
     * The upload_url
     */
    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }


}
