package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.C0354a;

/* renamed from: com.google.android.gms.gcm.f */
class C0341f {
    static C0354a f4560a;

    public static void m8097a(Context context, Intent intent) {
        C0341f.m8098a(context, "_nr", intent);
    }

    private static void m8098a(Context context, String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (!(stringExtra == null || stringExtra2 == null)) {
            bundle.putString("_nmid", stringExtra);
            bundle.putString("_nmn", stringExtra2);
        }
        stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            stringExtra = null;
        }
        if (stringExtra != null) {
            bundle.putString("_nt", stringExtra);
        }
        try {
            bundle.putInt("_nmt", Integer.valueOf(intent.getStringExtra("google.c.a.ts")).intValue());
        } catch (NumberFormatException e) {
            Log.w("GcmAnalytics", "Error while parsing timestamp in GCM event.");
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.valueOf(intent.getStringExtra("google.c.a.udt")).intValue());
            } catch (NumberFormatException e2) {
                Log.w("GcmAnalytics", "Error while parsing use_device_time in GCM event.");
            }
        }
        if (Log.isLoggable("GcmAnalytics", 3)) {
            Log.d("GcmAnalytics", "Sending event=" + str + " params=" + bundle);
        }
        try {
            (f4560a == null ? C0354a.m8183a(context) : f4560a).m8184a("gcm", str, bundle);
        } catch (NoClassDefFoundError e3) {
            Log.w("GcmAnalytics", "Unable to log event, missing measurement library");
        }
    }

    public static void m8099b(Context context, Intent intent) {
        C0341f.m8098a(context, "_no", intent);
    }

    public static void m8100c(Context context, Intent intent) {
        C0341f.m8098a(context, "_nd", intent);
    }

    public static void m8101d(Context context, Intent intent) {
        C0341f.m8098a(context, "_nf", intent);
    }
}
