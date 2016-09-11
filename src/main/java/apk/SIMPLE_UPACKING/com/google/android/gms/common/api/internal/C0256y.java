package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0225a;
import java.util.Collections;

/* renamed from: com.google.android.gms.common.api.internal.y */
public class C0256y implements ak {
    private final al f4273a;

    public C0256y(al alVar) {
        this.f4273a = alVar;
    }

    public C0167c m7542a(C0167c c0167c) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void m7543a() {
        this.f4273a.m7389i();
        this.f4273a.f4179g.f4278d = Collections.emptySet();
    }

    public void m7544a(int i) {
    }

    public void m7545a(Bundle bundle) {
    }

    public void m7546a(ConnectionResult connectionResult, C0225a c0225a, int i) {
    }

    public boolean m7547b() {
        return true;
    }

    public void m7548c() {
        this.f4273a.m7385e();
    }
}
