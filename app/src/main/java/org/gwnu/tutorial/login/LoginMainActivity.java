package org.gwnu.tutorial.login;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.application.MyApplication;

public class LoginMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        //해쉬키 출력
        MyApplication myApplication = (MyApplication) getApplication();
        myApplication.getAppKeyHash();


    }

}
