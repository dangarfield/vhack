package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.WebChromeClient;

@TargetApi(14)
/* renamed from: com.google.android.gms.b.ge */
public class ge extends gc {
    public String m6586a(SslError sslError) {
        return sslError.getUrl();
    }

    public WebChromeClient m6587c(hb hbVar) {
        return new hx(hbVar);
    }
}
