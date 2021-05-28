package org.gwnu.tutorial.kakaologinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.databinding.ActivityKakaoLoginJavaBinding;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class kakaoLoginJavaActivity extends AppCompatActivity {
    private static final String TAG = "kakaoLoginJavaActivity";

    private ActivityKakaoLoginJavaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKakaoLoginJavaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setClickEvent();
    }

    /**
     * 클릭 이벤트
     */
    private void setClickEvent() {
        binding.btnLogin.setOnClickListener(v -> kakaoLoginJava());

        binding.btnLogout.setOnClickListener(v -> logout());

        binding.btnRequestUserData.setOnClickListener(v -> getUserData());
    }

    /**
     * 카카오톡으로 로그인 API 자바 코드
     */
    private void kakaoLoginJava() {
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)) {
            UserApiClient.getInstance().loginWithKakaoTalk(this, (oAuthToken, throwable) -> {
                loginCallback(oAuthToken, throwable);

                return null;
            });
        } else {
            UserApiClient.getInstance().loginWithKakaoAccount(this, (oAuthToken, throwable) -> {
                loginCallback(oAuthToken, throwable);

                return null;
            });
        }
    }

    /**
     * 카카오톡으로 로그인 API 콜백
     */
    private void loginCallback(OAuthToken token, Throwable error) {
        if (error != null) {
            Log.e(TAG, "로그인 실패", error);
        } else if (token != null) {
            Log.i(TAG, "로그인 성공 ${token.accessToken}");
        }
    }

    /**
     * 카카오톡으로 로그인의 로그아웃 API
     */
    private void logout() {
        UserApiClient.getInstance().logout(error -> {
            if (error != null) {
                Log.e(TAG, "로그아웃 실패. SDK에서 토큰 삭제됨", error);
            } else {
                Log.i(TAG, "로그아웃 성공. SDK에서 토큰 삭제됨");
            }

            return null;
        });
    }

    /**
     * 사용자 정보 요청 (기본)
     */
    private void getUserData() {
        UserApiClient.getInstance().me((user, error) -> {
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error);
            } else if (user != null) {
                Log.i(TAG, "사용자 정보 요청 성공" +
                        "\n회원번호: " + user.getId() +
                        "\n이메일: " + user.getKakaoAccount().getEmail() +
                        "\n닉네임: " + user.getKakaoAccount().getProfile().getNickname() +
                        "\n프로필사진: " + user.getKakaoAccount().getProfile().getProfileImageUrl());
            }

            return null;
        });
    }

}