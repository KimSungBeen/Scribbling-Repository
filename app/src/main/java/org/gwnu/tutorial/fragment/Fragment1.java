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
import androidx.databinding.DataBindingUtil;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.activity.MainActivity;
import org.gwnu.tutorial.databinding.Fragmnet1Binding;

public class Fragment1 extends DefaultFragment {
    private static final String TAG = Fragment1.class.getSimpleName();
    Fragmnet1Binding fragmnet1Binding;

    OnLoadingListener mOnLoadingListener;
    ViewGroup.LayoutParams mLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    FrameLayout mFrameLayout;
    ImageView mImageView;

    /**********************************************************************************************/

    public Fragment1() {
    }

    /**********************************************************************************************/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageView = new ImageView(getActivity());
        mFrameLayout = getActivity().findViewById(R.id.frag_container);

        mOnLoadingListener = new OnLoadingListener() {
            @Override
            public void loadDate(boolean loading) {
                if(loading){ //true
                    mImageView.setImageDrawable(getActivity().getResources().getDrawable(R.mipmap.ic_launcher));
                    mImageView.setLayoutParams(mLayoutParams);
                    mFrameLayout.addView(mImageView);
                }else{ //false
//                    Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();
                    mFrameLayout.removeView(mImageView);

                }
            }
        };
    }

    /**********************************************************************************************/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmnet1Binding = DataBindingUtil.inflate(inflater, R.layout.fragmnet_1, container, false);
        fragmnet1Binding.setFrag1(this);
        return fragmnet1Binding.getRoot();
    }

    /**********************************************************************************************/
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmnet1Binding.tvFrag1.setText("Test....!!");
        fragmnet1Binding.tvFrag1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        fragmnet1Binding.tvFrag1.setTextColor(Color.parseColor("#FF0000")); //Color is RED
        fragmnet1Binding.tvFrag1.setGravity(Gravity.CENTER);
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

}
