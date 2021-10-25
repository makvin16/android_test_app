package com.zm.testapp.domain.repository;

import com.zm.testapp.domain.model.user.UserDomain;
import com.zm.testapp.domain.usecase.user.GetUsersUseCase;
import java.util.List;
import io.reactivex.Single;

public interface UserRepository {

    Single<List<UserDomain>> getUsers(GetUsersUseCase.Params params);
}
