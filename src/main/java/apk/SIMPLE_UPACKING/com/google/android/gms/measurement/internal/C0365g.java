package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.g */
class C0365g implements Runnable {
    final /* synthetic */ String f4914a;
    final /* synthetic */ String f4915b;
    final /* synthetic */ Object f4916c;
    final /* synthetic */ long f4917d;
    final /* synthetic */ C0362d f4918e;

    C0365g(C0362d c0362d, String str, String str2, Object obj, long j) {
        this.f4918e = c0362d;
        this.f4914a = str;
        this.f4915b = str2;
        this.f4916c = obj;
        this.f4917d = j;
    }

    public void run() {
        this.f4918e.m8829a(this.f4914a, this.f4915b, this.f4916c, this.f4917d);
    }
}
