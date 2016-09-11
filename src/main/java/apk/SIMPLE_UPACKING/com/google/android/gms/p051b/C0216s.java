package com.google.android.gms.p051b;

import android.webkit.ValueCallback;

/* renamed from: com.google.android.gms.b.s */
class C0216s implements ValueCallback {
    final /* synthetic */ C0215r f4110a;

    C0216s(C0215r c0215r) {
        this.f4110a = c0215r;
    }

    public void m7264a(String str) {
        this.f4110a.f4109e.m7256a(this.f4110a.f4106b, this.f4110a.f4107c, str, this.f4110a.f4108d);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        m7264a((String) obj);
    }
}
