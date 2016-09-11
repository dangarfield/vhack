package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.k */
final class C0335k implements Callable {
    final /* synthetic */ Context f4540a;

    C0335k(Context context) {
        this.f4540a = context;
    }

    public SharedPreferences m8067a() {
        return this.f4540a.getSharedPreferences("google_sdk_flags", 1);
    }

    public /* synthetic */ Object call() {
        return m8067a();
    }
}
