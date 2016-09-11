package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

class ci implements Callable {
    final /* synthetic */ AppMetadata f4898a;
    final /* synthetic */ cc f4899b;

    ci(cc ccVar, AppMetadata appMetadata) {
        this.f4899b = ccVar;
        this.f4898a = appMetadata;
    }

    public List m8823a() {
        return this.f4899b.f4881a.m8776o().m8395a(this.f4898a.f4619c);
    }

    public /* synthetic */ Object call() {
        return m8823a();
    }
}
