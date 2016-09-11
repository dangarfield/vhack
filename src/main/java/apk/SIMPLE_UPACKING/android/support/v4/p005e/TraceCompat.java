package android.support.v4.p005e;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.e.i */
public final class TraceCompat {
    public static void m1435a(String str) {
        if (VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.m1437a(str);
        }
    }

    public static void m1434a() {
        if (VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.m1436a();
        }
    }
}
