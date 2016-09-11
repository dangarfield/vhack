package com.google.android.gms.p051b;

/* renamed from: com.google.android.gms.b.ac */
public class ac {
    final long f3384a;
    final String f3385b;
    final int f3386c;

    ac(long j, String str, int i) {
        this.f3384a = j;
        this.f3385b = str;
        this.f3386c = i;
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof ac)) ? false : ((ac) obj).f3384a == this.f3384a && ((ac) obj).f3386c == this.f3386c;
    }

    public int hashCode() {
        return (int) this.f3384a;
    }
}
