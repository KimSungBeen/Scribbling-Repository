package org.gwnu.tutorial.zxing

import android.app.Activity
import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import com.bumptech.glide.Glide
import org.gwnu.tutorial.R

class QRViewModel(application: Application) : AndroidViewModel(application) {

    // Glide 를 통한 QR 이미지 로드
    fun loadQRCode(activity: Activity, qrData: String, qrImg: ImageView) {

        Log.d(TAG, "loadQRCode: ")
        
        Glide.with(activity)
                .load("http://chart.apis.google.com/chart?cht=qr&chs=350x350&chl=$qrData")
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(qrImg)
    }

}