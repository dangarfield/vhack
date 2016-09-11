package com.google.android.gms.p051b;

import java.security.MessageDigest;

@fi
/* renamed from: com.google.android.gms.b.aa */
public class aa extends C0195u {
    private MessageDigest f3383b;

    byte m6068a(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    public byte[] m6069a(String str) {
        byte[] a = m6070a(str.split(" "));
        this.f3383b = m6066a();
        synchronized (this.a) {
            if (this.f3383b == null) {
                a = new byte[0];
            } else {
                this.f3383b.reset();
                this.f3383b.update(a);
                Object digest = this.f3383b.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                a = new byte[i];
                System.arraycopy(digest, 0, a, 0, a.length);
            }
        }
        return a;
    }

    byte[] m6070a(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = m6068a(C0222z.m7272a(strArr[i]));
        }
        return bArr;
    }
}
