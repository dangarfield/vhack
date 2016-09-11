package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.support.v4.app.ay;
import android.support.v4.p007b.Loader;
import com.google.android.gms.common.api.C0257n;

/* renamed from: com.google.android.gms.auth.api.signin.internal.b */
class C0158b implements ay {
    final /* synthetic */ SignInHubActivity f3319a;

    private C0158b(SignInHubActivity signInHubActivity) {
        this.f3319a = signInHubActivity;
    }

    public Loader m5947a(int i, Bundle bundle) {
        return new C0162d(this.f3319a, C0257n.m7549a());
    }

    public void m5948a(Loader loader) {
    }

    public /* synthetic */ void m5949a(Loader loader, Object obj) {
        m5950a(loader, (Void) obj);
    }

    public void m5950a(Loader loader, Void voidR) {
        this.f3319a.setResult(this.f3319a.f3310s, this.f3319a.f3311t);
        this.f3319a.finish();
    }
}
