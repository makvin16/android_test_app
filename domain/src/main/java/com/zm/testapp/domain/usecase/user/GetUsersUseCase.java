package com.zm.testapp.domain.usecase.user;

import com.zm.testapp.domain.model.user.UserDomain;
import com.zm.testapp.domain.repository.UserRepository;
import com.zm.testapp.domain.usecase.UseCase;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Single;

public class GetUsersUseCase implements UseCase<GetUsersUseCase.Params, Single<List<UserDomain>>> {

    private final UserRepository userRepository;

    @Inject
    public GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Single<List<UserDomain>> execute(GetUsersUseCase.Params params) {
        if (params != null) {
            return userRepository.getUsers(params);
        }
        return Single.never();
    }

    public static class Params {

        private final int count;

        public Params(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }
}
