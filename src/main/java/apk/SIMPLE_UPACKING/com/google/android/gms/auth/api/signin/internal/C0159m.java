package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.auth.api.signin.internal.m */
public interface C0159m extends IInterface {
    void m5951a(GoogleSignInAccount googleSignInAccount, Status status);

    void m5952a(Status status);

    void m5953a(Status status, SignInAccount signInAccount);

    void m5954a(Status status, String str, String str2, long j);

    void m5955b(Status status);

    void m5956c(Status status);
}
