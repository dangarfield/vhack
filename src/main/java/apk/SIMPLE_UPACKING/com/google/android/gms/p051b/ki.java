package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

/* renamed from: com.google.android.gms.b.ki */
public final class ki {
    @TargetApi(20)
    public static boolean m6925a(Context context) {
        return kn.m6939g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static boolean m6926a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (kn.m6932a() && ((resources.getConfiguration().screenLayout & 15) > 3)) || ki.m6927b(resources);
    }

    @TargetApi(13)
    private static boolean m6927b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return kn.m6934b() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }
}
