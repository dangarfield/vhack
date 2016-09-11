package com.google.android.gms.common;

import com.google.android.gms.common.internal.bf;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.common.l */
abstract class C0307l {
    private int f4459a;

    protected C0307l(byte[] bArr) {
        bf.m7882b(bArr.length == 25, "cert hash data has incorrect length");
        this.f4459a = Arrays.hashCode(bArr);
    }

    protected static byte[] m7988a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    abstract byte[] m7989a();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0307l)) {
            return false;
        }
        return Arrays.equals(m7989a(), ((C0307l) obj).m7989a());
    }

    public int hashCode() {
        return this.f4459a;
    }
}
