package com.example.gapgram;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gapgram.databinding.ActivityMainBinding;



public class MainActivity extends BaseActivity<ActivityMainBinding> {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Use the binding object to access views
           // binding.textView.setText("Hello, View Binding!");
            // تنظیم LayoutManager برای RecyclerView
            // تنظیم LayoutManager برای RecyclerView
            binding.recyclerPosts.setLayoutManager(new LinearLayoutManager(this));
        }

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
        protected ActivityMainBinding inflateBindingLayout() {
            // Inflate the layout using View Binding
            return ActivityMainBinding.inflate(getLayoutInflater());
        }
    }
