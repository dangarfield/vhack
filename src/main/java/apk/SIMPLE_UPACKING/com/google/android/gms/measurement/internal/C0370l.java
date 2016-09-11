package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.l */
class C0370l implements Runnable {
    final /* synthetic */ C0367i f4929a;

    C0370l(C0367i c0367i) {
        this.f4929a = c0367i;
    }

    public void run() {
        ax c = this.f4929a.f4921b;
        if (c == null) {
            this.f4929a.m8897s().m8582b().m8607a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            c.m8496b(this.f4929a.m8887i().m8541a(this.f4929a.m8897s().m8576A()));
            this.f4929a.m8874x();
        } catch (RemoteException e) {
            this.f4929a.m8897s().m8582b().m8608a("Failed to send measurementEnabled to AppMeasurementService", e);
        }
    }
}
