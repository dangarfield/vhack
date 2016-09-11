package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.C0057a;
import com.google.android.gms.ads.internal.overlay.C0067j;
import com.google.android.gms.ads.internal.p050a.C0022a;
import com.google.android.gms.ads.internal.purchase.C0086g;
import com.google.android.gms.p051b.aj;
import com.google.android.gms.p051b.ak;
import com.google.android.gms.p051b.al;
import com.google.android.gms.p051b.ap;
import com.google.android.gms.p051b.cp;
import com.google.android.gms.p051b.ct;
import com.google.android.gms.p051b.cy;
import com.google.android.gms.p051b.ff;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.fj;
import com.google.android.gms.p051b.fl;
import com.google.android.gms.p051b.fx;
import com.google.android.gms.p051b.fz;
import com.google.android.gms.p051b.gs;
import com.google.android.gms.p051b.hi;
import com.google.android.gms.p051b.kf;
import com.google.android.gms.p051b.kh;

@fi
/* renamed from: com.google.android.gms.ads.internal.g */
public class C0056g {
    private static final Object f2968a;
    private static C0056g f2969b;
    private final C0022a f2970c;
    private final C0057a f2971d;
    private final C0067j f2972e;
    private final ff f2973f;
    private final fx f2974g;
    private final hi f2975h;
    private final fz f2976i;
    private final fl f2977j;
    private final kf f2978k;
    private final ap f2979l;
    private final fj f2980m;
    private final ak f2981n;
    private final aj f2982o;
    private final al f2983p;
    private final C0086g f2984q;
    private final ct f2985r;
    private final gs f2986s;
    private final cy f2987t;
    private final C0054f f2988u;
    private final cp f2989v;

    static {
        f2968a = new Object();
        C0056g.m5437a(new C0056g());
    }

    protected C0056g() {
        this.f2970c = new C0022a();
        this.f2971d = new C0057a();
        this.f2972e = new C0067j();
        this.f2973f = new ff();
        this.f2974g = new fx();
        this.f2975h = new hi();
        this.f2976i = fz.m6555a(VERSION.SDK_INT);
        this.f2977j = new fl(this.f2974g);
        this.f2978k = new kh();
        this.f2979l = new ap();
        this.f2980m = new fj();
        this.f2981n = new ak();
        this.f2982o = new aj();
        this.f2983p = new al();
        this.f2984q = new C0086g();
        this.f2985r = new ct();
        this.f2986s = new gs();
        this.f2987t = new cy();
        this.f2988u = new C0054f();
        this.f2989v = new cp();
    }

    public static C0057a m5436a() {
        return C0056g.m5448l().f2971d;
    }

    protected static void m5437a(C0056g c0056g) {
        synchronized (f2968a) {
            f2969b = c0056g;
        }
    }

    public static C0067j m5438b() {
        return C0056g.m5448l().f2972e;
    }

    public static fx m5439c() {
        return C0056g.m5448l().f2974g;
    }

    public static hi m5440d() {
        return C0056g.m5448l().f2975h;
    }

    public static fz m5441e() {
        return C0056g.m5448l().f2976i;
    }

    public static fl m5442f() {
        return C0056g.m5448l().f2977j;
    }

    public static kf m5443g() {
        return C0056g.m5448l().f2978k;
    }

    public static aj m5444h() {
        return C0056g.m5448l().f2982o;
    }

    public static al m5445i() {
        return C0056g.m5448l().f2983p;
    }

    public static C0086g m5446j() {
        return C0056g.m5448l().f2984q;
    }

    public static cp m5447k() {
        return C0056g.m5448l().f2989v;
    }

    private static C0056g m5448l() {
        C0056g c0056g;
        synchronized (f2968a) {
            c0056g = f2969b;
        }
        return c0056g;
    }
}
