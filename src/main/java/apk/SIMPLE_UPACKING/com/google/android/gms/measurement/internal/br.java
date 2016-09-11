package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.bf;

public final class br {
    final String f4822a;
    final /* synthetic */ bn f4823b;
    private final String f4824c;
    private final String f4825d;
    private final long f4826e;

    private br(bn bnVar, String str, long j) {
        this.f4823b = bnVar;
        bf.m7875a(str);
        bf.m7881b(j > 0);
        this.f4822a = str + ":start";
        this.f4824c = str + ":count";
        this.f4825d = str + ":value";
        this.f4826e = j;
    }

    private void m8665b() {
        this.f4823b.m8207f();
        long a = this.f4823b.m8213l().m6913a();
        Editor edit = this.f4823b.f4807o.edit();
        edit.remove(this.f4824c);
        edit.remove(this.f4825d);
        edit.putLong(this.f4822a, a);
        edit.apply();
    }

    private long m8666c() {
        this.f4823b.m8207f();
        long d = m8667d();
        if (d != 0) {
            return Math.abs(d - this.f4823b.m8213l().m6913a());
        }
        m8665b();
        return 0;
    }

    private long m8667d() {
        return this.f4823b.m8648y().getLong(this.f4822a, 0);
    }

    public Pair m8668a() {
        this.f4823b.m8207f();
        long c = m8666c();
        if (c < this.f4826e) {
            return null;
        }
        if (c > this.f4826e * 2) {
            m8665b();
            return null;
        }
        String string = this.f4823b.m8648y().getString(this.f4825d, null);
        c = this.f4823b.m8648y().getLong(this.f4824c, 0);
        m8665b();
        return (string == null || c <= 0) ? bn.f4794a : new Pair(string, Long.valueOf(c));
    }

    public void m8669a(String str) {
        m8670a(str, 1);
    }

    public void m8670a(String str, long j) {
        this.f4823b.m8207f();
        if (m8667d() == 0) {
            m8665b();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.f4823b.f4807o.getLong(this.f4824c, 0);
        if (j2 <= 0) {
            Editor edit = this.f4823b.f4807o.edit();
            edit.putString(this.f4825d, str);
            edit.putLong(this.f4824c, j);
            edit.apply();
            return;
        }
        Object obj = (this.f4823b.f4811s.nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
        Editor edit2 = this.f4823b.f4807o.edit();
        if (obj != null) {
            edit2.putString(this.f4825d, str);
        }
        edit2.putLong(this.f4824c, j2 + j);
        edit2.apply();
    }
}
