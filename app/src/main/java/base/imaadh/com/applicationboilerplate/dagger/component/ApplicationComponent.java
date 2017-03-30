package base.imaadh.com.applicationboilerplate.dagger.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import base.imaadh.com.applicationboilerplate.dagger.module.ApplicationModule;
import dagger.Component;

/**
 * Created by Imaad on 2/7/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Application getApplication();

    Context getContext();
}