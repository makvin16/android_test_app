package com.zm.data.repository;

import com.zm.data.mapper.user.UserMapper;
import com.zm.data.remote.ApiService;
import com.zm.testapp.domain.model.user.UserDomain;
import com.zm.testapp.domain.repository.UserRepository;
import com.zm.testapp.domain.usecase.user.GetUsersUseCase;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepositoryImpl implements UserRepository {

    private final ApiService apiService;
    private final UserMapper userMapper;

    @Inject
    public UserRepositoryImpl(ApiService apiService, UserMapper userMapper) {
        this.apiService = apiService;
        this.userMapper = userMapper;
    }

    @Override
    public Single<List<UserDomain>> getUsers(GetUsersUseCase.Params params) {
        return apiService.getUsers(params.getCount()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(listDtoWrapper -> listDtoWrapper.getData().stream()
                                .map(userMapper::mapToDomain)
                                .collect(Collectors.toList())
                );
    }
}
