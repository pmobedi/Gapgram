package com.example.gapgram.ui;

import android.os.Bundle;
import android.util.Log;
import com.example.gapgram.R;
import com.example.gapgram.BaseActivity;
import com.example.gapgram.databinding.ActivityProfileFormBinding;
import com.example.gapgram.realm.DatabaseChecker;
import com.example.gapgram.realm.UserProfile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.realm.Realm;

public class ProfileForm extends BaseActivity<ActivityProfileFormBinding> {

    private static final String TAG = "ProfileForm";
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // بررسی موجودیت دیتابیس
        DatabaseChecker.checkDatabaseExists(this);

        // تنظیم رویداد بستن فرم
        binding.btnClose.setOnClickListener(view -> finish());

        // تنظیم رویداد کلیک برای دکمه تیک
        binding.iconOption.setOnClickListener(view -> {
            // شروع عملیات درج و به‌روزرسانی داده‌ها
            insertAndUpdateData();
        });
    }

    @Override
    public int setContentView() {
        // بازگرداندن لایه مربوط به این Activity
        return R.layout.activity_profile_form;
    }

    @Override
    protected ActivityProfileFormBinding inflateBindingLayout() {
        // Bind کردن Layout با View Binding
        return ActivityProfileFormBinding.inflate(getLayoutInflater());
    }

    private void insertAndUpdateData() {
        executorService.execute(() -> {
            Log.d(TAG, "Opening Realm database...");
            Realm realm = Realm.getDefaultInstance();
            try {
                realm.executeTransaction(r -> {
                    UserProfile personalDetail = new UserProfile();
                    personalDetail.setId(2L);
                    personalDetail.setName(binding.edtName.getText().toString());
                    personalDetail.setUserName(binding.edtUserName.getText().toString());
                    personalDetail.setEmail(binding.edtEmail.getText().toString());
                    personalDetail.setWebsite(binding.edtWebsite.getText().toString());
                    personalDetail.setBio(binding.edtBio.getText().toString());
                    personalDetail.setPhoneNumber(binding.edtPhoneNumber.getText().toString());
                    personalDetail.setGender(gender);  // Assuming you have a method to get selected gender

                    // درج یا به‌روزرسانی داده‌ها
                    r.insertOrUpdate(personalDetail);
                    Log.d(TAG, "Data inserted/updated successfully.");
                });
            } catch (Exception e) {
                Log.e(TAG, "Error during Realm transaction", e);
            } finally {
                realm.close();
                Log.d(TAG, "Realm database closed.");
            }
        });
    }
}
