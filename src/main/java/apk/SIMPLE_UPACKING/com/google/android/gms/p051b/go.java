package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;

/* renamed from: com.google.android.gms.b.go */
class go implements jl {
    final /* synthetic */ String f3701a;
    final /* synthetic */ gr f3702b;
    final /* synthetic */ gm f3703c;

    go(gm gmVar, String str, gr grVar) {
        this.f3703c = gmVar;
        this.f3701a = str;
        this.f3702b = grVar;
    }

    public void m6603a(lt ltVar) {
        C0099b.m5643d("Failed to load URL: " + this.f3701a + "\n" + ltVar.toString());
        this.f3702b.m6608a(null);
    }
}
