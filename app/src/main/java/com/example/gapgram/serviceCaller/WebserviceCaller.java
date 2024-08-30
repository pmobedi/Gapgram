package com.example.gapgram.serviceCaller;

import android.util.Log;

import com.example.gapgram.PostCount;
import com.example.gapgram.model.IListResponse;
import com.example.gapgram.model.IResponse;
import com.example.gapgram.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {
    private ApiInterface apiInterface;
    private static final String TAG = "WebserviceCaller";

    public WebserviceCaller() {
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Log.d(TAG, "WebserviceCaller initialized with ApiInterface");
    }

    public void getPostCount(final IResponse iResponse) {
        Log.d(TAG, "Requesting post count...");
        Call<PostCount> call = apiInterface.getPostCount();
        call.enqueue(new Callback<PostCount>() {
            @Override
            public void onResponse(Call<PostCount> call, Response<PostCount> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PostCount postCount = response.body();
                    int count = postCount.getCount();
                    Log.d(TAG, "Post count received: " + count);
                    // ارسال count به iResponse یا استفاده از آن در برنامه
                } else {
                    Log.e(TAG, "Error response received: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PostCount> call, Throwable t) {
                Log.e(TAG, "Failed to get post count: " + t.getMessage());
            }
        });
    }

    public void getPosts(final IListResponse<Post> iResponse) {
        Log.d(TAG, "Requesting posts...");
        Call<List<Post>> call = apiInterface.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Posts received: " + response.body().size() + " posts");
                    iResponse.onSuccess(response.body());
                } else {
                    System.out.println("Error response received: " + response.message());
                    iResponse.onFail();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                System.out.println("Failed to get posts: " + t.getMessage());
                iResponse.onFail();
            }
        });
    }
}