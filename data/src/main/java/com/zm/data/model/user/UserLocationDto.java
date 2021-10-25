package com.zm.data.model.user;

import com.zm.data.model.Dto;

public class UserLocationDto implements Dto {

    private String city;
    private String state;
    private String country;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
