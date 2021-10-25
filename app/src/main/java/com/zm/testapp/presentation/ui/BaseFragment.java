package com.zm.testapp.presentation.ui;

import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.zm.testapp.presentation.AppActivity;
import com.zm.testapp.presentation.model.Result;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<Domain> extends DaggerFragment {

    protected <T extends ViewModel> T createViewModel(
            ViewModelProvider.Factory factory,
            Class<T> classType
    ) {
        return new ViewModelProvider(requireActivity(), factory).get(classType);
    }

    protected void observe(LiveData<Result<Domain>> liveData) {
        liveData.observe(getViewLifecycleOwner(), obs -> {
            switch (obs.getStage()) {
                case LOADING: {
                    observeLoading();
                    break;
                }
                case SUCCESS: {
                    observeSuccess(obs.getData());
                    break;
                }
                case ERROR: {
                    observeError(obs.getError());
                    break;
                }
            }
        });
    }

    private void observeLoading() {
        onLoading(true);
    }

    private void observeSuccess(Domain data) {
        onLoading(false);
        onSuccess(data);
    }

    private void observeError(int error) {
        onLoading(false);
        onError(error);
    }

    protected void visibilityProgressBar(boolean visibilityProgressBar) {
        ((AppActivity) requireActivity()).updateProgressBar(visibilityProgressBar);
    }

    protected NavController findNavController() {
        return NavHostFragment.findNavController(this);
    }

    protected abstract void onLoading(boolean isLoading);

    protected abstract void onSuccess(Domain data);

    protected abstract void onError(@StringRes int error);
}
