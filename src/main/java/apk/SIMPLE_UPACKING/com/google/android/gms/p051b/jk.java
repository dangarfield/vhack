package com.google.android.gms.p051b;

/* renamed from: com.google.android.gms.b.jk */
public class jk {
    public final Object f3852a;
    public final C0209l f3853b;
    public final lt f3854c;
    public boolean f3855d;

    private jk(lt ltVar) {
        this.f3855d = false;
        this.f3852a = null;
        this.f3853b = null;
        this.f3854c = ltVar;
    }

    private jk(Object obj, C0209l c0209l) {
        this.f3855d = false;
        this.f3852a = obj;
        this.f3853b = c0209l;
        this.f3854c = null;
    }

    public static jk m6884a(lt ltVar) {
        return new jk(ltVar);
    }

    public static jk m6885a(Object obj, C0209l c0209l) {
        return new jk(obj, c0209l);
    }

    public boolean m6886a() {
        return this.f3854c == null;
    }
}
