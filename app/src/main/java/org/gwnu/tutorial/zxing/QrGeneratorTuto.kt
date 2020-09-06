package org.gwnu.tutorial.zxing

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_qr_generator_tuto.*
import org.gwnu.tutorial.R

class QrGeneratorTuto : AppCompatActivity() {
    val qrViewModel: QRViewModel by viewModels()

    val btnText = "QR 생성"
    val mActivity: Activity = this

    lateinit var qrImg: ImageView
    var editText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_generator_tuto)

        qrImg = qr_img
//        loadQRCode("gdf")
    }

//    fun loadQRCode(qrData: String) {
//        Glide.with(this)
//                .load("http://chart.apis.google.com/chart?cht=qr&chs=350x350&chl=$qrData")
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .into(qrImg)
//    }

}