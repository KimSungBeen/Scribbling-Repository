package org.gwnu.tutorial.CouponList;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.activity.DefaultActivity;

import java.util.ArrayList;
import java.util.Observable;

public class CouponListActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_list);

        ViewPager vp = findViewById(R.id.viewpager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        //연동
        TabLayout tab = findViewById(R.id.coupon_tab_layout);
        tab.setupWithViewPager(vp);

        ArrayList<Integer> image = new ArrayList<>();
        image.add(R.drawable.naver_icon); //test icon
        image.add(R.drawable.kakaotalk_icon); //test icon
        image.add(R.drawable.kakao_login_symbol); //test icon

        for (int i = 0; i < image.size(); i++) {
            tab.getTabAt(i).setIcon(image.get(i));
        }


    }

}