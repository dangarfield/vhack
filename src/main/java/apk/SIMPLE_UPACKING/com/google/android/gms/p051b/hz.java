package com.google.android.gms.p051b;

/* renamed from: com.google.android.gms.b.hz */
class hz implements Runnable {
    final /* synthetic */ String f3807a;
    final /* synthetic */ long f3808b;
    final /* synthetic */ hy f3809c;

    hz(hy hyVar, String str, long j) {
        this.f3809c = hyVar;
        this.f3807a = str;
        this.f3808b = j;
    }

    public void run() {
        this.f3809c.f3499a.m7103a(this.f3807a, this.f3808b);
        this.f3809c.f3499a.m7102a(toString());
    }
}
