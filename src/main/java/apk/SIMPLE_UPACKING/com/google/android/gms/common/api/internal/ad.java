package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.api.Status;

class ad implements C0230r {
    final /* synthetic */ aw f4162a;
    final /* synthetic */ C0258z f4163b;

    ad(C0258z c0258z, aw awVar) {
        this.f4163b = c0258z;
        this.f4162a = awVar;
    }

    public void m7347a(ConnectionResult connectionResult) {
        this.f4162a.m5976a(new Status(8));
    }
}
