package com.antonkazakov.vkvault.models.docs.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by antonkazakov on 23.09.16.
 */
@Generated("org.jsonschema2pojo")
public class GetDocsResponse {

    @SerializedName("response")
    @Expose
    private DocsResponse response;

    /**
     *
     * @return
     * The response
     */
    public DocsResponse getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(DocsResponse response) {
        this.response = response;
    }

}
