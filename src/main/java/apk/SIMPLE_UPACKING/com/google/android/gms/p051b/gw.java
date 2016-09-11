package com.google.android.gms.p051b;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.C0056g;

@fi
/* renamed from: com.google.android.gms.b.gw */
public final class gw {
    private Activity f3720a;
    private boolean f3721b;
    private boolean f3722c;
    private boolean f3723d;
    private OnGlobalLayoutListener f3724e;
    private OnScrollChangedListener f3725f;

    public gw(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.f3720a = activity;
        this.f3724e = onGlobalLayoutListener;
        this.f3725f = onScrollChangedListener;
    }

    private void m6611e() {
        if (this.f3720a != null && !this.f3721b) {
            if (this.f3724e != null) {
                C0056g.m5439c().m6531a(this.f3720a, this.f3724e);
            }
            if (this.f3725f != null) {
                C0056g.m5439c().m6532a(this.f3720a, this.f3725f);
            }
            this.f3721b = true;
        }
    }

    private void m6612f() {
        if (this.f3720a != null && this.f3721b) {
            if (this.f3724e != null) {
                C0056g.m5441e().m6562a(this.f3720a, this.f3724e);
            }
            if (this.f3725f != null) {
                C0056g.m5439c().m6547b(this.f3720a, this.f3725f);
            }
            this.f3721b = false;
        }
    }

    public void m6613a() {
        this.f3723d = true;
        if (this.f3722c) {
            m6611e();
        }
    }

    public void m6614a(Activity activity) {
        this.f3720a = activity;
    }

    public void m6615b() {
        this.f3723d = false;
        m6612f();
    }

    public void m6616c() {
        this.f3722c = true;
        if (this.f3723d) {
            m6611e();
        }
    }

    public void m6617d() {
        this.f3722c = false;
        m6612f();
    }
}
