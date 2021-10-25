package com.zm.testapp.di;

import android.content.Context;
import com.zm.testapp.App;
import com.zm.testapp.di.module.AppModule;
import com.zm.testapp.di.module.NetworkModule;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
    modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        NetworkModule.class
    }
)
public interface AppComponent extends AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Context applicationContext);
    }
}
