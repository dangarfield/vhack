package com.google.android.gms.p051b;

import java.io.ByteArrayOutputStream;

/* renamed from: com.google.android.gms.b.b */
public class C0196b extends ByteArrayOutputStream {
    private final mq f3474a;

    public C0196b(mq mqVar, int i) {
        this.f3474a = mqVar;
        this.buf = this.f3474a.m7206a(Math.max(i, 256));
    }

    private void m6132a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f3474a.m7206a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f3474a.m7205a(this.buf);
            this.buf = a;
        }
    }

    public void close() {
        this.f3474a.m7205a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f3474a.m7205a(this.buf);
    }

    public synchronized void write(int i) {
        m6132a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m6132a(i2);
        super.write(bArr, i, i2);
    }
}
