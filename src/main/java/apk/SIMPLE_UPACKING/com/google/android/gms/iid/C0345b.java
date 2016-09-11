package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.p007b.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.gcm.C0339d;
import java.io.IOException;

/* renamed from: com.google.android.gms.iid.b */
public class C0345b extends Service {
    static String f4574a;
    private static String f4575f;
    private static String f4576g;
    private static String f4577h;
    MessengerCompat f4578b;
    BroadcastReceiver f4579c;
    int f4580d;
    int f4581e;

    static {
        f4574a = "action";
        f4575f = "google.com/iid";
        f4576g = "CMD";
        f4577h = "gcm.googleapis.com/refresh";
    }

    static void m8133a(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(f4576g, "SYNC");
        context.startService(intent);
    }

    static void m8134a(Context context, C0353j c0353j) {
        c0353j.m8172b();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(f4576g, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    void m8135a() {
        synchronized (this) {
            this.f4580d--;
            if (this.f4580d == 0) {
                stopSelf(this.f4581e);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.f4580d + " " + this.f4581e);
            }
        }
    }

    void m8136a(int i) {
        synchronized (this) {
            this.f4580d++;
            if (i > this.f4581e) {
                this.f4581e = i;
            }
        }
    }

    public void m8137a(Intent intent) {
        C0344a b;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            b = C0344a.m8125b(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            b = C0344a.m8122a(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(f4576g);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                C0353j c = b.m8130c();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                c.m8176e(stringExtra);
                b.m8131d().m8162d(intent);
                return;
            } else if (f4577h.equals(intent.getStringExtra("from"))) {
                b.m8130c().m8176e(stringExtra);
                m8138a(false);
                return;
            } else if ("RST".equals(stringExtra2)) {
                b.m8129b();
                m8138a(true);
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!b.m8130c().m8171a()) {
                    b.m8130c().m8172b();
                    m8138a(true);
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                b.m8130c().m8176e(stringExtra);
                m8138a(false);
                return;
            } else if ("PING".equals(stringExtra2)) {
                try {
                    C0339d.m8086a((Context) this).m8096a(f4575f, C0351h.m8153b(), 0, intent.getExtras());
                    return;
                } catch (IOException e) {
                    Log.w("InstanceID", "Failed to send ping response");
                    return;
                }
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Register result in service " + stringExtra);
        }
        b.m8131d().m8162d(intent);
    }

    public void m8138a(boolean z) {
        m8139b();
    }

    public void m8139b() {
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.f4578b.m8119a();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.f4579c, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.f4579c);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m8136a(i2);
        if (intent == null) {
            m8135a();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                m8137a(intent);
            }
            m8135a();
            if (intent.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.m1304a(intent);
            }
            return 2;
        } finally {
            m8135a();
        }
    }
}
