package org.gwnu.tutorial.DotViewPager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.gwnu.tutorial.R;

import java.util.List;

public class DotPagerAdapter extends PagerAdapter {
    Context context;
    List<Drawable> obj;

    DotPagerAdapter(List<Drawable> res, Context context){
        obj = res;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.fragment_pager_frag1,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        imageView.setImageDrawable(obj.get(position));
        container.addView(view);

        return view;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    }

    public int getCount() {
        return obj.size();
    }
}
