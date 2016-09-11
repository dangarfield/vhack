package com.google.android.gms.p051b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;

/* renamed from: com.google.android.gms.b.id */
public class id extends C0122y {
    public id(Context context, Looper looper, C0301t c0301t, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 74, c0301t, c0229q, c0230r);
    }

    protected ih m6797a(IBinder iBinder) {
        return ii.m6805a(iBinder);
    }

    protected String m6798a() {
        return "com.google.android.gms.auth.api.accountstatus.START";
    }

    protected /* synthetic */ IInterface m6799b(IBinder iBinder) {
        return m6797a(iBinder);
    }

    protected String m6800b() {
        return "com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService";
    }
}
