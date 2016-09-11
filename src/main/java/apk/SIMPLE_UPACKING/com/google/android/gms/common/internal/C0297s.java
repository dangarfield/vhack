package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.s */
class C0297s extends C0285g {
    List f4442p;

    C0297s(List list) {
        this.f4442p = list;
    }

    public C0285g m7920a(C0285g c0285g) {
        List arrayList = new ArrayList(this.f4442p);
        arrayList.add(bf.m7873a((Object) c0285g));
        return new C0297s(arrayList);
    }

    public boolean m7921b(char c) {
        for (C0285g b : this.f4442p) {
            if (b.m7902b(c)) {
                return true;
            }
        }
        return false;
    }
}
