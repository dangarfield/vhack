package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.n */
class C0372n implements Runnable {
    final /* synthetic */ UserAttributeParcel f4933a;
    final /* synthetic */ C0367i f4934b;

    C0372n(C0367i c0367i, UserAttributeParcel userAttributeParcel) {
        this.f4934b = c0367i;
        this.f4933a = userAttributeParcel;
    }

    public void run() {
        ax c = r1.f4921b;
        if (c == null) {
            this.f4934b.m8897s().m8582b().m8607a("Discarding data. Failed to set user attribute");
            return;
        }
        try {
            c.m8495a(this.f4933a, this.f4934b.m8887i().m8541a(this.f4934b.m8897s().m8576A()));
            this.f4934b.m8874x();
        } catch (RemoteException e) {
            this.f4934b.m8897s().m8582b().m8608a("Failed to send attribute to AppMeasurementService", e);
        }
    }
}
