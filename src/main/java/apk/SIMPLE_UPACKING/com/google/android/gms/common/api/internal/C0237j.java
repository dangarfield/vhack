package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.internal.j */
class C0237j implements ar {
    final /* synthetic */ C0235h f4230a;

    C0237j(C0235h c0235h) {
        this.f4230a = c0235h;
    }

    public void m7466a(int i, boolean z) {
        this.f4230a.f4227m.lock();
        try {
            if (this.f4230a.f4226l) {
                this.f4230a.f4226l = false;
                this.f4230a.m7432a(i, z);
                return;
            }
            this.f4230a.f4226l = true;
            this.f4230a.f4218d.m7374a(i);
            this.f4230a.f4227m.unlock();
        } finally {
            this.f4230a.f4227m.unlock();
        }
    }

    public void m7467a(Bundle bundle) {
        this.f4230a.f4227m.lock();
        try {
            this.f4230a.f4225k = ConnectionResult.f4122a;
            this.f4230a.m7447j();
        } finally {
            this.f4230a.f4227m.unlock();
        }
    }

    public void m7468a(ConnectionResult connectionResult) {
        this.f4230a.f4227m.lock();
        try {
            this.f4230a.f4225k = connectionResult;
            this.f4230a.m7447j();
        } finally {
            this.f4230a.f4227m.unlock();
        }
    }
}
