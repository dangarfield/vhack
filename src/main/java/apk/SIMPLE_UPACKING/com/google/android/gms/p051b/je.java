package com.google.android.gms.p051b;

import android.os.Binder;

/* renamed from: com.google.android.gms.b.je */
public abstract class je {
    private static final Object f3845c;
    private static jj f3846d;
    private static int f3847e;
    private static String f3848f;
    protected final String f3849a;
    protected final Object f3850b;
    private Object f3851g;

    static {
        f3845c = new Object();
        f3846d = null;
        f3847e = 0;
        f3848f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    }

    protected je(String str, Object obj) {
        this.f3851g = null;
        this.f3849a = str;
        this.f3850b = obj;
    }

    public static int m6862a() {
        return f3847e;
    }

    public static je m6863a(String str, Integer num) {
        return new jh(str, num);
    }

    public static je m6864a(String str, Long l) {
        return new jg(str, l);
    }

    public static je m6865a(String str, String str2) {
        return new ji(str, str2);
    }

    public static je m6866a(String str, boolean z) {
        return new jf(str, Boolean.valueOf(z));
    }

    public static boolean m6867b() {
        return f3846d != null;
    }

    protected abstract Object m6869a(String str);

    public final Object m6870c() {
        return this.f3851g != null ? this.f3851g : m6869a(this.f3849a);
    }

    public final Object m6871d() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Object c = m6870c();
            return c;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
