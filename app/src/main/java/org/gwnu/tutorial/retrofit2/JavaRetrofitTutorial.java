package org.gwnu.tutorial.retrofit2;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.activity.DefaultActivity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JavaRetrofitTutorial extends DefaultActivity {
    private static final String TAG = "JavaRetrofitTutorial";
    private RecyclerView recyclerView;
    private List<RModel> rModelList;
    private RAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_retrofit_tutorial);

        /*<초기화>*/
        initView();
        initVariable();

        /*<리싸이클러뷰 셋팅>*/
        setRecyclerView();

        /*<레트로핏 셋팅>*/
        Retrofit retrofitModule = RetrofitClient.INSTANCE.getClient(RApi.BASE_URL);
        RApi rApi = retrofitModule != null ? retrofitModule.create(RApi.class) : null;

        /*<레트로핏 파싱>*/
        if (rApi != null) {
            rApi.postDetails("ID_APP", "10", "NO_MAC1", "P021000468", "00001337")
                    .enqueue(new Callback<RModel>() {
                        @Override
                        public void onResponse(Call<RModel> call, Response<RModel> response) {
                            try {
                                Log.d(TAG, "Call: \n" + call);
                                Log.d(TAG, "Response: \n" + response);

                                RModel result = response.body();

                                Log.d(TAG, "result: \n" + (result != null ? result.toString() : null));
                                rModelList.add(result);
                                rAdapter.notifyDataSetChanged();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<RModel> call, Throwable t) {
                            //통신 실패
                            Log.d(TAG, "Throwable: \n" + t);
                        }
                    });
        } else {
            Log.d(TAG, "rApi is Null");
        }
    }

    /**
     * 변수 초기화
     */
    private void initVariable() {

    }

    /**
     * 뷰 초기화
     */
    private void initView() {
        recyclerView = findViewById(R.id.retrofit_and_recyclerview);
    }

    /**
     * 리싸이클러뷰 셋팅
     */
    private void setRecyclerView() {
        rModelList = new ArrayList<>();
        rAdapter = new RAdapter(rModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(rAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void addRecyclerViewItem() {
    }
}