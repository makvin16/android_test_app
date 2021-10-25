package com.zm.data.model.user;

import com.google.gson.annotations.SerializedName;
import com.zm.data.model.Dto;

public class UserPhotoDto implements Dto {

    @SerializedName("large")
    private String photoLarge;
    @SerializedName("thumbnail")
    private String photoThumbnail;

    public String getPhotoLarge() {
        return photoLarge;
    }

    public String getPhotoThumbnail() {
        return photoThumbnail;
    }
}
