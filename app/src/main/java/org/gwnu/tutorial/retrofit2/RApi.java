package org.gwnu.tutorial.retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RApi {
    String BASE_URL = "http://testsapi.cinehotel.co.kr/playintvApi/";

    @GET("contents/getContentsInfo.do")
    Call<RModel> getDetails(@Query("ID_APP") String ID_APP,
                            @Query("ID_OTT") String ID_OTT,
                            @Query("MAC") String MAC,
                            @Query("ID_PROD") String ID_PROD,
                            @Query("ID_CONTENTS") String ID_CONTENTS);

    @FormUrlEncoded
    @POST("contents/getContentsInfo.do")
    Call<RModel> postDetails(@Field("ID_APP") String ID_APP,
                             @Field("ID_OTT") String ID_OTT,
                             @Field("MAC") String MAC,
                             @Field("ID_PROD") String ID_PROD,
                             @Field("ID_CONTENTS") String ID_CONTENTS);
}