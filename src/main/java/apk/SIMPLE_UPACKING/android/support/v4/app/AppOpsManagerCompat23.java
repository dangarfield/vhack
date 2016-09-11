package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

/* renamed from: android.support.v4.app.i */
class AppOpsManagerCompat23 {
    public static String m1078a(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static int m1077a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}
