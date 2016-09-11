package com.google.android.gms.measurement;

import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bx;

/* renamed from: com.google.android.gms.measurement.c */
class C0356c implements Runnable {
    final /* synthetic */ bx f4607a;
    final /* synthetic */ int f4608b;
    final /* synthetic */ bc f4609c;
    final /* synthetic */ AppMeasurementService f4610d;

    C0356c(AppMeasurementService appMeasurementService, bx bxVar, int i, bc bcVar) {
        this.f4610d = appMeasurementService;
        this.f4607a = bxVar;
        this.f4608b = i;
        this.f4609c = bcVar;
    }

    public void run() {
        this.f4607a.m8749C();
        this.f4610d.f4605a.post(new C0357d(this));
    }
}
