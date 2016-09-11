package com.google.android.gms.p051b;

import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.C0026c;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.ci */
public class ci implements ce {
    static final Map f3514a;
    private final C0026c f3515b;
    private final dv f3516c;

    static {
        f3514a = kg.m6915a("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    }

    public ci(C0026c c0026c, dv dvVar) {
        this.f3515b = c0026c;
        this.f3516c = dvVar;
    }

    public void m6227a(hb hbVar, Map map) {
        int intValue = ((Integer) f3514a.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.f3515b == null || this.f3515b.m5348a()) {
            switch (intValue) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    this.f3516c.m6398a(map);
                    return;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    new dy(hbVar, map).m6409a();
                    return;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    new ds(hbVar, map).m6393a();
                    return;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    new dx(hbVar, map).m6405a();
                    return;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    this.f3516c.m6399a(true);
                    return;
                default:
                    C0099b.m5641c("Unknown MRAID command called.");
                    return;
            }
        }
        this.f3515b.m5347a(null);
    }
}
