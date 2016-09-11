package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@fi
@TargetApi(14)
/* renamed from: com.google.android.gms.b.p */
public class C0213p extends Thread {
    private boolean f4092a;
    private boolean f4093b;
    private final Object f4094c;
    private final C0212o f4095d;
    private final C0211n f4096e;
    private final fh f4097f;
    private final int f4098g;
    private final int f4099h;
    private final int f4100i;
    private final int f4101j;
    private final int f4102k;

    C0217t m7254a(View view, C0210m c0210m) {
        int i = 0;
        if (view == null) {
            return new C0217t(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new C0217t(this, 0, 0);
            }
            c0210m.m7075b(text.toString(), globalVisibleRect);
            return new C0217t(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof hb)) {
            c0210m.m7077d();
            return m7261a((WebView) view, c0210m, globalVisibleRect) ? new C0217t(this, 0, 1) : new C0217t(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C0217t(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                C0217t a = m7254a(viewGroup.getChildAt(i), c0210m);
                i3 += a.f4111a;
                i2 += a.f4112b;
                i++;
            }
            return new C0217t(this, i3, i2);
        }
    }

    void m7255a(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                m7260a(view);
            }
        }
    }

    void m7256a(C0210m c0210m, WebView webView, String str, boolean z) {
        c0210m.m7076c();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    c0210m.m7072a(optString, z);
                } else {
                    c0210m.m7072a(webView.getTitle() + "\n" + optString, z);
                }
            }
            if (c0210m.m7073a()) {
                this.f4096e.m7242b(c0210m);
            }
        } catch (JSONException e) {
            C0099b.m5636a("Json string may be malformed.");
        } catch (Throwable th) {
            C0099b.m5637a("Failed to get webview content.", th);
            this.f4097f.m6493a(th, true);
        }
    }

    boolean m7257a() {
        try {
            Context b = this.f4095d.m7253b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (m7258a(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && m7259a(b)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    boolean m7258a(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean m7259a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    boolean m7260a(View view) {
        if (view == null) {
            return false;
        }
        view.post(new C0214q(this, view));
        return true;
    }

    @TargetApi(19)
    boolean m7261a(WebView webView, C0210m c0210m, boolean z) {
        if (!kn.m6938f()) {
            return false;
        }
        c0210m.m7077d();
        webView.post(new C0215r(this, c0210m, webView, z));
        return true;
    }

    public void m7262b() {
        synchronized (this.f4094c) {
            this.f4092a = true;
            C0099b.m5636a("ContentFetchThread: paused, mPause = " + this.f4092a);
        }
    }

    void m7263b(View view) {
        try {
            C0210m c0210m = new C0210m(this.f4099h, this.f4100i, this.f4101j, this.f4102k);
            C0217t a = m7254a(view, c0210m);
            c0210m.m7078e();
            if (a.f4111a != 0 || a.f4112b != 0) {
                if (a.f4112b != 0 || c0210m.m7079f() != 0) {
                    if (a.f4112b != 0 || !this.f4096e.m7241a(c0210m)) {
                        this.f4096e.m7243c(c0210m);
                    }
                }
            }
        } catch (Throwable e) {
            C0099b.m5640b("Exception in fetchContentOnUIThread", e);
            this.f4097f.m6493a(e, true);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.f4093b;
        if (r0 != 0) goto L_0x0052;
    L_0x0004:
        r0 = r3.m7257a();	 Catch:{ Throwable -> 0x0018 }
        if (r0 == 0) goto L_0x0044;
    L_0x000a:
        r0 = r3.f4095d;	 Catch:{ Throwable -> 0x0018 }
        r0 = r0.m7252a();	 Catch:{ Throwable -> 0x0018 }
        if (r0 != 0) goto L_0x0038;
    L_0x0012:
        r0 = "ContentFetchThread: no activity";
        com.google.android.gms.ads.internal.util.client.C0099b.m5636a(r0);	 Catch:{ Throwable -> 0x0018 }
        goto L_0x0000;
    L_0x0018:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.ads.internal.util.client.C0099b.m5640b(r1, r0);
        r1 = r3.f4097f;
        r2 = 1;
        r1.m6493a(r0, r2);
    L_0x0024:
        r1 = r3.f4094c;
        monitor-enter(r1);
    L_0x0027:
        r0 = r3.f4092a;	 Catch:{ all -> 0x004f }
        if (r0 == 0) goto L_0x004d;
    L_0x002b:
        r0 = "ContentFetchTask: waiting";
        com.google.android.gms.ads.internal.util.client.C0099b.m5636a(r0);	 Catch:{ InterruptedException -> 0x0036 }
        r0 = r3.f4094c;	 Catch:{ InterruptedException -> 0x0036 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0036 }
        goto L_0x0027;
    L_0x0036:
        r0 = move-exception;
        goto L_0x0027;
    L_0x0038:
        r3.m7255a(r0);	 Catch:{ Throwable -> 0x0018 }
    L_0x003b:
        r0 = r3.f4098g;	 Catch:{ Throwable -> 0x0018 }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ Throwable -> 0x0018 }
        java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x0018 }
        goto L_0x0024;
    L_0x0044:
        r0 = "ContentFetchTask: sleeping";
        com.google.android.gms.ads.internal.util.client.C0099b.m5636a(r0);	 Catch:{ Throwable -> 0x0018 }
        r3.m7262b();	 Catch:{ Throwable -> 0x0018 }
        goto L_0x003b;
    L_0x004d:
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
        goto L_0x0000;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
        throw r0;
    L_0x0052:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.p.run():void");
    }
}
