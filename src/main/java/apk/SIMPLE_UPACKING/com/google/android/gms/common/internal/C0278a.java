package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0273r;

/* renamed from: com.google.android.gms.common.internal.a */
public class C0278a extends aq {
    int f4366a;
    private Account f4367b;
    private Context f4368c;

    public static Account m7704a(ap apVar) {
        Account account = null;
        if (apVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = apVar.m7702a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account m7705a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f4366a) {
            return this.f4367b;
        }
        if (C0273r.m7660b(this.f4368c, callingUid)) {
            this.f4366a = callingUid;
            return this.f4367b;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof C0278a) ? false : this.f4367b.equals(((C0278a) obj).f4367b);
    }
}
