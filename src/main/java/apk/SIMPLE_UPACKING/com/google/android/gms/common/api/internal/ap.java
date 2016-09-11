package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.C0268j;

abstract class ap extends BroadcastReceiver {
    protected Context f4154c;

    ap() {
    }

    public static ap m7334a(Context context, ap apVar) {
        return m7335a(context, apVar, C0268j.m7636b());
    }

    public static ap m7335a(Context context, ap apVar, C0268j c0268j) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(apVar, intentFilter);
        apVar.f4154c = context;
        if (c0268j.m7642a(context, "com.google.android.gms")) {
            return apVar;
        }
        apVar.m7336a();
        apVar.m7337b();
        return null;
    }

    protected abstract void m7336a();

    public synchronized void m7337b() {
        if (this.f4154c != null) {
            this.f4154c.unregisterReceiver(this);
        }
        this.f4154c = null;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            m7336a();
            m7337b();
        }
    }
}
