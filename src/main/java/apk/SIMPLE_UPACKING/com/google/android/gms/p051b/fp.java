package com.google.android.gms.p051b;

import android.util.Log;
import com.google.android.gms.ads.internal.util.client.C0099b;

@fi
/* renamed from: com.google.android.gms.b.fp */
public final class fp extends C0099b {
    public static boolean m6503a() {
        return ((Boolean) an.ak.m6093c()).booleanValue();
    }

    private static boolean m6504b() {
        return C0099b.m5638a(2) && fp.m6503a();
    }

    public static void m6505e(String str) {
        if (fp.m6504b()) {
            Log.v("Ads", str);
        }
    }
}
