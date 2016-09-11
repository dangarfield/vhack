package com.google.android.gms.measurement.internal;

class cd implements Runnable {
    final /* synthetic */ AppMetadata f4883a;
    final /* synthetic */ cc f4884b;

    cd(cc ccVar, AppMetadata appMetadata) {
        this.f4884b = ccVar;
        this.f4883a = appMetadata;
    }

    public void run() {
        this.f4884b.m8821a(this.f4883a.f4624h);
        this.f4884b.f4881a.m8752a(this.f4883a);
    }
}
