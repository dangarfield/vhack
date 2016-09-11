package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.C0171i;
import com.google.android.gms.common.api.C0106g;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0301t;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.auth.api.g */
final class C0137g extends C0106g {
    C0137g() {
    }

    public C0171i m5811a(Context context, Looper looper, C0301t c0301t, GoogleSignInOptions googleSignInOptions, C0229q c0229q, C0230r c0230r) {
        return new C0171i(context, looper, c0301t, googleSignInOptions, c0229q, c0230r);
    }

    public List m5813a(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.m5854a();
    }

    public /* synthetic */ List m5814a(Object obj) {
        return m5813a((GoogleSignInOptions) obj);
    }
}
