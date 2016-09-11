package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.p007b.IntentCompat;

/* compiled from: NavUtils */
public final class bb {
    private static final bc f578a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f578a = new be();
        } else {
            f578a = new bd();
        }
    }

    public static boolean m957a(Activity activity, Intent intent) {
        return f578a.m963a(activity, intent);
    }

    public static void m960b(Activity activity, Intent intent) {
        f578a.m964b(activity, intent);
    }

    public static Intent m955a(Activity activity) {
        return f578a.m961a(activity);
    }

    public static Intent m956a(Context context, ComponentName componentName) {
        String b = m959b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return m959b(context, componentName2) == null ? IntentCompat.m1296a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String m958b(Activity activity) {
        try {
            return m959b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m959b(Context context, ComponentName componentName) {
        return f578a.m962a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
}
