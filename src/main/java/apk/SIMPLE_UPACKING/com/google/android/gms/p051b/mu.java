package com.google.android.gms.p051b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/* renamed from: com.google.android.gms.b.mu */
class mu {
    public long f4074a;
    public String f4075b;
    public String f4076c;
    public long f4077d;
    public long f4078e;
    public long f4079f;
    public long f4080g;
    public Map f4081h;

    private mu() {
    }

    public mu(String str, C0209l c0209l) {
        this.f4075b = str;
        this.f4074a = (long) c0209l.f3883a.length;
        this.f4076c = c0209l.f3884b;
        this.f4077d = c0209l.f3885c;
        this.f4078e = c0209l.f3886d;
        this.f4079f = c0209l.f3887e;
        this.f4080g = c0209l.f3888f;
        this.f4081h = c0209l.f3889g;
    }

    public static mu m7227a(InputStream inputStream) {
        mu muVar = new mu();
        if (ms.m7208a(inputStream) != 538247942) {
            throw new IOException();
        }
        muVar.f4075b = ms.m7217c(inputStream);
        muVar.f4076c = ms.m7217c(inputStream);
        if (muVar.f4076c.equals("")) {
            muVar.f4076c = null;
        }
        muVar.f4077d = ms.m7216b(inputStream);
        muVar.f4078e = ms.m7216b(inputStream);
        muVar.f4079f = ms.m7216b(inputStream);
        muVar.f4080g = ms.m7216b(inputStream);
        muVar.f4081h = ms.m7219d(inputStream);
        return muVar;
    }

    public C0209l m7228a(byte[] bArr) {
        C0209l c0209l = new C0209l();
        c0209l.f3883a = bArr;
        c0209l.f3884b = this.f4076c;
        c0209l.f3885c = this.f4077d;
        c0209l.f3886d = this.f4078e;
        c0209l.f3887e = this.f4079f;
        c0209l.f3888f = this.f4080g;
        c0209l.f3889g = this.f4081h;
        return c0209l;
    }

    public boolean m7229a(OutputStream outputStream) {
        try {
            ms.m7210a(outputStream, 538247942);
            ms.m7212a(outputStream, this.f4075b);
            ms.m7212a(outputStream, this.f4076c == null ? "" : this.f4076c);
            ms.m7211a(outputStream, this.f4077d);
            ms.m7211a(outputStream, this.f4078e);
            ms.m7211a(outputStream, this.f4079f);
            ms.m7211a(outputStream, this.f4080g);
            ms.m7214a(this.f4081h, outputStream);
            outputStream.flush();
            return true;
        } catch (IOException e) {
            me.m7098b("%s", e.toString());
            return false;
        }
    }
}
