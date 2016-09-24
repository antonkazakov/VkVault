package com.antonkazakov.vkvault.models.uploadfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by antonkazakov on 23.09.16.
 */

@Generated("org.jsonschema2pojo")
public class UploadFileResponse {

    @SerializedName("file")
    @Expose
    private String file;

    /**
     *
     * @return
     * The file
     */
    public String getFile() {
        return file;
    }

    /**
     *
     * @param file
     * The file
     */
    public void setFile(String file) {
        this.file = file;
    }

}

