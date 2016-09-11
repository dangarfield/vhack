package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class an implements ServiceConnection {
    final /* synthetic */ am f4410a;

    public an(am amVar) {
        this.f4410a = amVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (ak.m7740a(this.f4410a.f4402a)) {
            this.f4410a.f4407f = iBinder;
            this.f4410a.f4409h = componentName;
            for (ServiceConnection onServiceConnected : this.f4410a.f4404c) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f4410a.f4405d = 1;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (ak.m7740a(this.f4410a.f4402a)) {
            this.f4410a.f4407f = null;
            this.f4410a.f4409h = componentName;
            for (ServiceConnection onServiceDisconnected : this.f4410a.f4404c) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f4410a.f4405d = 2;
        }
    }
}
