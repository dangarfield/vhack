package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.b.hs */
final class hs implements OnCancelListener {
    final /* synthetic */ JsPromptResult f3802a;

    hs(JsPromptResult jsPromptResult) {
        this.f3802a = jsPromptResult;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f3802a.cancel();
    }
}
