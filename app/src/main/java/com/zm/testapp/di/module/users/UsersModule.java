package com.zm.testapp.di.module.users;

import androidx.lifecycle.ViewModel;
import com.zm.testapp.di.module.UseCaseModule;
import com.zm.testapp.di.qualifier.ViewModelKey;
import com.zm.testapp.presentation.ui.users.UsersViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(includes = {
        UseCaseModule.class,
})
public abstract class UsersModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = UsersViewModel.class)
    abstract ViewModel bindViewModel(UsersViewModel viewModel);
}
