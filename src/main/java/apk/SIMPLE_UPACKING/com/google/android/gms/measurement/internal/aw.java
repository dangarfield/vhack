package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C0284f;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.je;

public final class aw {
    private final Object f4718a;
    private final je f4719b;
    private Object f4720c;
    private final String f4721d;

    private aw(String str, je jeVar, Object obj) {
        bf.m7873a((Object) jeVar);
        this.f4719b = jeVar;
        this.f4718a = obj;
        this.f4721d = str;
    }

    static aw m8480a(String str, int i) {
        return m8481a(str, i, i);
    }

    static aw m8481a(String str, int i, int i2) {
        return new aw(str, je.m6863a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static aw m8482a(String str, long j) {
        return m8483a(str, j, j);
    }

    static aw m8483a(String str, long j, long j2) {
        return new aw(str, je.m6864a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static aw m8484a(String str, String str2) {
        return m8485a(str, str2, str2);
    }

    static aw m8485a(String str, String str2, String str3) {
        return new aw(str, je.m6865a(str, str3), str2);
    }

    static aw m8486a(String str, boolean z) {
        return m8487a(str, z, z);
    }

    static aw m8487a(String str, boolean z, boolean z2) {
        return new aw(str, je.m6866a(str, z2), Boolean.valueOf(z));
    }

    public Object m8488a(Object obj) {
        return this.f4720c != null ? this.f4720c : obj == null ? (C0284f.f4420a && je.m6867b()) ? this.f4719b.m6871d() : this.f4718a : obj;
    }

    public String m8489a() {
        return this.f4721d;
    }

    public Object m8490b() {
        return this.f4720c != null ? this.f4720c : (C0284f.f4420a && je.m6867b()) ? this.f4719b.m6871d() : this.f4718a;
    }
}
