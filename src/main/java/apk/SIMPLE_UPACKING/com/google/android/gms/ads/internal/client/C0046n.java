package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.p052a.C0093d;
import com.google.android.gms.ads.internal.util.client.C0098a;
import com.google.android.gms.p051b.bn;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.client.n */
public class C0046n {
    private static final Object f2954a;
    private static C0046n f2955b;
    private final C0098a f2956c;
    private final C0039h f2957d;
    private final C0045l f2958e;
    private final C0030c f2959f;
    private final bn f2960g;
    private final C0093d f2961h;

    static {
        f2954a = new Object();
        C0046n.m5410a(new C0046n());
    }

    protected C0046n() {
        this.f2956c = new C0098a();
        this.f2957d = new C0039h();
        this.f2958e = new C0045l();
        this.f2959f = new C0030c();
        this.f2960g = new bn();
        this.f2961h = new C0093d();
    }

    public static C0098a m5409a() {
        return C0046n.m5412c().f2956c;
    }

    protected static void m5410a(C0046n c0046n) {
        synchronized (f2954a) {
            f2955b = c0046n;
        }
    }

    public static C0045l m5411b() {
        return C0046n.m5412c().f2958e;
    }

    private static C0046n m5412c() {
        C0046n c0046n;
        synchronized (f2954a) {
            c0046n = f2955b;
        }
        return c0046n;
    }
}
