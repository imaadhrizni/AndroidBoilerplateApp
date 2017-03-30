package base.imaadh.com.applicationboilerplate.view.splashactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import base.imaadh.com.applicationboilerplate.R;
import base.imaadh.com.applicationboilerplate.view.mainactivity.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
