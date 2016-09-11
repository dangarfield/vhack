package com.google.android.gms.ads.internal;

import android.app.Activity;
import com.google.android.gms.ads.internal.client.C0023m;
import com.google.android.gms.ads.internal.client.C0045l;
import com.google.android.gms.ads.internal.overlay.C0060c;
import com.google.android.gms.ads.internal.purchase.C0082c;
import com.google.android.gms.p051b.ej;
import com.google.android.gms.p051b.ev;

/* renamed from: com.google.android.gms.ads.internal.a */
public class C0024a implements C0023m {
    public static void m5344a() {
        C0045l.f2952a = C0024a.class.getName();
    }

    public ev m5345a(Activity activity) {
        return new C0082c(activity);
    }

    public ej m5346b(Activity activity) {
        return new C0060c(activity);
    }
}
