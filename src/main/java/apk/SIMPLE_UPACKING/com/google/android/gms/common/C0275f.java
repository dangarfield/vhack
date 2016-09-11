package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.ad;
import com.google.android.gms.common.internal.bf;

/* renamed from: com.google.android.gms.common.f */
public class C0275f extends DialogFragment {
    private Dialog ai;
    private OnCancelListener aj;

    public C0275f() {
        this.ai = null;
        this.aj = null;
    }

    public static C0275f m7678a(Dialog dialog, OnCancelListener onCancelListener) {
        C0275f c0275f = new C0275f();
        Dialog dialog2 = (Dialog) bf.m7874a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0275f.ai = dialog2;
        if (onCancelListener != null) {
            c0275f.aj = onCancelListener;
        }
        return c0275f;
    }

    public void m7679a(ad adVar, String str) {
        super.m1201a(adVar, str);
    }

    public Dialog m7680c(Bundle bundle) {
        if (this.ai == null) {
            m1205b(false);
        }
        return this.ai;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.aj != null) {
            this.aj.onCancel(dialogInterface);
        }
    }
}
