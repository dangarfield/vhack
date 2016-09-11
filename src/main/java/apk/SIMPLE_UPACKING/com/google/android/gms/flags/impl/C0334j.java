package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.p051b.ky;

/* renamed from: com.google.android.gms.flags.impl.j */
public class C0334j {
    private static SharedPreferences f4539a;

    static {
        f4539a = null;
    }

    public static SharedPreferences m8066a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f4539a == null) {
                f4539a = (SharedPreferences) ky.m6959a(new C0335k(context));
            }
            sharedPreferences = f4539a;
        }
        return sharedPreferences;
    }
}
