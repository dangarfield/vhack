package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.g */
final class C0331g implements Callable {
    final /* synthetic */ SharedPreferences f4533a;
    final /* synthetic */ String f4534b;
    final /* synthetic */ Long f4535c;

    C0331g(SharedPreferences sharedPreferences, String str, Long l) {
        this.f4533a = sharedPreferences;
        this.f4534b = str;
        this.f4535c = l;
    }

    public Long m8063a() {
        return Long.valueOf(this.f4533a.getLong(this.f4534b, this.f4535c.longValue()));
    }

    public /* synthetic */ Object call() {
        return m8063a();
    }
}
