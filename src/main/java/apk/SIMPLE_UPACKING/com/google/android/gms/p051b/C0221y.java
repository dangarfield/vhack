package com.google.android.gms.p051b;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.android.gms.b.y */
class C0221y {
    ByteArrayOutputStream f4120a;
    Base64OutputStream f4121b;

    public C0221y() {
        this.f4120a = new ByteArrayOutputStream(4096);
        this.f4121b = new Base64OutputStream(this.f4120a, 10);
    }

    public void m7271a(byte[] bArr) {
        this.f4121b.write(bArr);
    }

    public String toString() {
        String byteArrayOutputStream;
        try {
            this.f4121b.close();
        } catch (Throwable e) {
            C0099b.m5640b("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.f4120a.close();
            byteArrayOutputStream = this.f4120a.toString();
        } catch (Throwable e2) {
            C0099b.m5640b("HashManager: Unable to convert to Base64.", e2);
            byteArrayOutputStream = "";
        } finally {
            this.f4120a = null;
            this.f4121b = null;
        }
        return byteArrayOutputStream;
    }
}
