package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.f */
class C0364f implements Runnable {
    final /* synthetic */ String f4907a;
    final /* synthetic */ String f4908b;
    final /* synthetic */ long f4909c;
    final /* synthetic */ Bundle f4910d;
    final /* synthetic */ boolean f4911e;
    final /* synthetic */ String f4912f;
    final /* synthetic */ C0362d f4913g;

    C0364f(C0362d c0362d, String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        this.f4913g = c0362d;
        this.f4907a = str;
        this.f4908b = str2;
        this.f4909c = j;
        this.f4910d = bundle;
        this.f4911e = z;
        this.f4912f = str3;
    }

    public void run() {
        this.f4913g.m8831b(this.f4907a, this.f4908b, this.f4909c, this.f4910d, this.f4911e, this.f4912f);
    }
}
