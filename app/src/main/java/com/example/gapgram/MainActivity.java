package com.example.gapgram;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.gapgram.adapter.PostAdapter;
import com.example.gapgram.databinding.ActivityMainBinding;
import com.example.gapgram.model.IListResponse;
import com.example.gapgram.model.Post;
import com.example.gapgram.serviceCaller.WebserviceCaller;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private PostAdapter postAdapter;
    private WebserviceCaller webserviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // تنظیم LayoutManager برای RecyclerView
        binding.recyclerPosts.setLayoutManager(new LinearLayoutManager(this));
        System.out.println("RecyclerView LayoutManager set.");

        // ایجاد یک لیست خالی یا داده‌های پیش‌فرض
        List<Post> posts = new ArrayList<>();
        // ایجاد آداپتر و اتصال آن به RecyclerView
        postAdapter = new PostAdapter(this, posts);  // اینجا آرگومان‌ها را به سازنده می‌دهیم
        binding.recyclerPosts.setAdapter(postAdapter);

        // ایجاد WebserviceCaller
        webserviceCaller = new WebserviceCaller();

        // بارگذاری پست‌ها از وب‌سرویس
        try {
            loadPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected ActivityMainBinding inflateBindingLayout() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    private void loadPosts() throws Exception {
        System.out.println("loadPosts " );
        webserviceCaller.getPosts(new IListResponse<Post>() {
            @Override
            public void onSuccess(List<Post> responseBody) {
                if (responseBody != null && !responseBody.isEmpty()) {
                    // لاگ کردن تعداد پست‌ها برای بررسی
                    System.out.println("Number of posts received: " + responseBody.size());

                    for (Post post : responseBody) {
                        // لاگ کردن جزئیات هر پست
                        System.out.println("Post Message: " + post.getMessage());
                        System.out.println("Post Likes: " + post.getLikes_count());
                        System.out.println("Post Comments: " + post.getComments_count());
                        System.out.println("Post Shares: " + post.getShares_count());
                        System.out.println("Post Image URL: " + post.getImage());
                    }

                    // به‌روزرسانی آداپتر
                    postAdapter.updatePosts(responseBody);
                } else {
                    Toast.makeText(MainActivity.this, "No posts available", Toast.LENGTH_SHORT).show();
                    System.out.println("No posts available");
                }
            }

            @Override
            public void onFail() {
                Toast.makeText(MainActivity.this, "Failed to load posts", Toast.LENGTH_SHORT).show();
                System.out.println("Failed to load posts");
            }
        });
    }
}