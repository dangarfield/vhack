package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0257n;
import java.util.concurrent.atomic.AtomicReference;

class ac implements C0229q {
    final /* synthetic */ AtomicReference f4159a;
    final /* synthetic */ aw f4160b;
    final /* synthetic */ C0258z f4161c;

    ac(C0258z c0258z, AtomicReference atomicReference, aw awVar) {
        this.f4161c = c0258z;
        this.f4159a = atomicReference;
        this.f4160b = awVar;
    }

    public void m7344a(int i) {
    }

    public void m7345a(Bundle bundle) {
        this.f4161c.m7571a((C0257n) this.f4159a.get(), this.f4160b, true);
    }
}
