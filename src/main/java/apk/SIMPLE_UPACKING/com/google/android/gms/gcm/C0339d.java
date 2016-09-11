package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.iid.C0344a;
import com.google.android.gms.iid.C0351h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.gcm.d */
public class C0339d {
    public static int f4549a;
    public static int f4550b;
    public static int f4551c;
    static C0339d f4552d;
    private static final AtomicInteger f4553i;
    final Messenger f4554e;
    private Context f4555f;
    private PendingIntent f4556g;
    private Map f4557h;
    private final BlockingQueue f4558j;

    static {
        f4549a = 5000000;
        f4550b = 6500000;
        f4551c = 7000000;
        f4553i = new AtomicInteger(1);
    }

    public C0339d() {
        this.f4558j = new LinkedBlockingQueue();
        this.f4557h = Collections.synchronizedMap(new HashMap());
        this.f4554e = new Messenger(new C0340e(this, Looper.getMainLooper()));
    }

    public static synchronized C0339d m8086a(Context context) {
        C0339d c0339d;
        synchronized (C0339d.class) {
            if (f4552d == null) {
                f4552d = new C0339d();
                f4552d.f4555f = context.getApplicationContext();
            }
            c0339d = f4552d;
        }
        return c0339d;
    }

    private String m8087a(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        return C0344a.m8125b(this.f4555f).m8130c().m8167a("", str, "GCM");
    }

    private void m8089a(String str, String str2, long j, int i, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        m8095a(intent);
        intent.setPackage(C0339d.m8092b(this.f4555f));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i));
        intent.putExtra("google.from", m8087a(str));
        if (C0339d.m8092b(this.f4555f).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            C0344a.m8125b(this.f4555f).m8128b("GCM", "upstream", bundle2);
            return;
        }
        this.f4555f.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public static String m8092b(Context context) {
        return C0351h.m8146a(context);
    }

    private boolean m8093b(Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.f4557h.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    public static int m8094c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(C0339d.m8092b(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    synchronized void m8095a(Intent intent) {
        if (this.f4556g == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f4556g = PendingIntent.getBroadcast(this.f4555f, 0, intent2, 0);
        }
        intent.putExtra("app", this.f4556g);
    }

    public void m8096a(String str, String str2, long j, Bundle bundle) {
        m8089a(str, str2, j, -1, bundle);
    }
}
