package com.antonkazakov.vkvault.models.getserver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by antonkazakov on 23.09.16.
 */

public class GetUploadServerUrl {

    @SerializedName("response")
    @Expose
    private ServerUrlResponse response;

    /**
     *
     * @return
     * The response
     */
    public ServerUrlResponse getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(ServerUrlResponse response) {
        this.response = response;
    }

}
