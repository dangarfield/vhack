package com.google.android.gms.p051b;

import java.io.IOException;

/* renamed from: com.google.android.gms.b.mj */
public class mj extends IOException {
    mj(int i, int i2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
    }
}
