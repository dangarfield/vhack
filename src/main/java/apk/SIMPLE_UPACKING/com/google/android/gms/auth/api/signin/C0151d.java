package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.bf;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.auth.api.signin.d */
public final class C0151d {
    private Set f3280a;
    private boolean f3281b;
    private boolean f3282c;
    private boolean f3283d;
    private String f3284e;
    private Account f3285f;
    private String f3286g;

    public C0151d() {
        this.f3280a = new HashSet();
    }

    public C0151d(GoogleSignInOptions googleSignInOptions) {
        this.f3280a = new HashSet();
        bf.m7873a((Object) googleSignInOptions);
        this.f3280a = new HashSet(googleSignInOptions.f3264f);
        this.f3281b = googleSignInOptions.f3267i;
        this.f3282c = googleSignInOptions.f3268j;
        this.f3283d = googleSignInOptions.f3266h;
        this.f3284e = googleSignInOptions.f3269k;
        this.f3285f = googleSignInOptions.f3265g;
        this.f3286g = googleSignInOptions.f3270l;
    }

    public C0151d m5879a() {
        this.f3280a.add(GoogleSignInOptions.f3260c);
        return this;
    }

    public C0151d m5880a(Scope scope, Scope... scopeArr) {
        this.f3280a.add(scope);
        this.f3280a.addAll(Arrays.asList(scopeArr));
        return this;
    }

    public C0151d m5881b() {
        this.f3280a.add(GoogleSignInOptions.f3258a);
        return this;
    }

    public GoogleSignInOptions m5882c() {
        if (this.f3283d && (this.f3285f == null || !this.f3280a.isEmpty())) {
            m5879a();
        }
        return new GoogleSignInOptions(this.f3285f, this.f3283d, this.f3281b, this.f3282c, this.f3284e, this.f3286g, null);
    }
}
