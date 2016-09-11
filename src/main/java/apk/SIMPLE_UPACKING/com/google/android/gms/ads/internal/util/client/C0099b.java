package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.util.client.b */
public class C0099b {
    public static void m5636a(String str) {
        if (C0099b.m5638a(3)) {
            Log.d("Ads", str);
        }
    }

    public static void m5637a(String str, Throwable th) {
        if (C0099b.m5638a(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static boolean m5638a(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }

    public static void m5639b(String str) {
        if (C0099b.m5638a(6)) {
            Log.e("Ads", str);
        }
    }

    public static void m5640b(String str, Throwable th) {
        if (C0099b.m5638a(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void m5641c(String str) {
        if (C0099b.m5638a(4)) {
            Log.i("Ads", str);
        }
    }

    public static void m5642c(String str, Throwable th) {
        if (C0099b.m5638a(5)) {
            Log.w("Ads", str, th);
        }
    }

    public static void m5643d(String str) {
        if (C0099b.m5638a(5)) {
            Log.w("Ads", str);
        }
    }
}
