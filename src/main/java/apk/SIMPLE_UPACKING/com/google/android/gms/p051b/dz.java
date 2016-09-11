package com.google.android.gms.p051b;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.google.android.gms.b.dz */
class dz implements OnClickListener {
    final /* synthetic */ String f3583a;
    final /* synthetic */ String f3584b;
    final /* synthetic */ dy f3585c;

    dz(dy dyVar, String str, String str2) {
        this.f3585c = dyVar;
        this.f3583a = str;
        this.f3584b = str2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            ((DownloadManager) this.f3585c.f3582b.getSystemService("download")).enqueue(this.f3585c.m6407a(this.f3583a, this.f3584b));
        } catch (IllegalStateException e) {
            this.f3585c.m6386b("Could not store picture.");
        }
    }
}
