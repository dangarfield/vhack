package android.support.v4.p007b;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

/* renamed from: android.support.v4.b.y */
public final class PermissionChecker {
    public static int m1302a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = AppOpsManagerCompat.m1072a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return AppOpsManagerCompat.m1071a(context, a, str2) != 0 ? -2 : 0;
    }

    public static int m1301a(Context context, String str) {
        return PermissionChecker.m1302a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
