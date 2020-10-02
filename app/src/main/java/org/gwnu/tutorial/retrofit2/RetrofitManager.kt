package org.gwnu.tutorial.retrofit2

import android.util.Log
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RetrofitManager {
    private val TAG = RetrofitManager::class.java.simpleName

    companion object {
        val instance = RetrofitManager()
    }

    //레트로핏 인터페이스 가져오기
    private val iRetrofit: IRetrofit? = RetrofitClient.getClient("https://api.unsplash.com/")?.create(IRetrofit::class.java)

    //사진 검색 api 호출
    fun searchPhotos(searchTerm: String?, completion: (String) -> Unit) {

        val term = searchTerm ?: ""

        val call = iRetrofit?.searchPhotos(searchTerm = term) ?: return

        call.enqueue(object : Callback<JsonElement> {

            //응답이 성공했을 때
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "onResponse: ${response.raw()}")
            }

            //응답이 실패했을 때
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }

        })
    }
}