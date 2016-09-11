package com.google.android.gms.measurement.internal;

class cj implements Runnable {
    final /* synthetic */ AppMetadata f4900a;
    final /* synthetic */ cc f4901b;

    cj(cc ccVar, AppMetadata appMetadata) {
        this.f4901b = ccVar;
        this.f4900a = appMetadata;
    }

    public void run() {
        this.f4901b.m8821a(this.f4900a.f4624h);
        this.f4901b.f4881a.m8761b(this.f4900a);
    }
}
