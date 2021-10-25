package com.zm.data.remote;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import com.zm.data.util.NoNetworkException;
import java.io.IOException;
import javax.inject.Inject;
import okhttp3.Interceptor;
import okhttp3.Response;

public class ConnectivityInterceptor implements Interceptor {

    private final Context context;

    @Inject
    public ConnectivityInterceptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if (!isOnline()) {
            throw new NoNetworkException();
        }
        return chain.proceed(chain.request());
    }

    private boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetwork() != null;
    }
}
