package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.C0056g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@fi
/* renamed from: com.google.android.gms.b.cp */
public class cp implements Iterable {
    private final List f3531a;

    public cp() {
        this.f3531a = new LinkedList();
    }

    private cn m6244c(hb hbVar) {
        Iterator it = C0056g.m5447k().iterator();
        while (it.hasNext()) {
            cn cnVar = (cn) it.next();
            if (cnVar.f3527a == hbVar) {
                return cnVar;
            }
        }
        return null;
    }

    public void m6245a(cn cnVar) {
        this.f3531a.add(cnVar);
    }

    public boolean m6246a(hb hbVar) {
        cn c = m6244c(hbVar);
        if (c == null) {
            return false;
        }
        c.f3528b.m6252b();
        return true;
    }

    public void m6247b(cn cnVar) {
        this.f3531a.remove(cnVar);
    }

    public boolean m6248b(hb hbVar) {
        return m6244c(hbVar) != null;
    }

    public Iterator iterator() {
        return this.f3531a.iterator();
    }
}
