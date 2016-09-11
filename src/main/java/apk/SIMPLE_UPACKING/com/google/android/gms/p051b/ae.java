package com.google.android.gms.p051b;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.C0056g;

@fi
/* renamed from: com.google.android.gms.b.ae */
public abstract class ae {
    private final int f3388a;
    private final String f3389b;
    private final Object f3390c;

    private ae(int i, String str, Object obj) {
        this.f3388a = i;
        this.f3389b = str;
        this.f3390c = obj;
        C0056g.m5444h().m6103a(this);
    }

    public static ae m6084a(int i, String str) {
        ae a = ae.m6088a(i, str, (String) null);
        C0056g.m5444h().m6104b(a);
        return a;
    }

    public static ae m6085a(int i, String str, int i2) {
        return new ag(i, str, Integer.valueOf(i2));
    }

    public static ae m6086a(int i, String str, long j) {
        return new ah(i, str, Long.valueOf(j));
    }

    public static ae m6087a(int i, String str, Boolean bool) {
        return new af(i, str, bool);
    }

    public static ae m6088a(int i, String str, String str2) {
        return new ai(i, str, str2);
    }

    public static ae m6089b(int i, String str) {
        ae a = ae.m6088a(i, str, (String) null);
        C0056g.m5444h().m6105c(a);
        return a;
    }

    protected abstract Object m6090a(SharedPreferences sharedPreferences);

    public String m6091a() {
        return this.f3389b;
    }

    public Object m6092b() {
        return this.f3390c;
    }

    public Object m6093c() {
        return C0056g.m5445i().m6107a(this);
    }
}
