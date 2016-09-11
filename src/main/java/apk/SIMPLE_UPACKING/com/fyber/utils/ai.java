package com.fyber.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: WebClient */
final class ai implements OnClickListener {
    final /* synthetic */ ah f2792a;

    ai(ah ahVar) {
        this.f2792a = ahVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f2792a.m4897a() != null) {
            this.f2792a.m4897a().finish();
        }
    }
}
