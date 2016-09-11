package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;

class bi implements Runnable {
    private final bh f4768a;
    private final int f4769b;
    private final Throwable f4770c;
    private final byte[] f4771d;
    private final String f4772e;

    private bi(String str, bh bhVar, int i, Throwable th, byte[] bArr) {
        bf.m7873a((Object) bhVar);
        this.f4768a = bhVar;
        this.f4769b = i;
        this.f4770c = th;
        this.f4771d = bArr;
        this.f4772e = str;
    }

    public void run() {
        this.f4768a.m8636a(this.f4772e, this.f4769b, this.f4770c, this.f4771d);
    }
}
