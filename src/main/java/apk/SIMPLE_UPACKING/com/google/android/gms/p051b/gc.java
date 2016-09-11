package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.io.File;
import java.util.Set;

@TargetApi(11)
/* renamed from: com.google.android.gms.b.gc */
public class gc extends gb {
    public hc m6577a(hb hbVar, boolean z) {
        return new hw(hbVar, z);
    }

    public Set m6578a(Uri uri) {
        return uri.getQueryParameterNames();
    }

    public boolean m6579a(Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    public boolean m6580a(Context context, WebSettings webSettings) {
        super.m6565a(context, webSettings);
        if (((File) gv.m6610a(new gd(this, context))) != null) {
            webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            webSettings.setAppCacheMaxSize(0);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setAllowContentAccess(false);
        return true;
    }

    public boolean m6581a(View view) {
        view.setLayerType(0, null);
        return true;
    }

    public boolean m6582a(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    public boolean m6583b(View view) {
        view.setLayerType(1, null);
        return true;
    }

    public WebChromeClient m6584c(hb hbVar) {
        return new ho(hbVar);
    }
}
