package base.imaadh.com.applicationboilerplate.view.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import base.imaadh.com.applicationboilerplate.R;
import base.imaadh.com.applicationboilerplate.data.APIService;
import retrofit2.Retrofit;
import rx.Observer;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testApiService();
    }

    private void testApiService() {
        mRetrofit.create(APIService.class)
                .getUserList()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        //do this
                    }

                    @Override
                    public void onError(Throwable e) {
                        //log error
                    }

                    @Override
                    public void onNext(String s) {
                        //store or do whatever you like with the response
                    }
                });
    }
}
