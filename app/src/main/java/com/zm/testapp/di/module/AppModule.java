package com.zm.testapp.di.module;

import com.zm.testapp.di.module.users.UsersModule;
import com.zm.testapp.presentation.AppActivity;
import com.zm.testapp.presentation.ui.details.UserDetailsFragment;
import com.zm.testapp.presentation.ui.users.UsersFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {

    @ContributesAndroidInjector
    public abstract AppActivity contributeAppActivity();

    @ContributesAndroidInjector(
        modules = {
            ViewModelModule.class,
            UsersModule.class
        }
    )
    public abstract UsersFragment contributeUsersFragment();

    @ContributesAndroidInjector
    public abstract UserDetailsFragment contributeUserDetailsFragment();
}
