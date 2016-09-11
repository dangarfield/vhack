package com.google.android.gms.p051b;

import android.os.Process;

/* renamed from: com.google.android.gms.b.ks */
class ks implements Runnable {
    private final Runnable f3880a;
    private final int f3881b;

    public ks(Runnable runnable, int i) {
        this.f3880a = runnable;
        this.f3881b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f3881b);
        this.f3880a.run();
    }
}
