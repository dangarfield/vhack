package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.b.hr */
final class hr implements OnClickListener {
    final /* synthetic */ JsResult f3801a;

    hr(JsResult jsResult) {
        this.f3801a = jsResult;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3801a.confirm();
    }
}
