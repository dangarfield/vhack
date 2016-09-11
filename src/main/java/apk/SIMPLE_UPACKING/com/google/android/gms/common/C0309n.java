package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.n */
abstract class C0309n extends C0307l {
    private static final WeakReference f4461b;
    private WeakReference f4462a;

    static {
        f4461b = new WeakReference(null);
    }

    C0309n(byte[] bArr) {
        super(bArr);
        this.f4462a = f4461b;
    }

    byte[] m7991a() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f4462a.get();
            if (bArr == null) {
                bArr = m7992b();
                this.f4462a = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] m7992b();
}
