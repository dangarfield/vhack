package com.google.android.gms.p051b;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.C0073p;
import com.google.android.gms.common.internal.bf;

@fi
/* renamed from: com.google.android.gms.b.ha */
public class ha {
    private final hb f3730a;
    private final Context f3731b;
    private final ViewGroup f3732c;
    private C0073p f3733d;

    public ha(Context context, ViewGroup viewGroup, hb hbVar) {
        this(context, viewGroup, hbVar, null);
    }

    ha(Context context, ViewGroup viewGroup, hb hbVar, C0073p c0073p) {
        this.f3731b = context;
        this.f3732c = viewGroup;
        this.f3730a = hbVar;
        this.f3733d = c0073p;
    }

    public C0073p m6626a() {
        bf.m7880b("getAdVideoUnderlay must be called from the UI thread.");
        return this.f3733d;
    }

    public void m6627a(int i, int i2, int i3, int i4) {
        bf.m7880b("The underlay may only be modified from the UI thread.");
        if (this.f3733d != null) {
            this.f3733d.m5534a(i, i2, i3, i4);
        }
    }

    public void m6628a(int i, int i2, int i3, int i4, int i5) {
        if (this.f3733d == null) {
            aq.m6114a(this.f3730a.m6662u().m6123a(), this.f3730a.m6661t(), "vpr");
            av a = aq.m6111a(this.f3730a.m6662u().m6123a());
            this.f3733d = new C0073p(this.f3731b, this.f3730a, i5, this.f3730a.m6662u().m6123a(), a);
            this.f3732c.addView(this.f3733d, 0, new LayoutParams(-1, -1));
            this.f3733d.m5534a(i, i2, i3, i4);
            this.f3730a.m6652k().m6685a(false);
        }
    }

    public void m6629b() {
        bf.m7880b("onPause must be called from the UI thread.");
        if (this.f3733d != null) {
            this.f3733d.m5538b();
        }
    }

    public void m6630c() {
        bf.m7880b("onDestroy must be called from the UI thread.");
        if (this.f3733d != null) {
            this.f3733d.m5543g();
        }
    }
}
