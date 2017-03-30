package base.imaadh.com.applicationboilerplate.data.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

import base.imaadh.com.applicationboilerplate.App;
import base.imaadh.com.applicationboilerplate.dagger.component.DaggerActivityInjectorComponent;
import retrofit2.adapter.rxjava.HttpException;

public class NetworkUtil {

    @Inject
    Context mContext;

    public NetworkUtil() {
        DaggerActivityInjectorComponent.builder()
                .baseComponent(App.getBaseComponent())
                .build()
                .inject(this);
    }

    /**
     * Returns true if the Throwable is an instance of RetrofitError with an
     * http status code equals to the given one.
     */
    public static boolean isHttpStatusCode(Throwable throwable, int statusCode) {
        return throwable instanceof HttpException
                && ((HttpException) throwable).code() == statusCode;
    }


    public boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

}