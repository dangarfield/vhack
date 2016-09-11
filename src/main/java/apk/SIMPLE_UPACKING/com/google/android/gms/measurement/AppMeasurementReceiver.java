package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.p051b.md;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    static final Object f4601a;
    static md f4602b;
    static Boolean f4603c;

    static {
        f4601a = new Object();
    }

    public static boolean m8178a(Context context) {
        bf.m7873a((Object) context);
        if (f4603c != null) {
            return f4603c.booleanValue();
        }
        boolean a = ag.m8264a(context, AppMeasurementReceiver.class, false);
        f4603c = Boolean.valueOf(a);
        return a;
    }

    public void onReceive(Context context, Intent intent) {
        bx a = bx.m8735a(context);
        bc f = a.m8767f();
        String action = intent.getAction();
        if (a.m8765d().m8332N()) {
            f.m8606z().m8608a("Device AppMeasurementReceiver got", action);
        } else {
            f.m8606z().m8608a("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean a2 = AppMeasurementService.m8181a(context);
            Intent intent2 = new Intent(context, AppMeasurementService.class);
            intent2.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (f4601a) {
                context.startService(intent2);
                if (a2) {
                    try {
                        if (f4602b == null) {
                            f4602b = new md(context, 1, "AppMeasurement WakeLock");
                            f4602b.m7094a(false);
                        }
                        f4602b.m7092a(1000);
                    } catch (SecurityException e) {
                        f.m8583c().m8607a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                    return;
                }
            }
        }
    }
}
