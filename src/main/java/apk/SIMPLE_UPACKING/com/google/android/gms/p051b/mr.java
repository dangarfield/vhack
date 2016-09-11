package com.google.android.gms.p051b;

import java.util.Comparator;

/* renamed from: com.google.android.gms.b.mr */
final class mr implements Comparator {
    mr() {
    }

    public int m7207a(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7207a((byte[]) obj, (byte[]) obj2);
    }
}
