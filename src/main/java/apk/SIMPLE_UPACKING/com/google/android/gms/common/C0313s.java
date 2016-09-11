package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;

/* renamed from: com.google.android.gms.common.s */
public class C0313s {
    private static final C0313s f4464a;

    static {
        f4464a = new C0313s();
    }

    private C0313s() {
    }

    public static C0313s m7995a() {
        return f4464a;
    }

    C0307l m7996a(PackageInfo packageInfo, C0307l... c0307lArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C0307l c0308m = new C0308m(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < c0307lArr.length; i++) {
            if (c0307lArr[i].equals(c0308m)) {
                return c0307lArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(c0308m.m7989a(), 0));
        }
        return null;
    }

    public boolean m7997a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            C0307l a;
            if (z) {
                a = m7996a(packageInfo, C0310o.f4463a);
            } else {
                a = m7996a(packageInfo, C0310o.f4463a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m7998a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (C0273r.m7661b(packageManager)) {
            return m7997a(packageInfo, true);
        }
        boolean a = m7997a(packageInfo, false);
        if (a || !m7997a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }
}
