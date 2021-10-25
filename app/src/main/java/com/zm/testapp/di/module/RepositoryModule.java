package com.zm.testapp.di.module;

import com.zm.data.mapper.user.UserMapper;
import com.zm.data.remote.ApiService;
import com.zm.data.repository.UserRepositoryImpl;
import com.zm.testapp.domain.repository.UserRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    UserRepository provideUserRepository(
            ApiService apiService,
            UserMapper userMapper
    ) {
        return new UserRepositoryImpl(apiService, userMapper);
    }
}
