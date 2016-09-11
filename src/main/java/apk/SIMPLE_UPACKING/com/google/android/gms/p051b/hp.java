package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.b.hp */
final class hp implements OnCancelListener {
    final /* synthetic */ JsResult f3799a;

    hp(JsResult jsResult) {
        this.f3799a = jsResult;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f3799a.cancel();
    }
}
