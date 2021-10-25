package com.zm.data.model.user;

import com.google.gson.annotations.SerializedName;
import com.zm.data.model.Dto;

public class UserDto implements Dto {

    @SerializedName("name")
    private UserNameDto userName;
    @SerializedName("picture")
    private UserPhotoDto userPhoto;
    @SerializedName("location")
    private UserLocationDto userLocation;
    @SerializedName("dob")
    private UserDateOfBirthDto userDateOfBirth;
    private String email;

    public UserNameDto getUserName() {
        return userName;
    }

    public UserPhotoDto getUserPhoto() {
        return userPhoto;
    }

    public UserLocationDto getUserLocation() {
        return userLocation;
    }

    public UserDateOfBirthDto getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public String getEmail() {
        return email;
    }
}
