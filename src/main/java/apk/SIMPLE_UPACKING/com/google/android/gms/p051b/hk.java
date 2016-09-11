package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.C0025b;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C0046n;
import com.google.android.gms.ads.internal.overlay.C0060c;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@fi
/* renamed from: com.google.android.gms.b.hk */
class hk extends WebView implements OnGlobalLayoutListener, DownloadListener, hb {
    private int f3764A;
    private Map f3765B;
    private final WindowManager f3766C;
    private final hm f3767a;
    private final Object f3768b;
    private final C0202f f3769c;
    private final VersionInfoParcel f3770d;
    private final C0025b f3771e;
    private hc f3772f;
    private C0060c f3773g;
    private AdSizeParcel f3774h;
    private boolean f3775i;
    private boolean f3776j;
    private boolean f3777k;
    private boolean f3778l;
    private Boolean f3779m;
    private int f3780n;
    private boolean f3781o;
    private String f3782p;
    private av f3783q;
    private av f3784r;
    private av f3785s;
    private ay f3786t;
    private WeakReference f3787u;
    private C0060c f3788v;
    private gw f3789w;
    private int f3790x;
    private int f3791y;
    private int f3792z;

    protected hk(hm hmVar, AdSizeParcel adSizeParcel, boolean z, boolean z2, C0202f c0202f, VersionInfoParcel versionInfoParcel, az azVar, C0025b c0025b) {
        super(hmVar);
        this.f3768b = new Object();
        this.f3781o = true;
        this.f3782p = "";
        this.f3790x = -1;
        this.f3791y = -1;
        this.f3792z = -1;
        this.f3764A = -1;
        this.f3767a = hmVar;
        this.f3774h = adSizeParcel;
        this.f3777k = z;
        this.f3780n = -1;
        this.f3769c = c0202f;
        this.f3770d = versionInfoParcel;
        this.f3771e = c0025b;
        this.f3766C = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        C0056g.m5439c().m6534a((Context) hmVar, versionInfoParcel.f3092b, settings);
        C0056g.m5441e().m6565a(getContext(), settings);
        setDownloadListener(this);
        m6737B();
        if (kn.m6936d()) {
            addJavascriptInterface(new hn(this), "googleAdsJsInterface");
        }
        this.f3789w = new gw(this.f3767a.m6787a(), this, null);
        m6743a(azVar);
    }

    private void m6736A() {
        aq.m6114a(this.f3786t.m6123a(), this.f3783q, "aeh");
    }

    private void m6737B() {
        synchronized (this.f3768b) {
            if (this.f3777k || this.f3774h.f2913e) {
                if (VERSION.SDK_INT < 14) {
                    C0099b.m5636a("Disabling hardware acceleration on an overlay.");
                    m6738C();
                } else {
                    C0099b.m5636a("Enabling hardware acceleration on an overlay.");
                    m6739D();
                }
            } else if (VERSION.SDK_INT < 18) {
                C0099b.m5636a("Disabling hardware acceleration on an AdView.");
                m6738C();
            } else {
                C0099b.m5636a("Enabling hardware acceleration on an AdView.");
                m6739D();
            }
        }
    }

    private void m6738C() {
        synchronized (this.f3768b) {
            if (!this.f3778l) {
                C0056g.m5441e().m6570b((View) this);
            }
            this.f3778l = true;
        }
    }

    private void m6739D() {
        synchronized (this.f3768b) {
            if (this.f3778l) {
                C0056g.m5441e().m6566a((View) this);
            }
            this.f3778l = false;
        }
    }

    private void m6740E() {
        synchronized (this.f3768b) {
            if (this.f3765B != null) {
                for (cq a : this.f3765B.values()) {
                    a.m6250a();
                }
            }
        }
    }

    private void m6741F() {
        if (this.f3786t != null) {
            az a = this.f3786t.m6123a();
            if (a != null && C0056g.m5442f().m6497a() != null) {
                C0056g.m5442f().m6497a().m6110a(a);
            }
        }
    }

    static hk m6742a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, C0202f c0202f, VersionInfoParcel versionInfoParcel, az azVar, C0025b c0025b) {
        return new hk(new hm(context), adSizeParcel, z, z2, c0202f, versionInfoParcel, azVar, c0025b);
    }

    private void m6743a(az azVar) {
        m6741F();
        this.f3786t = new ay(new az(true, "make_wv", this.f3774h.f2910b));
        this.f3786t.m6123a().m6128a(azVar);
        this.f3784r = aq.m6111a(this.f3786t.m6123a());
        this.f3786t.m6124a("native:view_create", this.f3784r);
        this.f3785s = null;
        this.f3783q = null;
    }

    private void m6745z() {
        synchronized (this.f3768b) {
            this.f3779m = C0056g.m5442f().m6502c();
            if (this.f3779m == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    m6751a(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    m6751a(Boolean.valueOf(false));
                }
            }
        }
    }

    public WebView m6746a() {
        return this;
    }

    public void m6747a(int i) {
        m6736A();
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.f3770d.f3092b);
        m6754a("onhide", hashMap);
    }

    public void m6748a(Context context) {
        this.f3767a.setBaseContext(context);
        this.f3789w.m6614a(this.f3767a.m6787a());
    }

    public void m6749a(AdSizeParcel adSizeParcel) {
        synchronized (this.f3768b) {
            this.f3774h = adSizeParcel;
            requestLayout();
        }
    }

    public void m6750a(C0060c c0060c) {
        synchronized (this.f3768b) {
            this.f3773g = c0060c;
        }
    }

    void m6751a(Boolean bool) {
        this.f3779m = bool;
        C0056g.m5442f().m6499a(bool);
    }

    public void m6752a(String str) {
        synchronized (this.f3768b) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                C0099b.m5643d("Could not call loadUrl. " + th);
            }
        }
    }

    @TargetApi(19)
    protected void m6753a(String str, ValueCallback valueCallback) {
        synchronized (this.f3768b) {
            if (m6777p()) {
                C0099b.m5643d("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void m6754a(String str, Map map) {
        try {
            m6755a(str, C0056g.m5439c().m6530a(map));
        } catch (JSONException e) {
            C0099b.m5643d("Could not convert parameters to JSON.");
        }
    }

    public void m6755a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        fp.m6505e("Dispatching AFMA event: " + stringBuilder.toString());
        m6763c(stringBuilder.toString());
    }

    public void m6756a(boolean z) {
        synchronized (this.f3768b) {
            this.f3777k = z;
            m6737B();
        }
    }

    public View m6757b() {
        return this;
    }

    public void m6758b(int i) {
        synchronized (this.f3768b) {
            this.f3780n = i;
            if (this.f3773g != null) {
                this.f3773g.m5477a(this.f3780n);
            }
        }
    }

    public void m6759b(C0060c c0060c) {
        synchronized (this.f3768b) {
            this.f3788v = c0060c;
        }
    }

    protected void m6760b(String str) {
        synchronized (this.f3768b) {
            if (m6777p()) {
                C0099b.m5643d("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void m6761b(boolean z) {
        synchronized (this.f3768b) {
            if (this.f3773g != null) {
                this.f3773g.m5482a(this.f3772f.m6689b(), z);
            } else {
                this.f3775i = z;
            }
        }
    }

    public void m6762c() {
        m6736A();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f3770d.f3092b);
        m6754a("onhide", hashMap);
    }

    protected void m6763c(String str) {
        if (kn.m6938f()) {
            if (m6786y() == null) {
                m6745z();
            }
            if (m6786y().booleanValue()) {
                m6753a(str, null);
                return;
            } else {
                m6760b("javascript:" + str);
                return;
            }
        }
        m6760b("javascript:" + str);
    }

    public void m6764c(boolean z) {
        synchronized (this.f3768b) {
            this.f3781o = z;
        }
    }

    public void m6765d() {
        if (this.f3783q == null) {
            aq.m6114a(this.f3786t.m6123a(), this.f3785s, "aes");
            this.f3783q = aq.m6111a(this.f3786t.m6123a());
            this.f3786t.m6124a("native:view_show", this.f3783q);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f3770d.f3092b);
        m6754a("onshow", hashMap);
    }

    public void destroy() {
        synchronized (this.f3768b) {
            m6741F();
            this.f3789w.m6615b();
            if (this.f3773g != null) {
                this.f3773g.m5476a();
                this.f3773g.m5495k();
                this.f3773g = null;
            }
            this.f3772f.m6692e();
            if (this.f3776j) {
                return;
            }
            C0056g.m5447k().m6246a((hb) this);
            m6740E();
            this.f3776j = true;
            fp.m6505e("Initiating WebView self destruct sequence in 3...");
            this.f3772f.m6690c();
        }
    }

    public Activity m6766e() {
        return this.f3767a.m6787a();
    }

    @TargetApi(19)
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
        synchronized (this.f3768b) {
            if (m6777p()) {
                C0099b.m5643d("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
                return;
            }
            super.evaluateJavascript(str, valueCallback);
        }
    }

    public Context m6767f() {
        return this.f3767a.m6788b();
    }

    protected void finalize() {
        synchronized (this.f3768b) {
            if (!this.f3776j) {
                C0056g.m5447k().m6246a((hb) this);
                m6740E();
            }
        }
        super.finalize();
    }

    public C0025b m6768g() {
        return this.f3771e;
    }

    public C0060c m6769h() {
        C0060c c0060c;
        synchronized (this.f3768b) {
            c0060c = this.f3773g;
        }
        return c0060c;
    }

    public C0060c m6770i() {
        C0060c c0060c;
        synchronized (this.f3768b) {
            c0060c = this.f3788v;
        }
        return c0060c;
    }

    public AdSizeParcel m6771j() {
        AdSizeParcel adSizeParcel;
        synchronized (this.f3768b) {
            adSizeParcel = this.f3774h;
        }
        return adSizeParcel;
    }

    public hc m6772k() {
        return this.f3772f;
    }

    public boolean m6773l() {
        return this.f3775i;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.f3768b) {
            if (m6777p()) {
                C0099b.m5643d("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.f3768b) {
            if (m6777p()) {
                C0099b.m5643d("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.f3768b) {
            if (m6777p()) {
                C0099b.m5643d("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    C0099b.m5643d("Could not call loadUrl. " + th);
                }
            }
        }
    }

    public C0202f m6774m() {
        return this.f3769c;
    }

    public VersionInfoParcel m6775n() {
        return this.f3770d;
    }

    public boolean m6776o() {
        boolean z;
        synchronized (this.f3768b) {
            z = this.f3777k;
        }
        return z;
    }

    protected void onAttachedToWindow() {
        synchronized (this.f3768b) {
            super.onAttachedToWindow();
            if (!m6777p()) {
                this.f3789w.m6616c();
            }
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.f3768b) {
            if (!m6777p()) {
                this.f3789w.m6617d();
            }
            super.onDetachedFromWindow();
        }
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            C0056g.m5439c().m6533a(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            C0099b.m5636a("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!m6777p()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public void onGlobalLayout() {
        boolean x = m6785x();
        C0060c h = m6769h();
        if (h != null && x) {
            h.m5499o();
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        synchronized (this.f3768b) {
            if (m6777p()) {
                setMeasuredDimension(0, 0);
            } else if (isInEditMode() || this.f3777k || this.f3774h.f2917i || this.f3774h.f2918j) {
                super.onMeasure(i, i2);
            } else if (this.f3774h.f2913e) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.f3766C.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                int mode = MeasureSpec.getMode(i);
                int size = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                int size2 = MeasureSpec.getSize(i2);
                mode = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i3 = size2;
                }
                if (this.f3774h.f2915g > mode || this.f3774h.f2912d > r0) {
                    float f = this.f3767a.getResources().getDisplayMetrics().density;
                    C0099b.m5643d("Not enough space to show ad. Needs " + ((int) (((float) this.f3774h.f2915g) / f)) + "x" + ((int) (((float) this.f3774h.f2912d) / f)) + " dp, but only has " + ((int) (((float) size) / f)) + "x" + ((int) (((float) size2) / f)) + " dp.");
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                } else {
                    if (getVisibility() != 8) {
                        setVisibility(0);
                    }
                    setMeasuredDimension(this.f3774h.f2915g, this.f3774h.f2912d);
                }
            }
        }
    }

    public void onPause() {
        if (!m6777p()) {
            try {
                if (kn.m6932a()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                C0099b.m5640b("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!m6777p()) {
            try {
                if (kn.m6932a()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                C0099b.m5640b("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3769c != null) {
            this.f3769c.m6479a(motionEvent);
        }
        return m6777p() ? false : super.onTouchEvent(motionEvent);
    }

    public boolean m6777p() {
        boolean z;
        synchronized (this.f3768b) {
            z = this.f3776j;
        }
        return z;
    }

    public void m6778q() {
        synchronized (this.f3768b) {
            fp.m6505e("Destroying WebView!");
            fx.f3679a.post(new hl(this));
        }
    }

    public boolean m6779r() {
        boolean z;
        synchronized (this.f3768b) {
            aq.m6114a(this.f3786t.m6123a(), this.f3783q, "aebb");
            z = this.f3781o;
        }
        return z;
    }

    public ha m6780s() {
        return null;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f3787u = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof hc) {
            this.f3772f = (hc) webViewClient;
        }
    }

    public void stopLoading() {
        if (!m6777p()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                C0099b.m5640b("Could not stop loading webview.", e);
            }
        }
    }

    public av m6781t() {
        return this.f3785s;
    }

    public ay m6782u() {
        return this.f3786t;
    }

    public void m6783v() {
        this.f3789w.m6613a();
    }

    public void m6784w() {
        if (this.f3785s == null) {
            this.f3785s = aq.m6111a(this.f3786t.m6123a());
            this.f3786t.m6124a("native:view_load", this.f3785s);
        }
    }

    public boolean m6785x() {
        if (!m6772k().m6689b()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics a = C0056g.m5439c().m6521a(this.f3766C);
        int b = C0046n.m5409a().m5633b(a, a.widthPixels);
        int b2 = C0046n.m5409a().m5633b(a, a.heightPixels);
        Activity e = m6766e();
        if (e == null || e.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            int[] a2 = C0056g.m5439c().m6543a(e);
            i2 = C0046n.m5409a().m5633b(a, a2[0]);
            i = C0046n.m5409a().m5633b(a, a2[1]);
        }
        if (this.f3791y == b && this.f3790x == b2 && this.f3792z == i2 && this.f3764A == i) {
            return false;
        }
        boolean z = (this.f3791y == b && this.f3790x == b2) ? false : true;
        this.f3791y = b;
        this.f3790x = b2;
        this.f3792z = i2;
        this.f3764A = i;
        new ef(this).m6384a(b, b2, i2, i, a.density, this.f3766C.getDefaultDisplay().getRotation());
        return z;
    }

    Boolean m6786y() {
        Boolean bool;
        synchronized (this.f3768b) {
            bool = this.f3779m;
        }
        return bool;
    }
}
