package base.imaadh.com.applicationboilerplate.dagger.component;

import android.content.Context;

import base.imaadh.com.applicationboilerplate.dagger.module.NetModule;
import base.imaadh.com.applicationboilerplate.dagger.scopes.ApplicationScope;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Imaad on 2/8/2017.
 */

@ApplicationScope
@Component(modules = {NetModule.class}, dependencies = ApplicationComponent.class)
public interface BaseComponent {
    Retrofit getRetrofit();

    Context getContext();
}