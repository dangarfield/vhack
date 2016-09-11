package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.kf;
import com.google.android.gms.p051b.kh;

/* renamed from: com.google.android.gms.auth.api.signin.internal.x */
public class C0184x {
    private final String f3352a;
    private final long f3353b;
    private final kf f3354c;

    public C0184x(String str, long j) {
        this(str, j, kh.m6922c());
    }

    private C0184x(String str, long j, kf kfVar) {
        this.f3352a = bf.m7875a(str);
        bf.m7881b(j > 0);
        this.f3353b = j;
        this.f3354c = (kf) bf.m7873a((Object) kfVar);
    }

    public boolean m6052a() {
        return this.f3354c.m6913a() / 1000 >= this.f3353b - 300;
    }
}
