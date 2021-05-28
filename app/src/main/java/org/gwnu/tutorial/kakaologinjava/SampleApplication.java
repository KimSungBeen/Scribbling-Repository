package org.gwnu.tutorial.kakaologinjava;

import android.app.Application;
import android.util.Log;

import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.Utility;

public class SampleApplication extends Application {
    private static final String TAG = "SampleApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, "6c88665a9783487414061ef89e57bd22");

        Log.d(TAG, "key Hash: " + Utility.INSTANCE.getKeyHash(this));
    }
}
