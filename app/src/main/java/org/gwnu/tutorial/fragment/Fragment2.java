package org.gwnu.tutorial.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import org.gwnu.tutorial.R;

public class Fragment2 extends DefaultFragment {
    private static final String TAG = Fragment2.class.getSimpleName();
    OnImageClickListener mOnImageClickListener;
    CardView mCardView;
    ImageView mImageView;
    TextView mTextView;

    /**********************************************************************************************/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_2, container, false);
        mCardView = view.findViewById(R.id.cv_frag2);
        mImageView = view.findViewById(R.id.iv_frag2);
        mTextView = view.findViewById(R.id.tv_frag2);
        return view;
    }

    /**********************************************************************************************/

    public interface OnImageClickListener {
        void onImageClick(ImageView imageView, TextView textView);
    }

    /**********************************************************************************************/

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.mOnImageClickListener = onImageClickListener;
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnImageClickListener != null) {
                    mOnImageClickListener.onImageClick(mImageView, mTextView);
                }
            }
        });
    }

    /**********************************************************************************************/

}
