package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.internal.i */
class C0236i implements ar {
    final /* synthetic */ C0235h f4229a;

    C0236i(C0235h c0235h) {
        this.f4229a = c0235h;
    }

    public void m7463a(int i, boolean z) {
        r1.f4227m.lock();
        try {
            if (this.f4229a.f4226l || this.f4229a.f4225k == null || !this.f4229a.f4225k.m7280b()) {
                this.f4229a.f4226l = false;
                this.f4229a.m7432a(i, z);
                return;
            }
            this.f4229a.f4226l = true;
            this.f4229a.f4219e.m7374a(i);
            this.f4229a.f4227m.unlock();
        } finally {
            this.f4229a.f4227m.unlock();
        }
    }

    public void m7464a(Bundle bundle) {
        this.f4229a.f4227m.lock();
        try {
            this.f4229a.m7433a(bundle);
            this.f4229a.f4224j = ConnectionResult.f4122a;
            this.f4229a.m7447j();
        } finally {
            this.f4229a.f4227m.unlock();
        }
    }

    public void m7465a(ConnectionResult connectionResult) {
        this.f4229a.f4227m.lock();
        try {
            this.f4229a.f4224j = connectionResult;
            this.f4229a.m7447j();
        } finally {
            this.f4229a.f4227m.unlock();
        }
    }
}
