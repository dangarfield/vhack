package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@fi
@TargetApi(11)
/* renamed from: com.google.android.gms.b.hw */
public class hw extends hc {
    public hw(hb hbVar, boolean z) {
        super(hbVar, z);
    }

    protected WebResourceResponse m6795a(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", C0056g.m5439c().m6526a(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new gm(context).m6601a(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Exception e;
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (webView instanceof hb) {
                hb hbVar = (hb) webView;
                hbVar.m6652k().m6693f();
                String str2 = hbVar.m6651j().f2913e ? (String) an.f3404F.m6093c() : hbVar.m6656o() ? (String) an.f3403E.m6093c() : (String) an.f3402D.m6093c();
                fp.m6505e("shouldInterceptRequest(" + str2 + ")");
                return m6795a(hbVar.getContext(), this.a.m6655n().f3092b, str2);
            }
            C0099b.m5643d("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, str);
        } catch (IOException e2) {
            e = e2;
            C0099b.m5643d("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        } catch (ExecutionException e3) {
            e = e3;
            C0099b.m5643d("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        } catch (InterruptedException e4) {
            e = e4;
            C0099b.m5643d("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        } catch (TimeoutException e5) {
            e = e5;
            C0099b.m5643d("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        }
    }
}
