package com.google.android.gms.p051b;

import android.util.Log;
import java.util.Locale;

/* renamed from: com.google.android.gms.b.me */
public class me {
    public static String f4032a;
    public static boolean f4033b;

    static {
        f4032a = "Volley";
        f4033b = Log.isLoggable(f4032a, 2);
    }

    public static void m7096a(String str, Object... objArr) {
        if (f4033b) {
            Log.v(f4032a, me.m7100d(str, objArr));
        }
    }

    public static void m7097a(Throwable th, String str, Object... objArr) {
        Log.e(f4032a, me.m7100d(str, objArr), th);
    }

    public static void m7098b(String str, Object... objArr) {
        Log.d(f4032a, me.m7100d(str, objArr));
    }

    public static void m7099c(String str, Object... objArr) {
        Log.e(f4032a, me.m7100d(str, objArr));
    }

    private static String m7100d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str3 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(me.class)) {
                str3 = stackTrace[i].getClassName();
                str3 = str3.substring(str3.lastIndexOf(46) + 1);
                str2 = str3.substring(str3.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        str2 = str3;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
