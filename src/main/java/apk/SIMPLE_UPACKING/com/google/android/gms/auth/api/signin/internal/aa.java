package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.C0188k;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;
import com.google.android.gms.common.internal.bf;

public class aa extends C0122y {
    private final C0188k f3314d;

    public aa(Context context, Looper looper, C0301t c0301t, C0188k c0188k, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 87, c0301t, c0229q, c0230r);
        this.f3314d = (C0188k) bf.m7873a((Object) c0188k);
    }

    protected C0176p m5922a(IBinder iBinder) {
        return C0177q.m6033a(iBinder);
    }

    protected String m5923a() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected /* synthetic */ IInterface m5924b(IBinder iBinder) {
        return m5922a(iBinder);
    }

    protected String m5925b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
