package com.zm.data.mapper.user;

import com.zm.data.mapper.Mapper;
import com.zm.data.model.user.UserDto;
import com.zm.data.model.user.UserNameDto;
import com.zm.testapp.domain.model.user.UserDetailsDomain;
import javax.inject.Inject;

public class UserDetailsMapper implements Mapper<UserDto, UserDetailsDomain> {

    @Inject
    public UserDetailsMapper() {

    }

    @Override
    public UserDetailsDomain mapToDomain(UserDto dto) {
        return UserDetailsDomain.builder()
                .photoUrl(dto.getUserPhoto().getPhotoLarge())
                .fullName(getUserFullName(dto.getUserName()))
                .age(dto.getUserDateOfBirth().getAge())
                .email(dto.getEmail())
                .city(dto.getUserLocation().getCity())
                .state(dto.getUserLocation().getState())
                .country(dto.getUserLocation().getCountry())
                .build();
    }

    public String getUserFullName(UserNameDto userName) {
        return userName.getTitle() + " " +
                userName.getFirst() + " " +
                userName.getLast();
    }
}
