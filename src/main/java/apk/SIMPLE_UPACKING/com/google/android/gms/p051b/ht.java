package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.b.ht */
final class ht implements OnClickListener {
    final /* synthetic */ JsPromptResult f3803a;

    ht(JsPromptResult jsPromptResult) {
        this.f3803a = jsPromptResult;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3803a.cancel();
    }
}
