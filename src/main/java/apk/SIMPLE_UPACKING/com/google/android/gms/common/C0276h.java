package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.h */
public class C0276h implements ServiceConnection {
    boolean f4336a;
    private final BlockingQueue f4337b;

    public C0276h() {
        this.f4336a = false;
        this.f4337b = new LinkedBlockingQueue();
    }

    public IBinder m7681a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.f4336a) {
            throw new IllegalStateException();
        } else {
            this.f4336a = true;
            return (IBinder) this.f4337b.take();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4337b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
