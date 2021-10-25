package com.zm.testapp.domain.model.user;

import com.zm.testapp.domain.model.Domain;

public class UserDomain implements Domain {

    private String photoUrl;
    private String name;
    private UserDetailsDomain userDetails;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getName() {
        return name;
    }

    public UserDetailsDomain getUserDetails() {
        return userDetails;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "photoUrl='" + photoUrl + '\'' +
                ", name='" + name + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }

    public static Builder builder() {
        return new UserDomain().new Builder();
    }

    public class Builder {

        public Builder photoUrl(String photoUrl) {
            UserDomain.this.photoUrl = photoUrl;
            return this;
        }

        public Builder name(String name) {
            UserDomain.this.name = name;
            return this;
        }

        public Builder userDetails(UserDetailsDomain userDetails) {
            UserDomain.this.userDetails = userDetails;
            return this;
        }

        public UserDomain build() {
            return UserDomain.this;
        }
    }
}
