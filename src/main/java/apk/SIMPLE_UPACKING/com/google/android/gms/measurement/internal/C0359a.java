package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* renamed from: com.google.android.gms.measurement.internal.a */
class C0359a implements Iterator {
    Iterator f4641a;
    final /* synthetic */ EventParams f4642b;

    C0359a(EventParams eventParams) {
        this.f4642b = eventParams;
        this.f4641a = this.f4642b.f4628b.keySet().iterator();
    }

    public String m8199a() {
        return (String) this.f4641a.next();
    }

    public boolean hasNext() {
        return this.f4641a.hasNext();
    }

    public /* synthetic */ Object next() {
        return m8199a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
