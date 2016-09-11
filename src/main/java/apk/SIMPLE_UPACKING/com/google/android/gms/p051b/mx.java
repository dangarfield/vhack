package com.google.android.gms.p051b;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/* renamed from: com.google.android.gms.b.mx */
public final class mx extends HttpEntityEnclosingRequestBase {
    public mx(String str) {
        setURI(URI.create(str));
    }
}
