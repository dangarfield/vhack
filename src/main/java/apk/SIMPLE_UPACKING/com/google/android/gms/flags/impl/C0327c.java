package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.c */
final class C0327c implements Callable {
    final /* synthetic */ SharedPreferences f4527a;
    final /* synthetic */ String f4528b;
    final /* synthetic */ Boolean f4529c;

    C0327c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f4527a = sharedPreferences;
        this.f4528b = str;
        this.f4529c = bool;
    }

    public Boolean m8059a() {
        return Boolean.valueOf(this.f4527a.getBoolean(this.f4528b, this.f4529c.booleanValue()));
    }

    public /* synthetic */ Object call() {
        return m8059a();
    }
}
