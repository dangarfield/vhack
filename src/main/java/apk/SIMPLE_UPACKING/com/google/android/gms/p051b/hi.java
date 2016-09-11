package com.google.android.gms.p051b;

import android.content.Context;
import com.google.android.gms.ads.internal.C0025b;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@fi
/* renamed from: com.google.android.gms.b.hi */
public class hi {
    public hb m6700a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, C0202f c0202f, VersionInfoParcel versionInfoParcel, az azVar, C0025b c0025b) {
        hb hjVar = new hj(hk.m6742a(context, adSizeParcel, z, z2, c0202f, versionInfoParcel, azVar, c0025b));
        hjVar.setWebViewClient(C0056g.m5441e().m6558a(hjVar, z2));
        hjVar.setWebChromeClient(C0056g.m5441e().m6573c(hjVar));
        return hjVar;
    }
}
