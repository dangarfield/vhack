package com.google.android.gms.p051b;

import android.content.Intent;

/* renamed from: com.google.android.gms.b.a */
public class C0194a extends lt {
    private Intent f3380b;

    public C0194a(fk fkVar) {
        super(fkVar);
    }

    public String getMessage() {
        return this.f3380b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
