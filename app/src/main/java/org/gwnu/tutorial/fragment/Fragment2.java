package org.gwnu.tutorial.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.databinding.Fragmnet2Binding;

public class Fragment2 extends DefaultFragment {
    private static final String TAG = Fragment2.class.getSimpleName();
    Fragmnet2Binding fragmnet2Binding;

    OnImageClickListener mOnImageClickListener;
    CardView mCardView;
    ImageView mImageView;
    TextView mTextView;

    /**********************************************************************************************/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmnet2Binding = DataBindingUtil.inflate(inflater, R.layout.fragmnet_2, container, false);
        fragmnet2Binding.setFrag2(this);
        return fragmnet2Binding.getRoot();
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
