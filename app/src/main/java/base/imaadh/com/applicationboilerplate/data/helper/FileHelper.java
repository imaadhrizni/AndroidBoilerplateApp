package base.imaadh.com.applicationboilerplate.data.helper;

import android.content.Context;

import javax.inject.Inject;

import base.imaadh.com.applicationboilerplate.App;
import base.imaadh.com.applicationboilerplate.dagger.component.DaggerActivityInjectorComponent;

/**
 * Created by Imaad on 3/30/2017.
 */

public class FileHelper {

    @Inject
    Context mContext;

    public FileHelper() {
        DaggerActivityInjectorComponent.builder()
                .baseComponent(App.getBaseComponent())
                .build()
                .inject(this);
    }
}
