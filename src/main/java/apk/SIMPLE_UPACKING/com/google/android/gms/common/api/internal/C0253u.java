package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.C0252b;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.internal.u */
class C0253u extends C0252b {
    private final WeakReference f4268a;

    C0253u(C0242o c0242o) {
        this.f4268a = new WeakReference(c0242o);
    }

    public void m7537a(SignInResponse signInResponse) {
        C0242o c0242o = (C0242o) this.f4268a.get();
        if (c0242o != null) {
            c0242o.f4236a.m7378a(new C0254v(this, c0242o, c0242o, signInResponse));
        }
    }
}
