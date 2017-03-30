package base.imaadh.com.applicationboilerplate.dagger.util;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Imaad on 3/15/2017.
 */

public class Annotations {

    @Retention(RUNTIME)
    public @interface Json {
    }

    @Retention(RUNTIME)
    public @interface Xml {
    }
}
