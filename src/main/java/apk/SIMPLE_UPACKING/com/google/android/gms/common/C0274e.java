package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import com.google.android.gms.common.internal.C0303v;
import com.google.android.gms.common.internal.C0304w;
import com.google.android.gms.p051b.ki;
import com.google.android.gms.p051b.kn;

/* renamed from: com.google.android.gms.common.e */
public final class C0274e extends C0273r {
    @Deprecated
    public static final int f4335a;

    static {
        f4335a = C0273r.f4327b;
    }

    @Deprecated
    public static int m7670a(Context context) {
        return C0273r.m7658b(context);
    }

    @Deprecated
    public static Dialog m7671a(int i, Activity activity, int i2) {
        return C0274e.m7672a(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog m7672a(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return C0274e.m7677b(i, activity, null, i2, onCancelListener);
    }

    @TargetApi(11)
    public static void m7673a(Activity activity, OnCancelListener onCancelListener, String str, Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            C0275f.m7678a(dialog, onCancelListener).m7679a(((FragmentActivity) activity).m1226f(), str);
        } else if (kn.m6932a()) {
            C0223a.m7284a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    @Deprecated
    public static boolean m7674a(int i) {
        return C0273r.m7663c(i);
    }

    public static boolean m7675a(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Dialog b = C0274e.m7677b(i, activity, fragment, i2, onCancelListener);
        if (b == null) {
            return false;
        }
        C0274e.m7673a(activity, onCancelListener, "GooglePlayServicesErrorDialog", b);
        return true;
    }

    @Deprecated
    public static boolean m7676a(Context context, int i) {
        return C0273r.m7664c(context, i);
    }

    @TargetApi(14)
    private static Dialog m7677b(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (ki.m6925a((Context) activity) && i == 2) {
            i = 42;
        }
        if (C0274e.m7676a(activity, i)) {
            i = 18;
        }
        if (kn.m6935c()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(activity);
        }
        builder.setMessage(C0303v.m7983a(activity, i, C0273r.m7667f(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent a = C0269b.m7645a().m7648a(activity, i, "d");
        OnClickListener c0304w = fragment == null ? new C0304w(activity, a, i2) : new C0304w(fragment, a, i2);
        CharSequence b = C0303v.m7984b(activity, i);
        if (b != null) {
            builder.setPositiveButton(b, c0304w);
        }
        CharSequence a2 = C0303v.m7982a(activity, i);
        if (a2 != null) {
            builder.setTitle(a2);
        }
        return builder.create();
    }
}
