package com.google.android.gms.p051b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@fi
/* renamed from: com.google.android.gms.b.aj */
public class aj {
    private final Collection f3391a;
    private final Collection f3392b;
    private final Collection f3393c;

    public aj() {
        this.f3391a = new ArrayList();
        this.f3392b = new ArrayList();
        this.f3393c = new ArrayList();
    }

    public List m6102a() {
        List arrayList = new ArrayList();
        for (ae c : this.f3392b) {
            String str = (String) c.m6093c();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void m6103a(ae aeVar) {
        this.f3391a.add(aeVar);
    }

    public void m6104b(ae aeVar) {
        this.f3392b.add(aeVar);
    }

    public void m6105c(ae aeVar) {
        this.f3393c.add(aeVar);
    }
}
