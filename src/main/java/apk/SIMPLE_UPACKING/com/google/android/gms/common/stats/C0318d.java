package com.google.android.gms.common.stats;

import com.google.android.gms.p051b.je;

/* renamed from: com.google.android.gms.common.stats.d */
public final class C0318d {
    public static je f4502a;
    public static je f4503b;
    public static je f4504c;
    public static je f4505d;
    public static je f4506e;
    public static je f4507f;

    static {
        f4502a = je.m6863a("gms:common:stats:connections:level", Integer.valueOf(C0320f.f4511b));
        f4503b = je.m6865a("gms:common:stats:connections:ignored_calling_processes", "");
        f4504c = je.m6865a("gms:common:stats:connections:ignored_calling_services", "");
        f4505d = je.m6865a("gms:common:stats:connections:ignored_target_processes", "");
        f4506e = je.m6865a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        f4507f = je.m6864a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }
}
