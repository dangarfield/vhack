package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.hb;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.g */
public class C0064g {
    public final int f3036a;
    public final LayoutParams f3037b;
    public final ViewGroup f3038c;
    public final Context f3039d;

    public C0064g(hb hbVar) {
        this.f3037b = hbVar.getLayoutParams();
        ViewParent parent = hbVar.getParent();
        this.f3039d = hbVar.m6647f();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new C0062e("Could not get the parent of the WebView for an overlay.");
        }
        this.f3038c = (ViewGroup) parent;
        this.f3036a = this.f3038c.indexOfChild(hbVar.m6639b());
        this.f3038c.removeView(hbVar.m6639b());
        hbVar.m6638a(true);
    }
}
