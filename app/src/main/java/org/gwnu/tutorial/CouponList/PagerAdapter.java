package org.gwnu.tutorial.CouponList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = PagerAdapter.class.getSimpleName();
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<>();

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        items.add(new PagerFrag1());
        items.add(new PagerFrag2());
        items.add(new PagerFrag1());

        itext.add("보유 쿠폰");
        itext.add("만료 쿠폰");
        itext.add("만료 쿠폰");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }
}
