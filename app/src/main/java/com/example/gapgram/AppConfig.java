package com.example.gapgram;

import android.app.Application;


import com.example.gapgram.database.MyRealmMigration;

import dagger.hilt.android.HiltAndroidApp;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@HiltAndroidApp
public class AppConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initiateRealm();
    }

    private void initiateRealm() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("Myrealm.realm")
                .allowWritesOnUiThread(true) // برای سادگی در تست، روی true تنظیم شده است
                .allowQueriesOnUiThread(true) // برای سادگی در تست، روی true تنظیم شده است
                .schemaVersion(2) // اطمینان حاصل کنید که نسخه اسکیمای درست را مشخص کرده‌اید
                .migration(new MyRealmMigration()) // از MyRealmMigration استفاده کنید
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
