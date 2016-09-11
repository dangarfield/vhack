package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class aj {
    private static final Object f4393a;
    private static aj f4394b;

    static {
        f4393a = new Object();
    }

    public static aj m7737a(Context context) {
        synchronized (f4393a) {
            if (f4394b == null) {
                f4394b = new ak(context.getApplicationContext());
            }
        }
        return f4394b;
    }

    public abstract boolean m7738a(String str, ServiceConnection serviceConnection, String str2);

    public abstract void m7739b(String str, ServiceConnection serviceConnection, String str2);
}
