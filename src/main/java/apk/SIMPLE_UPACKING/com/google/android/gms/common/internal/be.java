package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class be {
    private final List f4418a;
    private final Object f4419b;

    private be(Object obj) {
        this.f4419b = bf.m7873a(obj);
        this.f4418a = new ArrayList();
    }

    public be m7872a(String str, Object obj) {
        this.f4418a.add(((String) bf.m7873a((Object) str)) + "=" + String.valueOf(obj));
        return this;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(100).append(this.f4419b.getClass().getSimpleName()).append('{');
        int size = this.f4418a.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.f4418a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
