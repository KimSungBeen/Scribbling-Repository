package org.gwnu.tutorial.DotViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.activity.DefaultActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerTuto extends DefaultActivity {
    List<Drawable> temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_tuto);

        temp = new ArrayList<>();
        temp.add(ContextCompat.getDrawable(this, R.drawable.app_icon));
        temp.add(ContextCompat.getDrawable(this, R.drawable.app_icon));
        temp.add(ContextCompat.getDrawable(this, R.drawable.app_icon));

        DotPagerAdapter a = new DotPagerAdapter(temp, this);

        ViewPager pager = (ViewPager) findViewById(R.id.dot_view_pager);
        pager.setAdapter(a);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.dot_tab_layout);
        tabLayout.setupWithViewPager(pager, true);
    }
}