package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.p051b.ja;

/* renamed from: com.google.android.gms.auth.api.signin.internal.a */
class C0157a implements ja {
    final /* synthetic */ String f3312a;
    final /* synthetic */ SignInHubActivity f3313b;

    C0157a(SignInHubActivity signInHubActivity, String str) {
        this.f3313b = signInHubActivity;
        this.f3312a = str;
    }

    public void m5921a(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(this.f3312a)) {
                intent.putExtra("scopes", this.f3312a);
            }
            this.f3313b.m5912a(intent);
            return;
        }
        Log.w("AuthSignInClient", "Idp signin failed!");
        this.f3313b.m5909a(4);
    }
}
