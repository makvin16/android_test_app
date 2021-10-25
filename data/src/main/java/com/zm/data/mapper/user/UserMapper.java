package com.zm.data.mapper.user;

import com.zm.data.mapper.Mapper;
import com.zm.data.model.user.UserDto;
import com.zm.testapp.domain.model.user.UserDomain;
import javax.inject.Inject;

public class UserMapper implements Mapper<UserDto, UserDomain> {

    @Inject
    UserDetailsMapper userDetailsMapper;

    @Inject
    public UserMapper() {

    }

    @Override
    public UserDomain mapToDomain(UserDto dto) {
        return UserDomain.builder()
                .photoUrl(dto.getUserPhoto().getPhotoThumbnail())
                .name(dto.getUserName().getFirst())
                .userDetails(userDetailsMapper.mapToDomain(dto))
                .build();
    }
}
