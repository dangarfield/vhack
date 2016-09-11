package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0225a;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.common.api.internal.l */
public class C0239l implements ak {
    private final al f4232a;
    private boolean f4233b;

    public C0239l(al alVar) {
        this.f4233b = false;
        this.f4232a = alVar;
    }

    private void m7470a(aj ajVar) {
        this.f4232a.f4179g.m7586a(ajVar);
        C0121h a = this.f4232a.f4179g.m7580a(ajVar.m5987b());
        if (a.m5723h() || !this.f4232a.f4174b.containsKey(ajVar.m5987b())) {
            ajVar.m5988b(a);
        } else {
            ajVar.m5990c(new Status(17));
        }
    }

    public C0167c m7471a(C0167c c0167c) {
        try {
            m7470a((aj) c0167c);
        } catch (DeadObjectException e) {
            this.f4232a.m7378a(new C0240m(this, this));
        }
        return c0167c;
    }

    public void m7472a() {
    }

    public void m7473a(int i) {
        this.f4232a.m7376a(null);
        this.f4232a.f4180h.m7394a(i, this.f4233b);
    }

    public void m7474a(Bundle bundle) {
    }

    public void m7475a(ConnectionResult connectionResult, C0225a c0225a, int i) {
    }

    public boolean m7476b() {
        if (this.f4233b) {
            return false;
        }
        if (this.f4232a.f4179g.m7606o()) {
            this.f4233b = true;
            for (ba a : this.f4232a.f4179g.f4283i) {
                a.m7419a();
            }
            return false;
        }
        this.f4232a.m7376a(null);
        return true;
    }

    public void m7477c() {
        if (this.f4233b) {
            this.f4233b = false;
            this.f4232a.m7378a(new C0241n(this, this));
        }
    }

    void m7478d() {
        if (this.f4233b) {
            this.f4233b = false;
            this.f4232a.f4179g.m7590a(false);
            m7476b();
        }
    }
}
