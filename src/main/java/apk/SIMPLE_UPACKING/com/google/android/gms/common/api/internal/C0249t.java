package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C0121h;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.gms.common.api.internal.t */
class C0249t extends C0246x {
    final /* synthetic */ C0242o f4266a;
    private final ArrayList f4267c;

    public C0249t(C0242o c0242o, ArrayList arrayList) {
        this.f4266a = c0242o;
        super(null);
        this.f4267c = arrayList;
    }

    public void m7525a() {
        this.f4266a.f4236a.f4179g.f4278d = this.f4266a.m7510j();
        Iterator it = this.f4267c.iterator();
        while (it.hasNext()) {
            ((C0121h) it.next()).m5718a(this.f4266a.f4250o, this.f4266a.f4236a.f4179g.f4278d);
        }
    }
}
