package base.imaadh.com.applicationboilerplate;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import base.imaadh.com.applicationboilerplate.dagger.component.ApplicationComponent;
import base.imaadh.com.applicationboilerplate.dagger.component.BaseComponent;
import base.imaadh.com.applicationboilerplate.dagger.component.DaggerApplicationComponent;
import base.imaadh.com.applicationboilerplate.dagger.component.DaggerBaseComponent;
import base.imaadh.com.applicationboilerplate.dagger.module.ApplicationModule;
import base.imaadh.com.applicationboilerplate.dagger.module.NetModule;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import timber.log.Timber;

/**
 * Created by Imaad on 2/7/2017.
 */


public class App extends Application {

    private static ApplicationComponent sAppComponent;
    private static BaseComponent sBaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //CustomActivityOnCrash
        initCustomActivityOnCrash();

        //Leak Canary
        initLeakCanary();

        //Timber Init
        initTimber();

        //initialize evernote job creator
        initJobCreator();

        //Initialize Dagger Dependencies
        sAppComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        sBaseComponent = DaggerBaseComponent.builder()
                .applicationComponent(sAppComponent)
                .netModule(new NetModule("urlgoeshere"))
                .build();
    }

    public static BaseComponent getBaseComponent() {
        return sBaseComponent;
    }

    public static ApplicationComponent getApplicationComponent() {
        return sAppComponent;
    }

    private void initCustomActivityOnCrash() {
        //Install CustomActivityOnCrash
        CustomActivityOnCrash.setLaunchErrorActivityWhenInBackground(true);
        CustomActivityOnCrash.setShowErrorDetails(true);
//        CustomActivityOnCrash.setRestartActivityClass(SplashActivity.class);
        CustomActivityOnCrash.install(this);
    }


    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }


    private void initJobCreator() {
//        JobManager.create(this).addJobCreator(new AppJobCreator());
    }
}