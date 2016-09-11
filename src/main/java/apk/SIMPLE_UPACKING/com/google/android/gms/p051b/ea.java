package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.google.android.gms.b.ea */
class ea implements OnClickListener {
    final /* synthetic */ dy f3586a;

    ea(dy dyVar) {
        this.f3586a = dyVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3586a.m6386b("User canceled the download.");
    }
}
