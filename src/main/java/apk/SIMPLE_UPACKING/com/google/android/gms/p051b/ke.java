package com.google.android.gms.p051b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.google.android.gms.common.internal.C0284f;

/* renamed from: com.google.android.gms.b.ke */
public class ke {
    public static boolean m6911a() {
        return C0284f.f4420a && je.m6867b() && je.m6862a() == Process.myUid();
    }

    public static boolean m6912a(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
