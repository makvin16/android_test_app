package com.zm.testapp.presentation.ui;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.ViewModel;
import com.zm.data.util.NoNetworkException;
import com.zm.testapp.R;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public abstract class BaseViewModel<T> extends ViewModel {

    private static final String TAG = BaseViewModel.class.getSimpleName();

    protected SingleObserver<T> getSingleObservable() {
        return new SingleObserver<T>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Timber.tag(TAG).d("onSubscribe");
            }

            @Override
            public void onSuccess(@NonNull T data) {
                Timber.tag(TAG).d("onSuccess");
                BaseViewModel.this.onSuccess(data);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Timber.tag(TAG).d("onError" + e);
                if (e instanceof NoNetworkException) {
                    BaseViewModel.this.onError(R.string.error_internet_connection);
                } else {
                    BaseViewModel.this.onError(R.string.error_connection);
                }
            }
        };
    }

    protected abstract void onSuccess(T data);

    protected abstract void onError(@StringRes int stringError);
}
