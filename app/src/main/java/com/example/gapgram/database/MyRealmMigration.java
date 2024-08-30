package com.example.gapgram.database;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class MyRealmMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        if (oldVersion == 1) {
            schema.get("UserProfile")
                    .removeField("_id") // حذف فیلد قدیمی
                    .removeField("firstname")
                    .removeField("lastname")
                    .addField("id", long.class) // اضافه کردن فیلد جدید به عنوان کلید اصلی
                    .addField("name", String.class)
                    .addField("userName", String.class)
                    .addField("website", String.class)
                    .addField("bio", String.class)
                    .addField("phoneNumber", String.class)
                    .addField("gender", String.class);

            oldVersion++;
        }

        // در صورت نیاز، مراحل مهاجرت بعدی را اینجا اضافه کنید
    }
}
