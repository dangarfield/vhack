package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cc;
import com.google.android.gms.p051b.md;

public final class AppMeasurementService extends Service {
    private static Boolean f4604b;
    private final Handler f4605a;

    public AppMeasurementService() {
        this.f4605a = new Handler();
    }

    private void m8180a() {
        try {
            synchronized (AppMeasurementReceiver.f4601a) {
                md mdVar = AppMeasurementReceiver.f4602b;
                if (mdVar != null && mdVar.m7095b()) {
                    mdVar.m7091a();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean m8181a(Context context) {
        bf.m7873a((Object) context);
        if (f4604b != null) {
            return f4604b.booleanValue();
        }
        boolean a = ag.m8263a(context, AppMeasurementService.class);
        f4604b = Boolean.valueOf(a);
        return a;
    }

    private bc m8182b() {
        return bx.m8735a((Context) this).m8767f();
    }

    public IBinder onBind(Intent intent) {
        if (intent == null) {
            m8182b().m8582b().m8607a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new cc(bx.m8735a((Context) this));
        }
        m8182b().m8583c().m8608a("onBind received unknown action", action);
        return null;
    }

    public void onCreate() {
        super.onCreate();
        bx a = bx.m8735a((Context) this);
        bc f = a.m8767f();
        if (a.m8765d().m8332N()) {
            f.m8606z().m8607a("Device AppMeasurementService is starting up");
        } else {
            f.m8606z().m8607a("Local AppMeasurementService is starting up");
        }
    }

    public void onDestroy() {
        bx a = bx.m8735a((Context) this);
        bc f = a.m8767f();
        if (a.m8765d().m8332N()) {
            f.m8606z().m8607a("Device AppMeasurementService is shutting down");
        } else {
            f.m8606z().m8607a("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        if (intent == null) {
            m8182b().m8582b().m8607a("onRebind called with null intent");
            return;
        }
        m8182b().m8606z().m8608a("onRebind called. action", intent.getAction());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m8180a();
        bx a = bx.m8735a((Context) this);
        bc f = a.m8767f();
        String action = intent.getAction();
        if (a.m8765d().m8332N()) {
            f.m8606z().m8609a("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        } else {
            f.m8606z().m8609a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a.m8769h().m8709a(new C0356c(this, a, i2, f));
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            m8182b().m8582b().m8607a("onUnbind called with null intent");
        } else {
            m8182b().m8606z().m8608a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
