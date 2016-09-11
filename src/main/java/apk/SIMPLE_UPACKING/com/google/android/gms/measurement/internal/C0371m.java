package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.m */
class C0371m implements Runnable {
    final /* synthetic */ String f4930a;
    final /* synthetic */ EventParcel f4931b;
    final /* synthetic */ C0367i f4932c;

    C0371m(C0367i c0367i, String str, EventParcel eventParcel) {
        this.f4932c = c0367i;
        this.f4930a = str;
        this.f4931b = eventParcel;
    }

    public void run() {
        ax c = this.f4932c.f4921b;
        if (c == null) {
            this.f4932c.m8897s().m8582b().m8607a("Discarding data. Failed to send event to service");
            return;
        }
        try {
            if (TextUtils.isEmpty(this.f4930a)) {
                c.m8493a(this.f4931b, this.f4932c.m8887i().m8541a(this.f4932c.m8897s().m8576A()));
            } else {
                c.m8494a(this.f4931b, this.f4930a, this.f4932c.m8897s().m8576A());
            }
            this.f4932c.m8874x();
        } catch (RemoteException e) {
            this.f4932c.m8897s().m8582b().m8608a("Failed to send event to AppMeasurementService", e);
        }
    }
}
