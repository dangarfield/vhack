package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;

class as {
    final String f4686a;
    final String f4687b;
    final long f4688c;
    final long f4689d;
    final long f4690e;

    as(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        bf.m7875a(str);
        bf.m7875a(str2);
        bf.m7881b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        bf.m7881b(z);
        this.f4686a = str;
        this.f4687b = str2;
        this.f4688c = j;
        this.f4689d = j2;
        this.f4690e = j3;
    }

    as m8472a() {
        return new as(this.f4686a, this.f4687b, this.f4688c + 1, this.f4689d + 1, this.f4690e);
    }

    as m8473a(long j) {
        return new as(this.f4686a, this.f4687b, this.f4688c, this.f4689d, j);
    }
}
