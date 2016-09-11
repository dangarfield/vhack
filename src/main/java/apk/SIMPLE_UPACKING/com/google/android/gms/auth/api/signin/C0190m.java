package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.internal.bf;

/* renamed from: com.google.android.gms.auth.api.signin.m */
public class C0190m {
    private final SignInConfiguration f3357a;

    public C0190m(String str) {
        bf.m7875a(str);
        this.f3357a = new SignInConfiguration(str);
    }

    public C0188k m6054a() {
        boolean z = (this.f3357a.m5903c() == null && this.f3357a.m5904d() == null) ? false : true;
        bf.m7878a(z, (Object) "Must support either Facebook, Google or Email sign-in.");
        return new C0188k(null);
    }

    public C0190m m6055a(GoogleSignInOptions googleSignInOptions) {
        bf.m7873a((Object) googleSignInOptions);
        this.f3357a.m5900a(googleSignInOptions);
        return this;
    }
}
