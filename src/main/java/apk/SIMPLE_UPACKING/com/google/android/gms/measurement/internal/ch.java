package com.google.android.gms.measurement.internal;

class ch implements Runnable {
    final /* synthetic */ AppMetadata f4895a;
    final /* synthetic */ UserAttributeParcel f4896b;
    final /* synthetic */ cc f4897c;

    ch(cc ccVar, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.f4897c = ccVar;
        this.f4895a = appMetadata;
        this.f4896b = userAttributeParcel;
    }

    public void run() {
        this.f4897c.m8821a(this.f4895a.f4624h);
        this.f4897c.f4881a.m8755a(this.f4896b, this.f4895a);
    }
}
