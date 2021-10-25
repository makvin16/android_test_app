package com.zm.data.remote;

import com.zm.data.model.DtoWrapper;
import com.zm.data.model.user.UserDto;
import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/")
    Single<DtoWrapper<List<UserDto>>> getUsers(
            @Query("results") int countResults
    );
}
