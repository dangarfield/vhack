package com.google.android.gms.p051b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* renamed from: com.google.android.gms.b.hu */
final class hu implements OnClickListener {
    final /* synthetic */ JsPromptResult f3804a;
    final /* synthetic */ EditText f3805b;

    hu(JsPromptResult jsPromptResult, EditText editText) {
        this.f3804a = jsPromptResult;
        this.f3805b = editText;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3804a.confirm(this.f3805b.getText().toString());
    }
}
