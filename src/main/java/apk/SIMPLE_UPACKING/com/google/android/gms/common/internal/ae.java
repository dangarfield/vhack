package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0244s;

public class ae implements C0244s {
    final /* synthetic */ C0122y f4377a;

    public ae(C0122y c0122y) {
        this.f4377a = c0122y;
    }

    public void m7719a(ConnectionResult connectionResult) {
        if (connectionResult.m7280b()) {
            this.f4377a.m5750a(null, this.f4377a.f3204v);
        } else if (this.f4377a.f3207y != null) {
            this.f4377a.f3207y.m7346a(connectionResult);
        }
    }
}
