package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.measurement.internal.r */
class C0376r implements Runnable {
    final /* synthetic */ ComponentName f4941a;
    final /* synthetic */ C0374p f4942b;

    C0376r(C0374p c0374p, ComponentName componentName) {
        this.f4942b = c0374p;
        this.f4941a = componentName;
    }

    public void run() {
        this.f4942b.f4936a.m8866a(this.f4941a);
    }
}
