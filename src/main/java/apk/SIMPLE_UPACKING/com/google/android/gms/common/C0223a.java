package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.bf;

@TargetApi(11)
/* renamed from: com.google.android.gms.common.a */
public class C0223a extends DialogFragment {
    private Dialog f4127a;
    private OnCancelListener f4128b;

    public C0223a() {
        this.f4127a = null;
        this.f4128b = null;
    }

    public static C0223a m7284a(Dialog dialog, OnCancelListener onCancelListener) {
        C0223a c0223a = new C0223a();
        Dialog dialog2 = (Dialog) bf.m7874a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0223a.f4127a = dialog2;
        if (onCancelListener != null) {
            c0223a.f4128b = onCancelListener;
        }
        return c0223a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f4128b != null) {
            this.f4128b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f4127a == null) {
            setShowsDialog(false);
        }
        return this.f4127a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
