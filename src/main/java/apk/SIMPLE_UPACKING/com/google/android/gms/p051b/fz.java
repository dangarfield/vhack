package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@fi
@TargetApi(8)
/* renamed from: com.google.android.gms.b.fz */
public class fz {
    private fz() {
    }

    public static fz m6555a(int i) {
        return i >= 19 ? new gi() : i >= 18 ? new gg() : i >= 17 ? new gf() : i >= 16 ? new gh() : i >= 14 ? new ge() : i >= 11 ? new gc() : i >= 9 ? new gb() : new fz();
    }

    public int m6556a() {
        return 0;
    }

    public Drawable m6557a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public hc m6558a(hb hbVar, boolean z) {
        return new hc(hbVar, z);
    }

    public String m6559a(Context context) {
        return "";
    }

    public String m6560a(SslError sslError) {
        return "";
    }

    public Set m6561a(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void m6562a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            m6563a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public void m6563a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean m6564a(Request request) {
        return false;
    }

    public boolean m6565a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean m6566a(View view) {
        return false;
    }

    public boolean m6567a(Window window) {
        return false;
    }

    public boolean m6568a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        hbVar.onPause();
        return true;
    }

    public int m6569b() {
        return 1;
    }

    public boolean m6570b(View view) {
        return false;
    }

    public boolean m6571b(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        hbVar.onResume();
        return true;
    }

    public int m6572c() {
        return 5;
    }

    public WebChromeClient m6573c(hb hbVar) {
        return null;
    }
}
