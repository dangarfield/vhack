package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.google.android.gms.b.du */
class du implements OnClickListener {
    final /* synthetic */ ds f3557a;

    du(ds dsVar) {
        this.f3557a = dsVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3557a.m6386b("Operation denied by user.");
    }
}
