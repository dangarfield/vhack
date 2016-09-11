package com.fyber.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.Fyber.Settings.UIStringIdentifier;
import com.fyber.p034b.RemoteFileOperation;
import java.lang.ref.WeakReference;

/* compiled from: WebClient */
public abstract class ah extends WebViewClient {
    private WeakReference f2443a;

    protected abstract void m4898a(int i, String str);

    protected abstract void m4899a(String str, Uri uri);

    protected abstract void m4901b();

    public ah(Activity activity) {
        this.f2443a = new WeakReference(activity);
    }

    protected Activity m4897a() {
        return (Activity) this.f2443a.get();
    }

    private static String m4896a(String str, String str2) {
        return Uri.parse(str).getQueryParameter(str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        FyberLogger.m5226c("WebClient", "shouldOverrideUrlLoading called with url: " + str);
        if (str.startsWith("sponsorpay://")) {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (host.equals("exit")) {
                int parseInt;
                if (VERSION.SDK_INT < 21) {
                    CookieSyncManager.getInstance().sync();
                }
                String a = m4896a(str, "status");
                if (a != null) {
                    parseInt = Integer.parseInt(a);
                } else {
                    parseInt = -10;
                }
                host = m4896a(str, "url");
                FyberLogger.m5226c("WebClient", "Overriding. Target Url: " + host);
                String a2 = m4896a(str, "tracking_url");
                if (StringUtils.m5260b(a2)) {
                    FyberLogger.m5226c("WebClient", "Overriding. Tracking Url: " + a2);
                    RemoteFileOperation.m5037a(a2);
                }
                m4898a(parseInt, host);
            } else {
                m4899a(host, parse);
            }
            return true;
        }
        FyberLogger.m5226c("WebClient", "Not overriding");
        return false;
    }

    protected final boolean m4900a(String str) {
        boolean z = true;
        Activity a = m4897a();
        if (a == null || str == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri parse = Uri.parse(str);
        intent.setData(parse);
        try {
            a.startActivity(intent);
            m4901b();
            return true;
        } catch (ActivityNotFoundException e) {
            if (!parse.getScheme().equalsIgnoreCase("market")) {
                return false;
            }
            Context a2 = m4897a();
            parse = Uri.parse("market://search?q=pname:com.google");
            PackageManager packageManager = a2.getPackageManager();
            Intent intent2 = new Intent("android.intent.action.VIEW");
            if (parse != null) {
                intent2.setData(parse);
            }
            if (packageManager.queryIntentActivities(intent2, 65536).size() <= 0) {
                z = false;
            }
            if (z) {
                return false;
            }
            FyberLogger.m5220a("WebClient", "Play Store is not installed on this device...");
            m4903c();
            return false;
        }
    }

    protected void m4903c() {
        m4902b(ad.m5234a(UIStringIdentifier.ERROR_PLAY_STORE_UNAVAILABLE));
    }

    public final void m4902b(String str) {
        CharSequence a = ad.m5234a(UIStringIdentifier.ERROR_DIALOG_TITLE);
        CharSequence a2 = ad.m5234a(UIStringIdentifier.DISMISS_ERROR_DIALOG);
        Builder builder = new Builder(m4897a());
        builder.setTitle(a);
        builder.setMessage(str);
        builder.setNegativeButton(a2, new ai(this));
        AlertDialog create = builder.create();
        create.setOwnerActivity(m4897a());
        try {
            create.show();
        } catch (Exception e) {
            FyberLogger.m5221a("WebClient", "Couldn't show error dialog. Not displayed error message is: " + str, e);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError.getCertificate().getIssuedBy().getOName().matches(".*StartCom Ltd.*")) {
            sslErrorHandler.proceed();
        }
    }
}
