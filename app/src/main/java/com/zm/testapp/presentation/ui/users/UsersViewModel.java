package com.zm.testapp.presentation.ui.users;

import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zm.testapp.R;
import com.zm.testapp.domain.model.user.UserDomain;
import com.zm.testapp.domain.usecase.user.GetUsersUseCase;
import com.zm.testapp.presentation.model.Result;
import com.zm.testapp.presentation.ui.BaseViewModel;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

public class UsersViewModel extends BaseViewModel<List<UserDomain>> {

    private static final String TAG = UsersViewModel.class.getSimpleName();
    private static final int COUNT_USERS = 20;

    private final GetUsersUseCase getUsersUseCase;

    @Inject
    public UsersViewModel(GetUsersUseCase getUsersUseCase) {
        super();
        Timber.tag(TAG).d("init");
        this.getUsersUseCase = getUsersUseCase;
        fetchUsers();
    }

    private final MutableLiveData<Result<List<UserDomain>>> _liveDataUsers = new MutableLiveData<>();
    public LiveData<Result<List<UserDomain>>> liveDataUsers = _liveDataUsers;
    public void fetchUsers() {
        Timber.tag(TAG).d("fetch users");
        _liveDataUsers.postValue(new Result.Builder().loading());
        GetUsersUseCase.Params params = new GetUsersUseCase.Params(COUNT_USERS);
        getUsersUseCase.execute(params).subscribe(getSingleObservable());
    }

    @Override
    protected void onSuccess(List<UserDomain> users) {
        if (users != null) {
            Timber.tag(TAG).d("onSuccess " + users.size());
            Timber.tag(TAG).d("onSuccess " + users.toString());
            _liveDataUsers.setValue(new Result.Builder().success(users));
        } else {
            _liveDataUsers.setValue(new Result.Builder().error(R.string.error_server));
        }
    }

    @Override
    protected void onError(@StringRes int stringError) {
        _liveDataUsers.setValue(new Result.Builder().error(stringError));
    }
}
