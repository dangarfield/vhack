package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.bf;

/* renamed from: com.google.android.gms.common.api.a */
public final class C0225a {
    private final C0106g f4140a;
    private final C0260k f4141b;
    private final C0227i f4142c;
    private final C0261l f4143d;
    private final String f4144e;

    public C0225a(String str, C0106g c0106g, C0227i c0227i) {
        bf.m7874a((Object) c0106g, (Object) "Cannot construct an Api with a null ClientBuilder");
        bf.m7874a((Object) c0227i, (Object) "Cannot construct an Api with a null ClientKey");
        this.f4144e = str;
        this.f4140a = c0106g;
        this.f4141b = null;
        this.f4142c = c0227i;
        this.f4143d = null;
    }

    public C0106g m7294a() {
        bf.m7878a(this.f4140a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f4140a;
    }

    public C0260k m7295b() {
        bf.m7878a(this.f4141b != null, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.f4141b;
    }

    public C0227i m7296c() {
        bf.m7878a(this.f4142c != null, (Object) "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.f4142c;
    }

    public boolean m7297d() {
        return this.f4143d != null;
    }

    public String m7298e() {
        return this.f4144e;
    }
}
