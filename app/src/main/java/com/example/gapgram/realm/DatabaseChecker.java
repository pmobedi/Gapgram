package com.example.gapgram.realm;


import android.content.Context;
import android.util.Log;

import java.io.File;

public class DatabaseChecker {

    private static final String TAG = "DatabaseChecker";

    public static void checkDatabaseExists(Context context) {
        // مسیر فایل دیتابیس را مشخص کنید
        File databaseFile = new File(context.getFilesDir(), "Myrealm.realm");
        if (databaseFile.exists()) {
            Log.d(TAG, "Realm database exists at: " + databaseFile.getAbsolutePath());
        } else {
            Log.d(TAG, "Realm database does not exist.");
        }
    }
}

