package base.imaadh.com.applicationboilerplate.data;

import base.imaadh.com.applicationboilerplate.dagger.util.Annotations;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Imaad on 3/30/2017.
 */

public interface APIService {

    @GET("/posts")
    @Annotations.Json
    Observable<String> getUserList();

}
