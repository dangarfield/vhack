package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class ac extends au {
    private C0122y f4373a;
    private final int f4374b;

    public ac(C0122y c0122y, int i) {
        this.f4373a = c0122y;
        this.f4374b = i;
    }

    private void m7716a() {
        this.f4373a = null;
    }

    public void m7717a(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public void m7718a(int i, IBinder iBinder, Bundle bundle) {
        bf.m7874a(this.f4373a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.f4373a.m5745a(i, iBinder, bundle, this.f4374b);
        m7716a();
    }
}
