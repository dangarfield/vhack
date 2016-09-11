package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* renamed from: com.google.android.gms.b.kj */
public final class kj {
    private static IntentFilter f3866a;
    private static long f3867b;
    private static float f3868c;

    static {
        f3866a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        f3868c = Float.NaN;
    }

    @TargetApi(20)
    public static int m6928a(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f3866a);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i3 = (kn.m6939g() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1;
        if (i2 == 0) {
            i = 0;
        }
        return i3 | i;
    }

    public static synchronized float m6929b(Context context) {
        float f;
        synchronized (kj.class) {
            if (SystemClock.elapsedRealtime() - f3867b >= 60000 || f3868c == Float.NaN) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f3866a);
                if (registerReceiver != null) {
                    f3868c = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                f3867b = SystemClock.elapsedRealtime();
                f = f3868c;
            } else {
                f = f3868c;
            }
        }
        return f;
    }
}
