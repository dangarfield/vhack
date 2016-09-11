package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v7.p018b.R;
import android.text.TextUtils;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.ao;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.common.j */
public class C0268j {
    private static final C0268j f4321a;
    public static final int f4322b;

    static {
        f4322b = C0273r.f4327b;
        f4321a = new C0268j();
    }

    C0268j() {
    }

    public static C0268j m7636b() {
        return f4321a;
    }

    private String m7637b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f4322b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int m7638a(Context context) {
        int b = C0273r.m7658b(context);
        return C0273r.m7664c(context, b) ? 18 : b;
    }

    public Intent m7639a(Context context, int i, String str) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return ao.m7765a("com.google.android.gms", m7637b(context, str));
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return ao.m7764a("com.google.android.gms");
            case R.AppCompatTheme_dialogTheme /*42*/:
                return ao.m7763a();
            default:
                return null;
        }
    }

    public boolean m7640a(int i) {
        return C0273r.m7663c(i);
    }

    public boolean m7641a(Context context, int i) {
        return C0273r.m7664c(context, i);
    }

    public boolean m7642a(Context context, String str) {
        return C0273r.m7655a(context, str);
    }

    @Deprecated
    public Intent m7643b(int i) {
        return m7639a(null, i, null);
    }

    public void m7644b(Context context) {
        C0273r.m7662c(context);
    }
}
