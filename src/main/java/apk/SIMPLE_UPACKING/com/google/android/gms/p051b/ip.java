package com.google.android.gms.p051b;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.C0105a;
import com.google.android.gms.auth.api.C0143i;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;

/* renamed from: com.google.android.gms.b.ip */
public final class ip extends C0122y {
    private final Bundle f3818d;

    public ip(Context context, Looper looper, C0301t c0301t, C0143i c0143i, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 16, c0301t, c0229q, c0230r);
        this.f3818d = c0143i == null ? new Bundle() : c0143i.m5816a();
    }

    protected iv m6814a(IBinder iBinder) {
        return iw.m6831a(iBinder);
    }

    protected String m6815a() {
        return "com.google.android.gms.auth.service.START";
    }

    protected /* synthetic */ IInterface m6816b(IBinder iBinder) {
        return m6814a(iBinder);
    }

    protected String m6817b() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    protected Bundle m6818c() {
        return this.f3818d;
    }

    public boolean m6819i() {
        C0301t p = m5766p();
        return (TextUtils.isEmpty(p.m7970a()) || p.m7971a(C0105a.f3111g).isEmpty()) ? false : true;
    }
}
