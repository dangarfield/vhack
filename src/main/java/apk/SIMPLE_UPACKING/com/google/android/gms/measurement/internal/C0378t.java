package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.AppMeasurementService;

/* renamed from: com.google.android.gms.measurement.internal.t */
class C0378t implements Runnable {
    final /* synthetic */ C0374p f4945a;

    C0378t(C0374p c0374p) {
        this.f4945a = c0374p;
    }

    public void run() {
        this.f4945a.f4936a.m8866a(new ComponentName(this.f4945a.f4936a.m8891m(), AppMeasurementService.class));
    }
}
