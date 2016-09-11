package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.p051b.ke;
import com.google.android.gms.p051b.kj;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.k */
public class C0324k {
    private static String f4522a;
    private static C0324k f4523b;
    private static Integer f4524c;

    static {
        f4522a = "WakeLockTracker";
        f4523b = new C0324k();
    }

    public static C0324k m8053a() {
        return f4523b;
    }

    private static boolean m8054a(Context context) {
        if (f4524c == null) {
            f4524c = Integer.valueOf(C0324k.m8055b());
        }
        return f4524c.intValue() != C0320f.f4511b;
    }

    private static int m8055b() {
        try {
            return ke.m6911a() ? ((Integer) C0319e.f4508a.m6870c()).intValue() : C0320f.f4511b;
        } catch (SecurityException e) {
            return C0320f.f4511b;
        }
    }

    public void m8056a(Context context, String str, int i, String str2, String str3, int i2, List list) {
        m8057a(context, str, i, str2, str3, i2, list, 0);
    }

    public void m8057a(Context context, String str, int i, String str2, String str3, int i2, List list, long j) {
        if (!C0324k.m8054a(context)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f4522a, "missing wakeLock key. " + str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (7 == i || 8 == i || 10 == i || 11 == i) {
            try {
                context.startService(new Intent().setComponent(C0320f.f4510a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list, str, SystemClock.elapsedRealtime(), kj.m6928a(context), str3, context.getPackageName(), kj.m6929b(context), j)));
            } catch (Throwable e) {
                Log.wtf(f4522a, e);
            }
        }
    }
}
