package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class ag extends C0279z {
    final /* synthetic */ C0122y f4383e;

    public ag(C0122y c0122y, int i) {
        this.f4383e = c0122y;
        super(c0122y, i, null);
    }

    protected void m7727a(ConnectionResult connectionResult) {
        this.f4383e.f3199q.m7520a(connectionResult);
        this.f4383e.m5748a(connectionResult);
    }

    protected boolean m7728a() {
        this.f4383e.f3199q.m7520a(ConnectionResult.f4122a);
        return true;
    }
}
