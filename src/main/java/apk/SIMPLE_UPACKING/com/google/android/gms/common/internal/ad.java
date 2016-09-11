package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class ad implements ServiceConnection {
    final /* synthetic */ C0122y f4375a;
    private final int f4376b;

    public ad(C0122y c0122y, int i) {
        this.f4375a = c0122y;
        this.f4376b = i;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        bf.m7874a((Object) iBinder, (Object) "Expecting a valid IBinder");
        synchronized (this.f4375a.f3197o) {
            this.f4375a.f3198p = ax.m7816a(iBinder);
        }
        this.f4375a.m5744a(0, this.f4376b);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f4375a.f3197o) {
            this.f4375a.f3198p = null;
        }
        this.f4375a.f3184a.sendMessage(this.f4375a.f3184a.obtainMessage(4, this.f4376b, 1));
    }
}
