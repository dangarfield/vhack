package com.fyber.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.UUID;

/* compiled from: UserId */
public final class ag {
    public static synchronized String m5248a(Context context) {
        String string;
        synchronized (ag.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FyberPreferences", 0);
            string = sharedPreferences.getString("STATE_GENERATED_USERID_KEY", null);
            if (string == null) {
                String uuid = UUID.randomUUID().toString();
                string = ac.m5231a(uuid);
                if (string == null || string.equals("nosha1")) {
                    string = uuid;
                }
                Editor edit = sharedPreferences.edit();
                edit.putString("STATE_GENERATED_USERID_KEY", string);
                edit.commit();
            }
        }
        return string;
    }
}
