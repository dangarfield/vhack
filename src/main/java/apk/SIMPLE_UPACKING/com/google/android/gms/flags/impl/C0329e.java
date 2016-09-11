package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.e */
final class C0329e implements Callable {
    final /* synthetic */ SharedPreferences f4530a;
    final /* synthetic */ String f4531b;
    final /* synthetic */ Integer f4532c;

    C0329e(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f4530a = sharedPreferences;
        this.f4531b = str;
        this.f4532c = num;
    }

    public Integer m8061a() {
        return Integer.valueOf(this.f4530a.getInt(this.f4531b, this.f4532c.intValue()));
    }

    public /* synthetic */ Object call() {
        return m8061a();
    }
}
