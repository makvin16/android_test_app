package com.zm.testapp.di.module;

import com.zm.testapp.domain.repository.UserRepository;
import com.zm.testapp.domain.usecase.user.GetUsersUseCase;
import dagger.Module;
import dagger.Provides;

@Module(includes = {RepositoryModule.class})
public class UseCaseModule {

    @Provides
    GetUsersUseCase provideGetUsersUseCase(
        UserRepository userRepository
    ) {
        return new GetUsersUseCase(userRepository);
    }
}
