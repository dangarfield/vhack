package com.google.android.gms.measurement.internal;

class ce implements Runnable {
    final /* synthetic */ AppMetadata f4885a;
    final /* synthetic */ EventParcel f4886b;
    final /* synthetic */ cc f4887c;

    ce(cc ccVar, AppMetadata appMetadata, EventParcel eventParcel) {
        this.f4887c = ccVar;
        this.f4885a = appMetadata;
        this.f4886b = eventParcel;
    }

    public void run() {
        this.f4887c.m8821a(this.f4885a.f4624h);
        this.f4887c.f4881a.m8753a(this.f4886b, this.f4885a);
    }
}
