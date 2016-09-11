package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.C0013a;
import com.google.android.gms.ads.C0016c;
import com.google.android.gms.ads.C0019f;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.ads.p048a.C0008a;
import com.google.android.gms.ads.p048a.C0010c;
import com.google.android.gms.ads.purchase.C0102b;
import com.google.android.gms.ads.purchase.C0103c;
import com.google.android.gms.p051b.bg;
import com.google.android.gms.p051b.fb;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.client.b */
public class C0029b {
    private C0013a f2936a;
    private C0027a f2937b;
    private C0048t f2938c;
    private C0016c[] f2939d;
    private String f2940e;
    private ViewGroup f2941f;
    private C0008a f2942g;
    private C0102b f2943h;
    private C0103c f2944i;
    private C0010c f2945j;
    private boolean f2946k;
    private C0019f f2947l;
    private boolean f2948m;

    private static AdSizeParcel m5359a(Context context, C0016c[] c0016cArr, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, c0016cArr);
        adSizeParcel.m5353a(z);
        return adSizeParcel;
    }

    public C0013a m5360a() {
        return this.f2936a;
    }

    public void m5361a(C0008a c0008a) {
        try {
            this.f2942g = c0008a;
            if (this.f2938c != null) {
                this.f2938c.m5418a(c0008a != null ? new C0044k(c0008a) : null);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to set the AppEventListener.", e);
        }
    }

    public void m5362a(C0010c c0010c) {
        this.f2945j = c0010c;
        try {
            if (this.f2938c != null) {
                this.f2938c.m5420a(c0010c != null ? new bg(c0010c) : null);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void m5363a(C0013a c0013a) {
        try {
            this.f2936a = c0013a;
            if (this.f2938c != null) {
                this.f2938c.m5417a(c0013a != null ? new C0038g(c0013a) : null);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to set the AdListener.", e);
        }
    }

    public void m5364a(C0019f c0019f) {
        this.f2947l = c0019f;
        try {
            if (this.f2938c != null) {
                this.f2938c.m5419a(this.f2947l == null ? null : this.f2947l.m5340a());
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to set correlator.", e);
        }
    }

    public void m5365a(C0027a c0027a) {
        try {
            this.f2937b = c0027a;
            if (this.f2938c != null) {
                this.f2938c.m5416a(c0027a != null ? new C0035f(c0027a) : null);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to set the AdClickListener.", e);
        }
    }

    public void m5366a(C0102b c0102b) {
        if (this.f2944i != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f2943h = c0102b;
            if (this.f2938c != null) {
                this.f2938c.m5421a(c0102b != null ? new fb(c0102b) : null);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m5367a(String str) {
        if (this.f2940e != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f2940e = str;
    }

    public void m5368a(boolean z) {
        this.f2946k = z;
        try {
            if (this.f2938c != null) {
                this.f2938c.m5422a(this.f2946k);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to set manual impressions.", e);
        }
    }

    public void m5369a(C0016c... c0016cArr) {
        if (this.f2939d != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m5371b(c0016cArr);
    }

    public C0016c m5370b() {
        try {
            if (this.f2938c != null) {
                AdSizeParcel a = this.f2938c.m5414a();
                if (a != null) {
                    return a.m5352a();
                }
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to get the current AdSize.", e);
        }
        return this.f2939d != null ? this.f2939d[0] : null;
    }

    public void m5371b(C0016c... c0016cArr) {
        this.f2939d = c0016cArr;
        try {
            if (this.f2938c != null) {
                this.f2938c.m5415a(C0029b.m5359a(this.f2941f.getContext(), this.f2939d, this.f2948m));
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to set the ad size.", e);
        }
        this.f2941f.requestLayout();
    }

    public C0016c[] m5372c() {
        return this.f2939d;
    }

    public String m5373d() {
        return this.f2940e;
    }

    public C0008a m5374e() {
        return this.f2942g;
    }

    public C0102b m5375f() {
        return this.f2943h;
    }

    public C0010c m5376g() {
        return this.f2945j;
    }

    public String m5377h() {
        try {
            if (this.f2938c != null) {
                return this.f2938c.m5423b();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }
}
