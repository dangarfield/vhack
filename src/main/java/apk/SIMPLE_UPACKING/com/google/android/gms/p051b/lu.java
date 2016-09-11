package com.google.android.gms.p051b;

import com.google.android.gms.common.api.C0106g;
import com.google.android.gms.common.api.C0225a;
import com.google.android.gms.common.api.C0227i;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.C0392k;

/* renamed from: com.google.android.gms.b.lu */
public final class lu {
    public static final C0227i f3984a;
    public static final C0227i f3985b;
    public static final C0106g f3986c;
    static final C0106g f3987d;
    public static final Scope f3988e;
    public static final Scope f3989f;
    public static final C0225a f3990g;
    public static final C0225a f3991h;
    public static final ly f3992i;

    static {
        f3984a = new C0227i();
        f3985b = new C0227i();
        f3986c = new lv();
        f3987d = new lw();
        f3988e = new Scope("profile");
        f3989f = new Scope("email");
        f3990g = new C0225a("SignIn.API", f3986c, f3984a);
        f3991h = new C0225a("SignIn.INTERNAL_API", f3987d, f3985b);
        f3992i = new C0392k();
    }
}
