package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.p007b.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.Iterator;

/* renamed from: com.google.android.gms.gcm.a */
public abstract class C0336a extends Service {
    private final Object f4542a;
    private int f4543b;
    private int f4544c;

    public C0336a() {
        this.f4542a = new Object();
        this.f4544c = 0;
    }

    private void m8071a(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("com.google.android.gms.gcm.PENDING_INTENT");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException e) {
                Log.e("GcmListenerService", "Notification pending intent canceled");
            }
        }
        if (C0336a.m8076b(intent.getExtras())) {
            C0341f.m8099b(this, intent);
        }
    }

    static void m8072a(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    private void m8074b() {
        synchronized (this.f4542a) {
            this.f4544c--;
            if (this.f4544c == 0) {
                m8084a(this.f4543b);
            }
        }
    }

    @TargetApi(11)
    private void m8075b(Intent intent) {
        if (VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new C0337b(this, intent));
        } else {
            new C0338c(this, intent).execute(new Void[0]);
        }
    }

    static boolean m8076b(Bundle bundle) {
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8077c(android.content.Intent r4) {
        /*
        r3 = this;
        r1 = r4.getAction();	 Catch:{ all -> 0x004a }
        r0 = -1;
        r2 = r1.hashCode();	 Catch:{ all -> 0x004a }
        switch(r2) {
            case 214175003: goto L_0x003c;
            case 366519424: goto L_0x0032;
            default: goto L_0x000c;
        };	 Catch:{ all -> 0x004a }
    L_0x000c:
        switch(r0) {
            case 0: goto L_0x0046;
            case 1: goto L_0x004f;
            default: goto L_0x000f;
        };	 Catch:{ all -> 0x004a }
    L_0x000f:
        r0 = "GcmListenerService";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004a }
        r1.<init>();	 Catch:{ all -> 0x004a }
        r2 = "Unknown intent action: ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x004a }
        r2 = r4.getAction();	 Catch:{ all -> 0x004a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x004a }
        r1 = r1.toString();	 Catch:{ all -> 0x004a }
        android.util.Log.d(r0, r1);	 Catch:{ all -> 0x004a }
    L_0x002b:
        r3.m8074b();	 Catch:{ all -> 0x004a }
        android.support.v4.p007b.WakefulBroadcastReceiver.m1304a(r4);
        return;
    L_0x0032:
        r2 = "com.google.android.c2dm.intent.RECEIVE";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x000c;
    L_0x003a:
        r0 = 0;
        goto L_0x000c;
    L_0x003c:
        r2 = "com.google.android.gms.gcm.NOTIFICATION_DISMISS";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x000c;
    L_0x0044:
        r0 = 1;
        goto L_0x000c;
    L_0x0046:
        r3.m8078d(r4);	 Catch:{ all -> 0x004a }
        goto L_0x002b;
    L_0x004a:
        r0 = move-exception;
        android.support.v4.p007b.WakefulBroadcastReceiver.m1304a(r4);
        throw r0;
    L_0x004f:
        r0 = r4.getExtras();	 Catch:{ all -> 0x004a }
        r0 = com.google.android.gms.gcm.C0336a.m8076b(r0);	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x002b;
    L_0x0059:
        com.google.android.gms.gcm.C0341f.m8100c(r3, r4);	 Catch:{ all -> 0x004a }
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.a.c(android.content.Intent):void");
    }

    private void m8078d(Intent intent) {
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        Object obj = -1;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    obj = 1;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals("gcm")) {
                    obj = null;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    obj = 3;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                if (C0336a.m8076b(intent.getExtras())) {
                    C0341f.m8097a(this, intent);
                }
                m8079e(intent);
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                m8080a();
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                m8081a(intent.getStringExtra("google.message_id"));
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m8083a(intent.getStringExtra("google.message_id"), intent.getStringExtra("error"));
            default:
                Log.w("GcmListenerService", "Received message with unknown type: " + stringExtra);
        }
    }

    private void m8079e(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("message_type");
        extras.remove("android.support.content.wakelockid");
        if (C0342g.m8110a(extras)) {
            if (C0342g.m8109a((Context) this)) {
                if (C0336a.m8076b(intent.getExtras())) {
                    C0341f.m8101d(this, intent);
                }
                C0342g.m8113b(extras);
            } else {
                C0342g.m8104a((Context) this, getClass()).m8118c(extras);
                return;
            }
        }
        String string = extras.getString("from");
        extras.remove("from");
        C0336a.m8072a(extras);
        m8082a(string, extras);
    }

    public void m8080a() {
    }

    public void m8081a(String str) {
    }

    public void m8082a(String str, Bundle bundle) {
    }

    public void m8083a(String str, String str2) {
    }

    boolean m8084a(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f4542a) {
            this.f4543b = i2;
            this.f4544c++;
        }
        if (intent == null) {
            m8074b();
            return 2;
        }
        if ("com.google.android.gms.gcm.NOTIFICATION_OPEN".equals(intent.getAction())) {
            m8071a(intent);
            m8074b();
            WakefulBroadcastReceiver.m1304a(intent);
        } else {
            m8075b(intent);
        }
        return 3;
    }
}
