package org.gwnu.tutorial.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.fragment.Fragment1;

public class MainActivity extends DefaultActivity {
    Fragment1.OnLoadingListener onLoadingListener;

    /**********************************************************************************************/

    public MainActivity() {
    }

    /**********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new Fragment1();
        Fragment1 fragment1 = (Fragment1)fragment;
//        fragment1.setOnLoadingListener(onLoadingListener);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag_container, fragment1);
        fragmentTransaction.commit();


    }

    /**********************************************************************************************/

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**********************************************************************************************/

    public void setOnLoadingListener(Fragment1.OnLoadingListener onLoadingListener) {
        this.onLoadingListener = onLoadingListener;
    }

    /**********************************************************************************************/

}