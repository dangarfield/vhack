package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.fn;
import com.google.android.gms.p051b.fx;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.h */
class C0065h extends fn {
    final /* synthetic */ C0060c f3043a;

    private C0065h(C0060c c0060c) {
        this.f3043a = c0060c;
    }

    public void m5506a() {
        Bitmap b = C0056g.m5439c().m6545b(this.f3045b.f3043a.f3030o, this.f3043a.f3017b.f3015q.f2882d);
        if (b != null) {
            fx.f3679a.post(new C0066i(this, C0056g.m5441e().m6557a(this.f3043a.f3030o, b, this.f3043a.f3017b.f3015q.f2883e, this.f3043a.f3017b.f3015q.f2884f)));
        }
    }
}
