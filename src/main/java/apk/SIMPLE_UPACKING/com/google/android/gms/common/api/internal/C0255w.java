package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;

/* renamed from: com.google.android.gms.common.api.internal.w */
class C0255w implements C0229q, C0230r {
    final /* synthetic */ C0242o f4272a;

    private C0255w(C0242o c0242o) {
        this.f4272a = c0242o;
    }

    public void m7539a(int i) {
    }

    public void m7540a(Bundle bundle) {
        this.f4272a.f4246k.m7065a(new C0253u(this.f4272a));
    }

    public void m7541a(ConnectionResult connectionResult) {
        this.f4272a.f4237b.lock();
        try {
            if (this.f4272a.m7493b(connectionResult)) {
                this.f4272a.m7507h();
                this.f4272a.m7500e();
            } else {
                this.f4272a.m7497c(connectionResult);
            }
            this.f4272a.f4237b.unlock();
        } catch (Throwable th) {
            this.f4272a.f4237b.unlock();
        }
    }
}
