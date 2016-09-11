package com.google.android.gms.measurement.internal;

class cg implements Runnable {
    final /* synthetic */ AppMetadata f4892a;
    final /* synthetic */ UserAttributeParcel f4893b;
    final /* synthetic */ cc f4894c;

    cg(cc ccVar, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.f4894c = ccVar;
        this.f4892a = appMetadata;
        this.f4893b = userAttributeParcel;
    }

    public void run() {
        this.f4894c.m8821a(this.f4892a.f4624h);
        this.f4894c.f4881a.m8762b(this.f4893b, this.f4892a);
    }
}
