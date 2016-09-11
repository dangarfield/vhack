package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.kn;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.j */
public class C0067j {
    public void m5507a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.f3010l == 4 && adOverlayInfoParcel.f3002d == null) {
            if (adOverlayInfoParcel.f3001c != null) {
                adOverlayInfoParcel.f3001c.m5354a();
            }
            C0056g.m5436a().m5458a(context, adOverlayInfoParcel.f3000b, adOverlayInfoParcel.f3008j);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.f3012n.f3095e);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.m5450a(intent, adOverlayInfoParcel);
        if (!kn.m6940h()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        C0056g.m5439c().m6533a(context, intent);
    }
}
