package com.google.android.gms.p051b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.b.kq */
public class kq {
    private static final Method f3871a;
    private static final Method f3872b;
    private static final Method f3873c;
    private static final Method f3874d;
    private static final Method f3875e;

    static {
        f3871a = kq.m6951a();
        f3872b = kq.m6954b();
        f3873c = kq.m6956c();
        f3874d = kq.m6957d();
        f3875e = kq.m6958e();
    }

    public static int m6947a(WorkSource workSource) {
        if (f3873c != null) {
            try {
                return ((Integer) f3873c.invoke(workSource, new Object[0])).intValue();
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static WorkSource m6948a(int i, String str) {
        WorkSource workSource = new WorkSource();
        kq.m6952a(workSource, i, str);
        return workSource;
    }

    public static WorkSource m6949a(Context context, String str) {
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return kq.m6948a(applicationInfo.uid, str);
            }
            Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + str);
            return null;
        } catch (NameNotFoundException e) {
            Log.e("WorkSourceUtil", "Could not find package: " + str);
            return null;
        }
    }

    public static String m6950a(WorkSource workSource, int i) {
        if (f3875e != null) {
            try {
                return (String) f3875e.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    private static Method m6951a() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    public static void m6952a(WorkSource workSource, int i, String str) {
        if (f3872b != null) {
            if (str == null) {
                str = "";
            }
            try {
                f3872b.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else if (f3871a != null) {
            try {
                f3871a.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
    }

    public static boolean m6953a(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null && packageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    private static Method m6954b() {
        Method method = null;
        if (kn.m6937e()) {
            try {
                method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        return method;
    }

    public static List m6955b(WorkSource workSource) {
        int i = 0;
        int a = workSource == null ? 0 : kq.m6947a(workSource);
        if (a == 0) {
            return Collections.EMPTY_LIST;
        }
        List arrayList = new ArrayList();
        while (i < a) {
            String a2 = kq.m6950a(workSource, i);
            if (!kp.m6946a(a2)) {
                arrayList.add(a2);
            }
            i++;
        }
        return arrayList;
    }

    private static Method m6956c() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
        }
        return method;
    }

    private static Method m6957d() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method m6958e() {
        Method method = null;
        if (kn.m6937e()) {
            try {
                method = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        return method;
    }
}
