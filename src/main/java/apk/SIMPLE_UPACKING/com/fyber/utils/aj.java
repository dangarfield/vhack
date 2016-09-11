package com.fyber.utils;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;

/* compiled from: WebViewConfigs */
public final class aj {
    public static void m5249a(WebSettings webSettings) {
        if (VERSION.SDK_INT < 20) {
            try {
                WebSettings.class.getMethod("setPluginState", new Class[]{PluginState.class}).invoke(webSettings, new Object[]{PluginState.ON});
            } catch (Exception e) {
                FyberLogger.m5223b("WebViewConfigs", "Unable to enable plugin support for the webview");
            }
        }
    }

    public static void m5250a(WebView webView) {
        if (VERSION.SDK_INT >= 21) {
            CookieManager instance = CookieManager.getInstance();
            try {
                CookieManager.class.getMethod("setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}).invoke(instance, new Object[]{webView, Boolean.valueOf(true)});
            } catch (Exception e) {
                FyberLogger.m5223b("WebViewConfigs", "Unable to set acceptThirdPartyCookies for the webview");
            }
        }
    }
}
