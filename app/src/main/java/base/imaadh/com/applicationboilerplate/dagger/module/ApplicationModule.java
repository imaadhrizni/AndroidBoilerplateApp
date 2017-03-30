package base.imaadh.com.applicationboilerplate.dagger.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Imaad on 2/7/2017.
 */

@Module
public class ApplicationModule {

    private static Application sApplication;

    public ApplicationModule(Application application) {
        sApplication = application;
    }

    @Singleton
    @Provides
    Application providesApplication() {
        return sApplication;
    }

    @Provides
    @Singleton
    public Context providesApplicationContext() {
        return sApplication.getApplicationContext();
    }
}