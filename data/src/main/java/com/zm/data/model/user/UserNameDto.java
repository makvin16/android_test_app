package com.zm.data.model.user;

import com.zm.data.model.Dto;

public class UserNameDto implements Dto {

    private String title;
    private String first;
    private String last;

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
