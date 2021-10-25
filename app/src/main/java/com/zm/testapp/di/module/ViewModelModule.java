package com.zm.testapp.di.module;

import androidx.lifecycle.ViewModelProvider;
import com.zm.testapp.di.ViewModelFactory;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(
            ViewModelFactory factory
    );
}
