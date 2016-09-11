package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.signin.internal.d */
public interface C0250d extends IInterface {
    void m7526a(ConnectionResult connectionResult, AuthAccountResult authAccountResult);

    void m7527a(Status status);

    void m7528a(Status status, GoogleSignInAccount googleSignInAccount);

    void m7529a(SignInResponse signInResponse);

    void m7530b(Status status);
}
