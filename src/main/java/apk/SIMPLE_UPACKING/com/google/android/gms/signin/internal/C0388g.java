package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.az;

/* renamed from: com.google.android.gms.signin.internal.g */
public interface C0388g extends IInterface {
    void m8963a(int i);

    void m8964a(int i, Account account, C0250d c0250d);

    void m8965a(AuthAccountRequest authAccountRequest, C0250d c0250d);

    void m8966a(ResolveAccountRequest resolveAccountRequest, az azVar);

    void m8967a(ap apVar, int i, boolean z);

    void m8968a(CheckServerAuthResult checkServerAuthResult);

    void m8969a(RecordConsentRequest recordConsentRequest, C0250d c0250d);

    void m8970a(SignInRequest signInRequest, C0250d c0250d);

    void m8971a(C0250d c0250d);

    void m8972a(boolean z);
}
