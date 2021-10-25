package com.zm.testapp.domain.model.user;

import com.zm.testapp.domain.model.Domain;

public class UserDetailsDomain implements Domain {

    private String photoUrl;
    private String fullName;
    private int age;
    private String email;
    private String city;
    private String state;
    private String country;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "photoUrl='" + photoUrl + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static Builder builder() {
        return new UserDetailsDomain().new Builder();
    }

    public class Builder {

        public UserDetailsDomain build() {
            return UserDetailsDomain.this;
        }

        public Builder photoUrl(String photoUrl) {
            UserDetailsDomain.this.photoUrl = photoUrl;
            return this;
        }

        public Builder fullName(String fullName) {
            UserDetailsDomain.this.fullName = fullName;
            return this;
        }

        public Builder age(int age) {
            UserDetailsDomain.this.age = age;
            return this;
        }

        public Builder email(String email) {
            UserDetailsDomain.this.email = email;
            return this;
        }

        public Builder city(String city) {
            UserDetailsDomain.this.city = city;
            return this;
        }

        public Builder state(String state) {
            UserDetailsDomain.this.state = state;
            return this;
        }

        public Builder country(String country) {
            UserDetailsDomain.this.country = country;
            return this;
        }
    }
}
