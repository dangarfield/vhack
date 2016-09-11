package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.bf;

public final class bp {
    final /* synthetic */ bn f4812a;
    private final String f4813b;
    private final boolean f4814c;
    private boolean f4815d;
    private boolean f4816e;

    public bp(bn bnVar, String str, boolean z) {
        this.f4812a = bnVar;
        bf.m7875a(str);
        this.f4813b = str;
        this.f4814c = z;
    }

    private void m8659b() {
        if (!this.f4815d) {
            this.f4815d = true;
            this.f4816e = this.f4812a.f4807o.getBoolean(this.f4813b, this.f4814c);
        }
    }

    public void m8660a(boolean z) {
        Editor edit = this.f4812a.f4807o.edit();
        edit.putBoolean(this.f4813b, z);
        edit.apply();
        this.f4816e = z;
    }

    public boolean m8661a() {
        m8659b();
        return this.f4816e;
    }
}
