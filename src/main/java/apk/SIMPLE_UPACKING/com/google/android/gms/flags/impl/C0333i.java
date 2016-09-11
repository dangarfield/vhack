package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.i */
final class C0333i implements Callable {
    final /* synthetic */ SharedPreferences f4536a;
    final /* synthetic */ String f4537b;
    final /* synthetic */ String f4538c;

    C0333i(SharedPreferences sharedPreferences, String str, String str2) {
        this.f4536a = sharedPreferences;
        this.f4537b = str;
        this.f4538c = str2;
    }

    public String m8065a() {
        return this.f4536a.getString(this.f4537b, this.f4538c);
    }

    public /* synthetic */ Object call() {
        return m8065a();
    }
}
