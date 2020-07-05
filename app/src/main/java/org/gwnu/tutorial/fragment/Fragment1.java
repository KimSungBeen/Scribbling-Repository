package org.gwnu.tutorial.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.activity.MainActivity;

public class Fragment1 extends DefaultFragment {
    static OnLoadingListener mOnLoadingListener;
    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    FrameLayout frameLayout;
    ImageView imageView;

    /**********************************************************************************************/

    public Fragment1() {
        MainActivity mainActivity = (MainActivity) getActivity();

//        mainActivity.setOnLoadingListener(mOnLoadingListener);
    }

    /**********************************************************************************************/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageView = new ImageView(getActivity());
        frameLayout = getActivity().findViewById(R.id.frag_container);

        mOnLoadingListener = new OnLoadingListener() {
            @Override
            public void loadDate(boolean loading) {
                if(loading){ //true
                    imageView.setImageDrawable(getActivity().getResources().getDrawable(R.mipmap.ic_launcher));
                    imageView.setLayoutParams(layoutParams);
                    frameLayout.addView(imageView);
                }else{ //false
//                    Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();
                    frameLayout.removeView(imageView);

                }
            }
        };
    }

    /**********************************************************************************************/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_1, container, false);

        return view;
    }

    /**********************************************************************************************/
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvFrag1 = view.findViewById(R.id.tv_frag1);
        tvFrag1.setText("Test....!!");
        tvFrag1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        tvFrag1.setTextColor(Color.parseColor("#FF0000")); //Color is RED
        tvFrag1.setGravity(Gravity.CENTER);
    }

    /**********************************************************************************************/

    @Override
    public void onResume() {
        super.onResume();
//        Toast.makeText(getContext(), ""+getActivity(), Toast.LENGTH_SHORT).show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mOnLoadingListener != null) {
                    mOnLoadingListener.loadDate(true);
                }
            }
        }, 2000);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mOnLoadingListener != null) {
                    mOnLoadingListener.loadDate(false);
                }
            }
        }, 4000);
    }

    /**********************************************************************************************/

    public interface OnLoadingListener {
        void loadDate(boolean loading);
    }

    /**********************************************************************************************/



    /**********************************************************************************************/

}
