package com.google.android.gms.common.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.common.internal.l */
final class C0290l extends C0285g {
    final /* synthetic */ char[] f4439p;

    C0290l(char[] cArr) {
        this.f4439p = cArr;
    }

    public boolean m7911b(char c) {
        return Arrays.binarySearch(this.f4439p, c) >= 0;
    }
}
