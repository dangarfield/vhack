package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.C0284f;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p051b.ki;
import com.google.android.gms.p051b.kk;
import com.google.android.gms.p051b.kn;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.r */
public class C0273r {
    private static final Object f4326a;
    @Deprecated
    public static final int f4327b;
    public static boolean f4328c;
    public static boolean f4329d;
    static int f4330e;
    static final AtomicBoolean f4331f;
    private static String f4332g;
    private static Integer f4333h;
    private static final AtomicBoolean f4334i;

    static {
        f4327b = C0273r.m7657b();
        f4328c = false;
        f4329d = false;
        f4330e = -1;
        f4326a = new Object();
        f4332g = null;
        f4333h = null;
        f4331f = new AtomicBoolean();
        f4334i = new AtomicBoolean();
    }

    private static void m7652a(Context context) {
        if (!f4334i.get()) {
            Integer num;
            synchronized (f4326a) {
                if (f4332g == null) {
                    f4332g = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            f4333h = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            f4333h = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!f4332g.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + f4332g + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = f4333h;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != f4327b) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + f4327b + " but" + " found " + num + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
    }

    public static boolean m7653a() {
        return f4328c ? f4329d : "user".equals(Build.TYPE);
    }

    @TargetApi(19)
    public static boolean m7654a(Context context, int i, String str) {
        if (kn.m6938f()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(21)
    static boolean m7655a(Context context, String str) {
        if (kn.m6941i()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (C0273r.m7669h(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean m7656a(PackageManager packageManager) {
        boolean z = true;
        synchronized (f4326a) {
            if (f4330e == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    if (C0313s.m7995a().m7996a(packageInfo, C0310o.f4463a[1]) != null) {
                        f4330e = 1;
                    } else {
                        f4330e = 0;
                    }
                } catch (NameNotFoundException e) {
                    f4330e = 0;
                }
            }
            if (f4330e == 0) {
                z = false;
            }
        }
        return z;
    }

    private static int m7657b() {
        return 8487000;
    }

    @Deprecated
    public static int m7658b(Context context) {
        if (C0284f.f4420a) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0001R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            C0273r.m7652a(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            C0313s a = C0313s.m7995a();
            if (!ki.m6925a(context)) {
                try {
                    if (a.m7996a(packageManager.getPackageInfo("com.android.vending", 8256), C0310o.f4463a) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (a.m7996a(packageInfo, a.m7996a(packageManager.getPackageInfo("com.android.vending", 8256), C0310o.f4463a)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (a.m7996a(packageInfo, C0310o.f4463a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (kk.m6930a(packageInfo.versionCode) < kk.m6930a(f4327b)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f4327b + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static String m7659b(int i) {
        return ConnectionResult.m7277a(i);
    }

    public static boolean m7660b(Context context, int i) {
        boolean z = false;
        if (!C0273r.m7654a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return C0313s.m7995a().m7998a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("GooglePlayServicesUtil", 3)) {
                return z;
            }
            Log.d("GooglePlayServicesUtil", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    public static boolean m7661b(PackageManager packageManager) {
        return C0273r.m7656a(packageManager) || !C0273r.m7653a();
    }

    @Deprecated
    public static void m7662c(Context context) {
        if (!f4331f.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    @Deprecated
    public static boolean m7663c(int i) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean m7664c(Context context, int i) {
        return i == 18 ? true : i == 1 ? C0273r.m7655a(context, "com.google.android.gms") : false;
    }

    public static Resources m7665d(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Context m7666e(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static String m7667f(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    @Deprecated
    public static int m7668g(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    @TargetApi(18)
    public static boolean m7669h(Context context) {
        if (kn.m6937e()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }
}
