package com.google.android.gms.measurement;

/* renamed from: com.google.android.gms.measurement.d */
class C0357d implements Runnable {
    final /* synthetic */ C0356c f4611a;

    C0357d(C0356c c0356c) {
        this.f4611a = c0356c;
    }

    public void run() {
        if (!this.f4611a.f4610d.stopSelfResult(this.f4611a.f4608b)) {
            return;
        }
        if (this.f4611a.f4607a.m8765d().m8332N()) {
            this.f4611a.f4609c.m8606z().m8607a("Device AppMeasurementService processed last upload request");
        } else {
            this.f4611a.f4609c.m8606z().m8607a("Local AppMeasurementService processed last upload request");
        }
    }
}
