package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebSettings;

@TargetApi(16)
/* renamed from: com.google.android.gms.b.gh */
public class gh extends ge {
    public void m6588a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            m6589a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public void m6589a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public boolean m6590a(Context context, WebSettings webSettings) {
        super.m6580a(context, webSettings);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }
}
