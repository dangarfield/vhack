package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.an;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.c */
public class C0026c {
    private C0052d f2888a;
    private boolean f2889b;
    private boolean f2890c;

    public C0026c() {
        this.f2890c = ((Boolean) an.f3433i.m6093c()).booleanValue();
    }

    public C0026c(boolean z) {
        this.f2890c = z;
    }

    public void m5347a(String str) {
        C0099b.m5636a("Action was blocked because no click was detected.");
        if (this.f2888a != null) {
            this.f2888a.m5429a(str);
        }
    }

    public boolean m5348a() {
        return !this.f2890c || this.f2889b;
    }
}
