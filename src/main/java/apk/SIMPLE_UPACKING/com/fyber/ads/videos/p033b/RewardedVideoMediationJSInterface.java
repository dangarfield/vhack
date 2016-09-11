package com.fyber.ads.videos.p033b;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;

/* renamed from: com.fyber.ads.videos.b.b */
public final class RewardedVideoMediationJSInterface implements ValueCallback {
    private ValueCallback f2574a;
    private Handler f2575b;
    private final String f2576c;

    public RewardedVideoMediationJSInterface() {
        this.f2575b = new Handler(Looper.getMainLooper(), new RewardedVideoMediationJSInterface(this));
        this.f2576c = "SynchJS";
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        m4980a((String) obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m4979a(android.webkit.WebView r7, android.webkit.ValueCallback r8) {
        /*
        r6 = this;
        if (r8 == 0) goto L_0x004a;
    L_0x0002:
        r6.f2574a = r8;
        r0 = r6.f2575b;
        r1 = 5689; // 0x1639 float:7.972E-42 double:2.8107E-320;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.sendEmptyMessageDelayed(r1, r2);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        if (r0 < r1) goto L_0x0044;
    L_0x0013:
        r0 = "javascript:try{ JSON.parse(Sponsorpay.MBE.SDKInterface.do_getOffer()).uses_tpn;}catch(error){false;};";
        r1 = r7.getClass();	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
        r2 = "evaluateJavascript";
        r3 = 2;
        r3 = new java.lang.Class[r3];	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
        r4 = 0;
        r5 = java.lang.String.class;
        r3[r4] = r5;	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
        r4 = 1;
        r5 = android.webkit.ValueCallback.class;
        r3[r4] = r5;	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
        r1 = r1.getMethod(r2, r3);	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
        r3 = 0;
        r2[r3] = r0;	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
        r0 = 1;
        r2[r0] = r6;	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
        r1.invoke(r7, r2);	 Catch:{ IllegalArgumentException -> 0x0052, IllegalAccessException -> 0x0039, InvocationTargetException -> 0x0056, SecurityException -> 0x0058, NoSuchMethodException -> 0x0054 }
    L_0x0038:
        return;
    L_0x0039:
        r0 = move-exception;
    L_0x003a:
        r1 = "RewardedVideoMediationJSInterface";
        r0 = r0.getLocalizedMessage();
        com.fyber.utils.FyberLogger.m5220a(r1, r0);
        goto L_0x0038;
    L_0x0044:
        r0 = "javascript:window.SynchJS.setValue((function(){try{return JSON.parse(Sponsorpay.MBE.SDKInterface.do_getOffer()).uses_tpn;}catch(js_eval_err){return false;}})());";
        r7.loadUrl(r0);
        goto L_0x0038;
    L_0x004a:
        r0 = "RewardedVideoMediationJSInterface";
        r1 = "There is no ValueCallback to notify. Aborting...";
        com.fyber.utils.FyberLogger.m5220a(r0, r1);
        goto L_0x0038;
    L_0x0052:
        r0 = move-exception;
        goto L_0x003a;
    L_0x0054:
        r0 = move-exception;
        goto L_0x003a;
    L_0x0056:
        r0 = move-exception;
        goto L_0x003a;
    L_0x0058:
        r0 = move-exception;
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.ads.videos.b.b.a(android.webkit.WebView, android.webkit.ValueCallback):void");
    }

    public final void m4980a(String str) {
        this.f2575b.removeMessages(5689);
        this.f2574a.onReceiveValue(Boolean.valueOf(Boolean.parseBoolean(str)));
        this.f2574a = null;
    }
}
