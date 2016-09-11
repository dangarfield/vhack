package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Iterator;
import java.util.List;

@fi
/* renamed from: com.google.android.gms.b.n */
public class C0211n {
    private final Object f4084a;
    private int f4085b;
    private List f4086c;

    public boolean m7241a(C0210m c0210m) {
        boolean z;
        synchronized (this.f4084a) {
            if (this.f4086c.contains(c0210m)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean m7242b(C0210m c0210m) {
        boolean z;
        synchronized (this.f4084a) {
            Iterator it = this.f4086c.iterator();
            while (it.hasNext()) {
                C0210m c0210m2 = (C0210m) it.next();
                if (c0210m != c0210m2 && c0210m2.m7074b().equals(c0210m.m7074b())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public void m7243c(C0210m c0210m) {
        synchronized (this.f4084a) {
            if (this.f4086c.size() >= 10) {
                C0099b.m5636a("Queue is full, current size = " + this.f4086c.size());
                this.f4086c.remove(0);
            }
            int i = this.f4085b;
            this.f4085b = i + 1;
            c0210m.m7071a(i);
            this.f4086c.add(c0210m);
        }
    }
}
