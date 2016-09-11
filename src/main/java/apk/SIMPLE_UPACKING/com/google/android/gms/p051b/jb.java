package com.google.android.gms.p051b;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.C0155h;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.common.internal.bf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.b.jb */
public abstract class jb implements iz {
    protected final Activity f3833a;
    protected final Set f3834b;
    private String f3835c;
    private String f3836d;
    private ja f3837e;

    protected jb(Activity activity, List list, List list2) {
        this.f3833a = (Activity) bf.m7873a((Object) activity);
        Set hashSet = new HashSet((Collection) bf.m7873a((Object) list));
        hashSet.addAll((Collection) bf.m7873a((Object) list2));
        this.f3834b = Collections.unmodifiableSet(hashSet);
    }

    protected Intent m6843a(IdpTokenType idpTokenType, String str, String str2) {
        bf.m7873a((Object) idpTokenType);
        bf.m7875a(str);
        Intent intent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent.putExtra("idpTokenType", idpTokenType);
        intent.putExtra("idpToken", str);
        intent.putExtra("pendingToken", str2);
        C0155h a = m6834a();
        if (a != null) {
            intent.putExtra("idProvider", a.m5894a());
        }
        return intent;
    }

    protected void m6844a(String str) {
        this.f3835c = str;
    }

    protected Set m6845b() {
        return this.f3834b;
    }

    protected void m6846b(ja jaVar) {
        this.f3837e = (ja) bf.m7873a((Object) jaVar);
    }

    protected void m6847b(String str) {
        this.f3836d = str;
    }

    protected void m6848b(String str, String str2, ja jaVar) {
        m6844a(str);
        m6847b(str2);
        m6846b(jaVar);
    }

    protected ja m6849c() {
        return this.f3837e;
    }

    protected String m6850d() {
        return this.f3836d;
    }
}
