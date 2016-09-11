package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.b.hq */
final class hq implements OnClickListener {
    final /* synthetic */ JsResult f3800a;

    hq(JsResult jsResult) {
        this.f3800a = jsResult;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3800a.cancel();
    }
}
