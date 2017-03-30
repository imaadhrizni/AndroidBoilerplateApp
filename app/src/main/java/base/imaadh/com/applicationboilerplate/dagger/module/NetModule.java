package base.imaadh.com.applicationboilerplate.dagger.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import base.imaadh.com.applicationboilerplate.dagger.scopes.ApplicationScope;
import base.imaadh.com.applicationboilerplate.dagger.util.JsonAndXmlConverters;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Imaad on 2/7/2017.
 */

@Module
public class NetModule {
    String mBaseUrl;

    public NetModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @ApplicationScope
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @ApplicationScope
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @ApplicationScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @ApplicationScope
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        SimpleXmlConverterFactory simpleXmlConverterFactory = SimpleXmlConverterFactory.create(serializer);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(new JsonAndXmlConverters.QualifiedTypeConverterFactory(gsonConverterFactory, simpleXmlConverterFactory))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
