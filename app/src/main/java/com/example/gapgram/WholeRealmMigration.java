package com.example.gapgram;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class WholeRealmMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        // انجام تغییرات لازم در نسخه‌های مختلف
        if (oldVersion == 1) {
            // مثال: افزودن یک فیلد جدید به کلاس PersonDetailEntity
            schema.get("PersonDetailEntity")
                    .addField("newField", String.class);

            oldVersion++;
        }

        // ادامه برای نسخه‌های بعدی...
    }
}
