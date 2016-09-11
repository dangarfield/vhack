package com.google.android.gms.auth.api.signin.internal;

/* renamed from: com.google.android.gms.auth.api.signin.internal.j */
public class C0172j {
    static int f3342a;
    private int f3343b;

    static {
        f3342a = 31;
    }

    public C0172j() {
        this.f3343b = 1;
    }

    public int m6017a() {
        return this.f3343b;
    }

    public C0172j m6018a(Object obj) {
        this.f3343b = (obj == null ? 0 : obj.hashCode()) + (this.f3343b * f3342a);
        return this;
    }

    public C0172j m6019a(boolean z) {
        this.f3343b = (z ? 1 : 0) + (this.f3343b * f3342a);
        return this;
    }
}
