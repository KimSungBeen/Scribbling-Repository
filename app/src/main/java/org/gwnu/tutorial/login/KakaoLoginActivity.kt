package org.gwnu.tutorial.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import com.kakao.sdk.auth.LoginClient
import org.gwnu.tutorial.R
import org.gwnu.tutorial.activity.DefaultActivity

public class KakaoLoginActivity : DefaultActivity() {
    var context: Context = this

    companion object {
        private const val TAG = "KakaoLoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kakao_login)

        val loginButton: ImageButton = findViewById(R.id.kakao_login_button)

//        if (LoginClient.instance.isKakaoTalkLoginAvailable(context)) {
//            // 카카오톡 설치 O
//        } else {
//            // 카카오톡 설치 X
//        }

        loginButton.setOnClickListener( {
            LoginClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    Log.e(TAG, "로그인 실패", error)
                } else if (token != null) {
                    Log.i(TAG, "로그인 성공 ${token.accessToken}")
                }
            }
        })

//        loginButton.setOnClickListener {
//            // 카카오톡으로 로그인
//            LoginClient.instance.loginWithKakaoTalk(context) { token, error ->
//                if (error != null) {
//                    Log.e(TAG, "로그인 실패", error)
//                } else if (token != null) {
//                    Log.i(TAG, "로그인 성공 ${token.accessToken}")
//                }
//            }
//        }


    }

    override fun onStart() {
        super.onStart()
    }

}