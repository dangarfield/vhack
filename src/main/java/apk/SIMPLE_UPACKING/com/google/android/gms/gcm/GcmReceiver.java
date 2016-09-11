package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.p007b.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;

public class GcmReceiver extends WakefulBroadcastReceiver {
    private static String f4541a;

    static {
        f4541a = "gcm.googleapis.com/refresh";
    }

    private void m8068c(Context context, Intent intent) {
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        m8069d(context, intent);
        try {
            ComponentName a;
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                a = WakefulBroadcastReceiver.m1303a(context, intent);
            } else {
                a = context.startService(intent);
                Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
            }
            if (a == null) {
                Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
                if (isOrderedBroadcast()) {
                    setResultCode(404);
                }
            } else if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
        } catch (Throwable e) {
            Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", e);
            if (isOrderedBroadcast()) {
                setResultCode(401);
            }
        }
    }

    private void m8069d(Context context, Intent intent) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
            return;
        }
        ServiceInfo serviceInfo = resolveService.serviceInfo;
        if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
            Log.e("GcmReceiver", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
            return;
        }
        String str = serviceInfo.name;
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        }
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "Restricting intent to a specific service: " + str);
        }
        intent.setClassName(context.getPackageName(), str);
    }

    public void m8070b(Context context, Intent intent) {
        m8068c(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("from");
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction()) || "google.com/iid".equals(stringExtra) || f4541a.equals(stringExtra)) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            m8070b(context, intent);
        } else {
            m8068c(context, intent);
        }
        if (isOrderedBroadcast() && getResultCode() == 0) {
            setResultCode(-1);
        }
    }
}
