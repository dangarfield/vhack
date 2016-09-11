package com.google.android.gms.p051b;

import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: com.google.android.gms.b.mv */
class mv extends FilterInputStream {
    private int f4082a;

    private mv(InputStream inputStream) {
        super(inputStream);
        this.f4082a = 0;
    }

    public int read() {
        int read = super.read();
        if (read != -1) {
            this.f4082a++;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f4082a += read;
        }
        return read;
    }
}
