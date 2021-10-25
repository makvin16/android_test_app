package com.zm.testapp.di.module;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zm.data.BuildConfig;
import com.zm.data.remote.ApiService;
import com.zm.data.remote.ConnectivityInterceptor;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class NetworkModule {

    private static final String TAG = "LogServer";
    private static final int NETWORK_TIME_OUT = 15;

    @Singleton
    @Provides
    public HttpLoggingInterceptor.Logger provideLogger() {
        return message -> {
            Timber.tag(TAG).i(message);
        };
    }

    @Singleton
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger logger
    ) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(logger);
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;
        if (BuildConfig.DEBUG) {
            level = HttpLoggingInterceptor.Level.BASIC;
        }
        httpLoggingInterceptor.setLevel(level);
        return httpLoggingInterceptor;
    }

    @Singleton
    @Provides
    public ConnectivityInterceptor provideConnectivityInterceptor(
            Context context
    ) {
        return new ConnectivityInterceptor(context);
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(
            HttpLoggingInterceptor httpLoggingInterceptor,
            ConnectivityInterceptor connectivityInterceptor
    ) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(connectivityInterceptor)
                .connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public Gson provideGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Singleton
    @Provides
    public ApiService provideApiService(
            OkHttpClient okHttpClient,
            Gson gson
    ) {
        return new Retrofit.Builder()
                .baseUrl(com.zm.testapp.BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }
}
