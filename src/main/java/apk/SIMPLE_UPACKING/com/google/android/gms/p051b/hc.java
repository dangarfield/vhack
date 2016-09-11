package com.google.android.gms.p051b;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.p018b.R;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.C0026c;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.client.C0027a;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C0067j;
import com.google.android.gms.ads.internal.overlay.C0069l;
import com.google.android.gms.ads.internal.overlay.C0077t;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@fi
/* renamed from: com.google.android.gms.b.hc */
public class hc extends WebViewClient {
    private static final String[] f3734b;
    private static final String[] f3735c;
    protected hb f3736a;
    private final HashMap f3737d;
    private final Object f3738e;
    private C0027a f3739f;
    private C0069l f3740g;
    private he f3741h;
    private bq f3742i;
    private hf f3743j;
    private boolean f3744k;
    private cf f3745l;
    private ch f3746m;
    private boolean f3747n;
    private boolean f3748o;
    private C0077t f3749p;
    private final ee f3750q;
    private C0026c f3751r;
    private dv f3752s;
    private eg f3753t;
    private boolean f3754u;
    private boolean f3755v;
    private boolean f3756w;
    private int f3757x;

    static {
        f3734b = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
        f3735c = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    }

    public hc(hb hbVar, boolean z) {
        this(hbVar, z, new ee(hbVar, hbVar.m6647f(), new ad(hbVar.getContext())), null);
    }

    hc(hb hbVar, boolean z, ee eeVar, dv dvVar) {
        this.f3737d = new HashMap();
        this.f3738e = new Object();
        this.f3744k = false;
        this.f3736a = hbVar;
        this.f3747n = z;
        this.f3750q = eeVar;
        this.f3752s = dvVar;
    }

    private String m6666a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private void m6667a(Context context, String str, String str2, String str3) {
        if (((Boolean) an.ao.m6093c()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", m6666a(str3));
            C0056g.m5439c().m6536a(context, this.f3736a.m6655n().f3092b, "gmob-apps", bundle, true);
        }
    }

    private static boolean m6670b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m6673g() {
        synchronized (this.f3738e) {
            this.f3748o = true;
        }
        this.f3757x++;
        m6691d();
    }

    private void m6674h() {
        this.f3757x--;
        m6691d();
    }

    private void m6675i() {
        this.f3756w = true;
        m6691d();
    }

    public C0026c m6676a() {
        return this.f3751r;
    }

    public void m6677a(int i, int i2) {
        if (this.f3752s != null) {
            this.f3752s.m6403c(i, i2);
        }
    }

    public void m6678a(Uri uri) {
        String path = uri.getPath();
        List<ce> list = (List) this.f3737d.get(path);
        if (list != null) {
            Map a = C0056g.m5439c().m6528a(uri);
            if (C0099b.m5638a(2)) {
                fp.m6505e("Received GMSG: " + path);
                for (String path2 : a.keySet()) {
                    fp.m6505e("  " + path2 + ": " + ((String) a.get(path2)));
                }
            }
            for (ce a2 : list) {
                a2.m6165a(this.f3736a, a);
            }
            return;
        }
        fp.m6505e("No GMSG handler found for GMSG: " + uri);
    }

    public void m6679a(C0027a c0027a, C0069l c0069l, bq bqVar, C0077t c0077t, boolean z, cf cfVar, ch chVar, C0026c c0026c, eg egVar) {
        if (c0026c == null) {
            c0026c = new C0026c(false);
        }
        this.f3752s = new dv(this.f3736a, egVar);
        m6684a("/appEvent", new bp(bqVar));
        m6684a("/backButton", bs.f3495k);
        m6684a("/canOpenURLs", bs.f3486b);
        m6684a("/canOpenIntents", bs.f3487c);
        m6684a("/click", bs.f3488d);
        m6684a("/close", bs.f3489e);
        m6684a("/customClose", bs.f3491g);
        m6684a("/instrument", bs.f3498n);
        m6684a("/delayPageLoaded", new hh());
        m6684a("/httpTrack", bs.f3492h);
        m6684a("/log", bs.f3493i);
        m6684a("/mraid", new ci(c0026c, this.f3752s));
        m6684a("/mraidLoaded", this.f3750q);
        m6684a("/open", new cj(cfVar, c0026c, this.f3752s));
        m6684a("/precache", bs.f3497m);
        m6684a("/touch", bs.f3494j);
        m6684a("/video", bs.f3496l);
        m6684a("/appStreaming", bs.f3490f);
        if (chVar != null) {
            m6684a("/setInterstitialProperties", new cg(chVar));
        }
        this.f3739f = c0027a;
        this.f3740g = c0069l;
        this.f3742i = bqVar;
        this.f3745l = cfVar;
        this.f3749p = c0077t;
        this.f3751r = c0026c;
        this.f3753t = egVar;
        this.f3746m = chVar;
        m6685a(z);
    }

    public final void m6680a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        C0069l c0069l = null;
        boolean o = this.f3736a.m6656o();
        C0027a c0027a = (!o || this.f3736a.m6651j().f2913e) ? this.f3739f : null;
        if (!o) {
            c0069l = this.f3740g;
        }
        m6681a(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, c0027a, c0069l, this.f3749p, this.f3736a.m6655n()));
    }

    public void m6681a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean b = this.f3752s != null ? this.f3752s.m6402b() : false;
        C0067j b2 = C0056g.m5438b();
        Context context = this.f3736a.getContext();
        if (!b) {
            z = true;
        }
        b2.m5507a(context, adOverlayInfoParcel, z);
    }

    public void m6682a(hb hbVar) {
        this.f3736a = hbVar;
    }

    public void m6683a(he heVar) {
        this.f3741h = heVar;
    }

    public void m6684a(String str, ce ceVar) {
        synchronized (this.f3738e) {
            List list = (List) this.f3737d.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f3737d.put(str, list);
            }
            list.add(ceVar);
        }
    }

    public void m6685a(boolean z) {
        this.f3744k = z;
    }

    public final void m6686a(boolean z, int i) {
        C0027a c0027a = (!this.f3736a.m6656o() || this.f3736a.m6651j().f2913e) ? this.f3739f : null;
        m6681a(new AdOverlayInfoParcel(c0027a, this.f3740g, this.f3749p, this.f3736a, z, i, this.f3736a.m6655n()));
    }

    public final void m6687a(boolean z, int i, String str) {
        C0069l c0069l = null;
        boolean o = this.f3736a.m6656o();
        C0027a c0027a = (!o || this.f3736a.m6651j().f2913e) ? this.f3739f : null;
        if (!o) {
            c0069l = new hg(this.f3736a, this.f3740g);
        }
        m6681a(new AdOverlayInfoParcel(c0027a, c0069l, this.f3742i, this.f3749p, this.f3736a, z, i, str, this.f3736a.m6655n(), this.f3745l));
    }

    public final void m6688a(boolean z, int i, String str, String str2) {
        boolean o = this.f3736a.m6656o();
        C0027a c0027a = (!o || this.f3736a.m6651j().f2913e) ? this.f3739f : null;
        m6681a(new AdOverlayInfoParcel(c0027a, o ? null : new hg(this.f3736a, this.f3740g), this.f3742i, this.f3749p, this.f3736a, z, i, str, str2, this.f3736a.m6655n(), this.f3745l));
    }

    public boolean m6689b() {
        boolean z;
        synchronized (this.f3738e) {
            z = this.f3747n;
        }
        return z;
    }

    public void m6690c() {
        synchronized (this.f3738e) {
            fp.m6505e("Loading blank page in WebView, 2...");
            this.f3754u = true;
            this.f3736a.m6636a("about:blank");
        }
    }

    public final void m6691d() {
        if (this.f3741h != null && ((this.f3755v && this.f3757x <= 0) || this.f3756w)) {
            this.f3741h.m5501a(this.f3736a, !this.f3756w);
            this.f3741h = null;
        }
        this.f3736a.m6664w();
    }

    public final void m6692e() {
        synchronized (this.f3738e) {
            this.f3737d.clear();
            this.f3739f = null;
            this.f3740g = null;
            this.f3741h = null;
            this.f3742i = null;
            this.f3744k = false;
            this.f3747n = false;
            this.f3748o = false;
            this.f3745l = null;
            this.f3749p = null;
            this.f3743j = null;
            if (this.f3752s != null) {
                this.f3752s.m6399a(true);
                this.f3752s = null;
            }
        }
    }

    public final void m6693f() {
        synchronized (this.f3738e) {
            this.f3744k = false;
            this.f3747n = true;
            fx.m6516a(new hd(this));
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        fp.m6505e("Loading resource: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m6678a(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.f3738e) {
            if (this.f3754u) {
                fp.m6505e("Blank page loaded, 1...");
                this.f3736a.m6658q();
                return;
            }
            this.f3755v = true;
            m6691d();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= f3734b.length) ? String.valueOf(i) : f3734b[(-i) - 1];
        m6667a(this.f3736a.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= f3735c.length) ? String.valueOf(primaryError) : f3735c[primaryError];
            m6667a(this.f3736a.getContext(), "ssl_err", valueOf, C0056g.m5441e().m6560a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case R.AppCompatTheme_panelMenuListWidth /*79*/:
            case R.AppCompatTheme_colorControlNormal /*85*/:
            case R.AppCompatTheme_colorControlActivated /*86*/:
            case R.AppCompatTheme_colorControlHighlight /*87*/:
            case R.AppCompatTheme_colorButtonNormal /*88*/:
            case R.AppCompatTheme_colorSwitchThumbNormal /*89*/:
            case R.AppCompatTheme_controlBackground /*90*/:
            case R.AppCompatTheme_alertDialogStyle /*91*/:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        fp.m6505e("AdWebView shouldOverrideUrlLoading: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m6678a(parse);
        } else if (this.f3744k && webView == this.f3736a.m6631a() && hc.m6670b(parse)) {
            if (this.f3739f != null && ((Boolean) an.f3421W.m6093c()).booleanValue()) {
                this.f3739f.m5354a();
                this.f3739f = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (this.f3736a.m6631a().willNotDraw()) {
            C0099b.m5643d("AdWebView unable to handle URL: " + str);
        } else {
            Uri uri;
            try {
                C0202f m = this.f3736a.m6654m();
                if (m != null && m.m6481b(parse)) {
                    parse = m.m6477a(parse, this.f3736a.getContext());
                }
                uri = parse;
            } catch (C0203g e) {
                C0099b.m5643d("Unable to append parameter to URL: " + str);
                uri = parse;
            }
            if (this.f3751r == null || this.f3751r.m5348a()) {
                m6680a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.f3751r.m5347a(str);
            }
        }
        return true;
    }
}
