package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.o */
class C0373o implements Runnable {
    final /* synthetic */ C0367i f4935a;

    C0373o(C0367i c0367i) {
        this.f4935a = c0367i;
    }

    public void run() {
        ax c = this.f4935a.f4921b;
        if (c == null) {
            this.f4935a.m8897s().m8582b().m8607a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            c.m8492a(this.f4935a.m8887i().m8541a(this.f4935a.m8897s().m8576A()));
            this.f4935a.m8874x();
        } catch (RemoteException e) {
            this.f4935a.m8897s().m8582b().m8608a("Failed to send app launch to AppMeasurementService", e);
        }
    }
}
