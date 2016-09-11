package com.fyber.cache.p039a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.fyber.cache.CacheVideoDownloadService;
import com.fyber.utils.FyberLogger;

/* renamed from: com.fyber.cache.a.a */
public class ConfigurationBroadcastReceiver extends BroadcastReceiver {
    private static AlarmManager f2661a;

    public void onReceive(Context context, Intent intent) {
        if (f2661a == null) {
            f2661a = (AlarmManager) context.getSystemService("alarm");
        }
        PendingIntent service = PendingIntent.getService(context, 0, new Intent(context, CacheVideoDownloadService.class), 134217728);
        int intExtra = intent.getIntExtra("refresh.interval", 3600);
        int i = intExtra * 1000;
        FyberLogger.m5226c("ConfigurationBroadcastReceiver", "Next precache query will occur in " + intExtra + " seconds");
        f2661a.cancel(service);
        f2661a.set(3, SystemClock.elapsedRealtime() + ((long) i), service);
    }
}
