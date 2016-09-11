package com.google.android.gms.p051b;

import java.util.Comparator;

/* renamed from: com.google.android.gms.b.x */
class C0220x implements Comparator {
    final /* synthetic */ C0218v f4119a;

    C0220x(C0218v c0218v) {
        this.f4119a = c0218v;
    }

    public int m7270a(ac acVar, ac acVar2) {
        int i = acVar.f3386c - acVar2.f3386c;
        return i != 0 ? i : (int) (acVar.f3384a - acVar2.f3384a);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7270a((ac) obj, (ac) obj2);
    }
}
