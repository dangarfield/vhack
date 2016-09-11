package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.C0025b;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p051b.an;
import com.google.android.gms.p051b.ek;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.hb;
import java.util.Collections;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.c */
public class C0060c extends ek implements C0059v {
    static final int f3016a;
    AdOverlayInfoParcel f3017b;
    hb f3018c;
    C0064g f3019d;
    C0076s f3020e;
    boolean f3021f;
    FrameLayout f3022g;
    CustomViewCallback f3023h;
    boolean f3024i;
    boolean f3025j;
    RelativeLayout f3026k;
    boolean f3027l;
    int f3028m;
    C0074q f3029n;
    private final Activity f3030o;
    private boolean f3031p;
    private boolean f3032q;
    private boolean f3033r;

    static {
        f3016a = Color.argb(0, 0, 0, 0);
    }

    public C0060c(Activity activity) {
        this.f3021f = false;
        this.f3024i = false;
        this.f3025j = false;
        this.f3027l = false;
        this.f3028m = 0;
        this.f3032q = false;
        this.f3033r = true;
        this.f3030o = activity;
        this.f3029n = new C0078u();
    }

    public void m5476a() {
        this.f3028m = 2;
        this.f3030o.finish();
    }

    public void m5477a(int i) {
        this.f3030o.setRequestedOrientation(i);
    }

    public void m5478a(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f3024i = z;
        try {
            this.f3017b = AdOverlayInfoParcel.m5449a(this.f3030o.getIntent());
            if (this.f3017b == null) {
                throw new C0062e("Could not get info for ad overlay.");
            }
            if (this.f3017b.f3012n.f3094d > 7500000) {
                this.f3028m = 3;
            }
            if (this.f3030o.getIntent() != null) {
                this.f3033r = this.f3030o.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.f3017b.f3015q != null) {
                this.f3025j = this.f3017b.f3015q.f2880b;
            } else {
                this.f3025j = false;
            }
            if (((Boolean) an.aE.m6093c()).booleanValue() && this.f3025j && this.f3017b.f3015q.f2882d != null) {
                new C0065h().m5505b();
            }
            if (bundle == null) {
                if (this.f3017b.f3002d != null && this.f3033r) {
                    this.f3017b.f3002d.m5514d();
                }
                if (!(this.f3017b.f3010l == 1 || this.f3017b.f3001c == null)) {
                    this.f3017b.f3001c.m5354a();
                }
            }
            this.f3026k = new C0063f(this.f3030o, this.f3017b.f3014p);
            this.f3026k.setId(1000);
            switch (this.f3017b.f3010l) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    m5486b(false);
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    this.f3019d = new C0064g(this.f3017b.f3003e);
                    m5486b(false);
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    m5486b(true);
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    if (this.f3024i) {
                        this.f3028m = 3;
                        this.f3030o.finish();
                    } else if (!C0056g.m5436a().m5458a(this.f3030o, this.f3017b.f3000b, this.f3017b.f3008j)) {
                        this.f3028m = 3;
                        this.f3030o.finish();
                    }
                default:
                    throw new C0062e("Could not determine ad overlay type.");
            }
        } catch (C0062e e) {
            C0099b.m5643d(e.getMessage());
            this.f3028m = 3;
            this.f3030o.finish();
        }
    }

    public void m5479a(View view, CustomViewCallback customViewCallback) {
        this.f3022g = new FrameLayout(this.f3030o);
        this.f3022g.setBackgroundColor(-16777216);
        this.f3022g.addView(view, -1, -1);
        this.f3030o.setContentView(this.f3022g);
        m5496l();
        this.f3023h = customViewCallback;
        this.f3021f = true;
    }

    public void m5480a(hb hbVar, Map map) {
        this.f3029n.m5546a(hbVar, map);
    }

    public void m5481a(boolean z) {
        this.f3020e = new C0076s(this.f3030o, z ? 50 : 32, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f3020e.m5552a(z, this.f3017b.f3006h);
        this.f3026k.addView(this.f3020e, layoutParams);
    }

    public void m5482a(boolean z, boolean z2) {
        if (this.f3020e != null) {
            this.f3020e.m5552a(z, z2);
        }
    }

    public void m5483b() {
        if (this.f3017b != null && this.f3021f) {
            m5477a(this.f3017b.f3009k);
        }
        if (this.f3022g != null) {
            this.f3030o.setContentView(this.f3026k);
            m5496l();
            this.f3022g.removeAllViews();
            this.f3022g = null;
        }
        if (this.f3023h != null) {
            this.f3023h.onCustomViewHidden();
            this.f3023h = null;
        }
        this.f3021f = false;
    }

    protected void m5484b(int i) {
        this.f3018c.m6632a(i);
    }

    public void m5485b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f3024i);
    }

    protected void m5486b(boolean z) {
        if (!this.f3031p) {
            this.f3030o.requestWindowFeature(1);
        }
        Window window = this.f3030o.getWindow();
        if (window == null) {
            throw new C0062e("Invalid activity, no window available.");
        }
        if (!this.f3025j || (this.f3017b.f3015q != null && this.f3017b.f3015q.f2881c)) {
            window.setFlags(1024, 1024);
        }
        boolean b = this.f3017b.f3003e.m6652k().m6689b();
        this.f3027l = false;
        if (b) {
            if (this.f3017b.f3009k == C0056g.m5441e().m6556a()) {
                this.f3027l = this.f3030o.getResources().getConfiguration().orientation == 1;
            } else if (this.f3017b.f3009k == C0056g.m5441e().m6569b()) {
                this.f3027l = this.f3030o.getResources().getConfiguration().orientation == 2;
            }
        }
        C0099b.m5636a("Delay onShow to next orientation change: " + this.f3027l);
        m5477a(this.f3017b.f3009k);
        if (C0056g.m5441e().m6567a(window)) {
            C0099b.m5636a("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.f3025j) {
            this.f3026k.setBackgroundColor(f3016a);
        } else {
            this.f3026k.setBackgroundColor(-16777216);
        }
        this.f3030o.setContentView(this.f3026k);
        m5496l();
        if (z) {
            this.f3018c = C0056g.m5440d().m6700a(this.f3030o, this.f3017b.f3003e.m6651j(), true, b, null, this.f3017b.f3012n, null, this.f3017b.f3003e.m6648g());
            this.f3018c.m6652k().m6679a(null, null, this.f3017b.f3004f, this.f3017b.f3008j, true, this.f3017b.f3013o, null, this.f3017b.f3003e.m6652k().m6676a(), null);
            this.f3018c.m6652k().m6683a(new C0061d(this));
            if (this.f3017b.f3011m != null) {
                this.f3018c.loadUrl(this.f3017b.f3011m);
            } else if (this.f3017b.f3007i != null) {
                this.f3018c.loadDataWithBaseURL(this.f3017b.f3005g, this.f3017b.f3007i, "text/html", "UTF-8", null);
            } else {
                throw new C0062e("No URL or HTML to display in ad overlay.");
            }
            if (this.f3017b.f3003e != null) {
                this.f3017b.f3003e.m6641b(this);
            }
        } else {
            this.f3018c = this.f3017b.f3003e;
            this.f3018c.m6633a(this.f3030o);
        }
        this.f3018c.m6635a(this);
        ViewParent parent = this.f3018c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f3018c.m6639b());
        }
        if (this.f3025j) {
            this.f3018c.setBackgroundColor(f3016a);
        }
        this.f3026k.addView(this.f3018c.m6639b(), -1, -1);
        if (!(z || this.f3027l)) {
            m5500p();
        }
        m5481a(b);
        if (this.f3018c.m6653l()) {
            m5482a(b, true);
        }
        C0025b g = this.f3018c.m6648g();
        C0075r c0075r = g != null ? g.f2887c : null;
        if (c0075r != null) {
            this.f3029n = c0075r.m5550a(this.f3030o, this.f3018c, this.f3026k);
        } else {
            C0099b.m5643d("Appstreaming controller is null.");
        }
    }

    public void m5487c() {
        this.f3028m = 1;
        this.f3030o.finish();
    }

    public void m5488d() {
        this.f3028m = 0;
    }

    public boolean m5489e() {
        boolean z = true;
        this.f3028m = 0;
        if (this.f3018c != null) {
            if (!(this.f3018c.m6659r() && this.f3029n.m5549d())) {
                z = false;
            }
            if (!z) {
                this.f3018c.m6637a("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void m5490f() {
    }

    public void m5491g() {
    }

    public void m5492h() {
        if (this.f3017b != null && this.f3017b.f3010l == 4) {
            if (this.f3024i) {
                this.f3028m = 3;
                this.f3030o.finish();
            } else {
                this.f3024i = true;
            }
        }
        if (this.f3017b.f3002d != null) {
            this.f3017b.f3002d.m5513c();
        }
        if (this.f3018c == null || this.f3018c.m6657p()) {
            C0099b.m5643d("The webview does not exit. Ignoring action.");
        } else {
            C0056g.m5441e().m6571b(this.f3018c);
        }
        this.f3029n.m5547b();
    }

    public void m5493i() {
        this.f3029n.m5545a();
        m5483b();
        if (this.f3017b.f3002d != null) {
            this.f3017b.f3002d.m5512b();
        }
        if (this.f3018c != null && (!this.f3030o.isFinishing() || this.f3019d == null)) {
            C0056g.m5441e().m6568a(this.f3018c);
        }
        m5498n();
    }

    public void m5494j() {
        m5498n();
    }

    public void m5495k() {
        if (this.f3018c != null) {
            this.f3026k.removeView(this.f3018c.m6639b());
        }
        m5498n();
    }

    public void m5496l() {
        this.f3031p = true;
    }

    public void m5497m() {
        this.f3026k.removeView(this.f3020e);
        m5481a(true);
    }

    protected void m5498n() {
        if (this.f3030o.isFinishing() && !this.f3032q) {
            this.f3032q = true;
            if (this.f3018c != null) {
                m5484b(this.f3028m);
                this.f3026k.removeView(this.f3018c.m6639b());
                if (this.f3019d != null) {
                    this.f3018c.m6633a(this.f3019d.f3039d);
                    this.f3018c.m6638a(false);
                    this.f3019d.f3038c.addView(this.f3018c.m6639b(), this.f3019d.f3036a, this.f3019d.f3037b);
                    this.f3019d = null;
                } else if (this.f3030o.getApplicationContext() != null) {
                    this.f3018c.m6633a(this.f3030o.getApplicationContext());
                }
                this.f3018c = null;
            }
            if (!(this.f3017b == null || this.f3017b.f3002d == null)) {
                this.f3017b.f3002d.m5511a();
            }
            this.f3029n.m5548c();
        }
    }

    public void m5499o() {
        if (this.f3027l) {
            this.f3027l = false;
            m5500p();
        }
    }

    protected void m5500p() {
        this.f3018c.m6645d();
    }
}
