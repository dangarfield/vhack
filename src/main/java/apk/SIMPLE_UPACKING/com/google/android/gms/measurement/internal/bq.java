package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.bf;

public final class bq {
    final /* synthetic */ bn f4817a;
    private final String f4818b;
    private final long f4819c;
    private boolean f4820d;
    private long f4821e;

    public bq(bn bnVar, String str, long j) {
        this.f4817a = bnVar;
        bf.m7875a(str);
        this.f4818b = str;
        this.f4819c = j;
    }

    private void m8662b() {
        if (!this.f4820d) {
            this.f4820d = true;
            this.f4821e = this.f4817a.f4807o.getLong(this.f4818b, this.f4819c);
        }
    }

    public long m8663a() {
        m8662b();
        return this.f4821e;
    }

    public void m8664a(long j) {
        Editor edit = this.f4817a.f4807o.edit();
        edit.putLong(this.f4818b, j);
        edit.apply();
        this.f4821e = j;
    }
}
