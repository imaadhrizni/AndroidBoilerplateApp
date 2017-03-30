package base.imaadh.com.applicationboilerplate.dagger.component;

import base.imaadh.com.applicationboilerplate.dagger.scopes.ActivityScope;
import base.imaadh.com.applicationboilerplate.data.helper.FileHelper;
import base.imaadh.com.applicationboilerplate.data.util.NetworkUtil;
import dagger.Component;

/**
 * Created by Imaad on 2/8/2017.
 */

@ActivityScope
@Component(dependencies = {BaseComponent.class})
public interface ActivityInjectorComponent {
    void inject(FileHelper fileHelper);

    void inject(NetworkUtil networkUtil);
}
