package com.google.android.gms.p051b;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* renamed from: com.google.android.gms.b.r */
class C0215r implements Runnable {
    ValueCallback f4105a;
    final /* synthetic */ C0210m f4106b;
    final /* synthetic */ WebView f4107c;
    final /* synthetic */ boolean f4108d;
    final /* synthetic */ C0213p f4109e;

    C0215r(C0213p c0213p, C0210m c0210m, WebView webView, boolean z) {
        this.f4109e = c0213p;
        this.f4106b = c0210m;
        this.f4107c = webView;
        this.f4108d = z;
        this.f4105a = new C0216s(this);
    }

    public void run() {
        if (this.f4107c.getSettings().getJavaScriptEnabled()) {
            try {
                this.f4107c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f4105a);
            } catch (Throwable th) {
                this.f4105a.onReceiveValue("");
            }
        }
    }
}
