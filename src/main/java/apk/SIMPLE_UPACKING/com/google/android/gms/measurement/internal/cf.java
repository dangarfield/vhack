package com.google.android.gms.measurement.internal;

class cf implements Runnable {
    final /* synthetic */ String f4888a;
    final /* synthetic */ EventParcel f4889b;
    final /* synthetic */ String f4890c;
    final /* synthetic */ cc f4891d;

    cf(cc ccVar, String str, EventParcel eventParcel, String str2) {
        this.f4891d = ccVar;
        this.f4888a = str;
        this.f4889b = eventParcel;
        this.f4890c = str2;
    }

    public void run() {
        this.f4891d.m8821a(this.f4888a);
        this.f4891d.f4881a.m8754a(this.f4889b, this.f4890c);
    }
}
