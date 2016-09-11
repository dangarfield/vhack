package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.C0056g;

/* renamed from: com.google.android.gms.b.gk */
class gk implements OnClickListener {
    final /* synthetic */ String f3695a;
    final /* synthetic */ gj f3696b;

    gk(gj gjVar, String str) {
        this.f3696b = gjVar;
        this.f3695a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C0056g.m5439c().m6533a(this.f3696b.f3688a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.f3695a), "Share via"));
    }
}
