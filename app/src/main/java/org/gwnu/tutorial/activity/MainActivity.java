package org.gwnu.tutorial.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.databinding.ActivityMainBinding;
import org.gwnu.tutorial.fragment.DefaultFragment;
import org.gwnu.tutorial.fragment.Fragment1;
import org.gwnu.tutorial.fragment.Fragment2;

public class MainActivity extends DefaultActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding binding;
    Fragment1.OnLoadingListener onLoadingListener;
    Fragment1 fragment1;
    Fragment2 fragment2;

    /**********************************************************************************************/

    public MainActivity() {
    }

    /**********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.setMain(this);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag_container, fragment2);
        fragmentTransaction.commit();


    }

    /**********************************************************************************************/

    @Override
    protected void onResume() {
        super.onResume();
        fragment2.setOnImageClickListener(new Fragment2.OnImageClickListener() {
            @Override
            public void onImageClick(ImageView imageView, TextView textView) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_foreground));
                textView.setText("Hello World");
//                Toast.makeText(MainActivity.this, "Hello world", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**********************************************************************************************/

}