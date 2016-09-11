package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0225a;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.bf;

/* renamed from: com.google.android.gms.common.api.internal.g */
public class C0234g implements C0229q, C0230r {
    public final C0225a f4212a;
    private final int f4213b;
    private al f4214c;

    public C0234g(C0225a c0225a, int i) {
        this.f4212a = c0225a;
        this.f4213b = i;
    }

    private void m7425a() {
        bf.m7874a(this.f4214c, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void m7426a(int i) {
        m7425a();
        this.f4214c.m7374a(i);
    }

    public void m7427a(Bundle bundle) {
        m7425a();
        this.f4214c.m7375a(bundle);
    }

    public void m7428a(ConnectionResult connectionResult) {
        m7425a();
        this.f4214c.m7377a(connectionResult, this.f4212a, this.f4213b);
    }

    public void m7429a(al alVar) {
        this.f4214c = alVar;
    }
}
