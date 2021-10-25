package com.zm.data.model;

import com.google.gson.annotations.SerializedName;

public class DtoWrapper<T> implements Dto {

    @SerializedName("results")
    private T data;

    public T getData() {
        return data;
    }
}
