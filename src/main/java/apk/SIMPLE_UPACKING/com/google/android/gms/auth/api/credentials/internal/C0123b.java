package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.C0142h;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;

/* renamed from: com.google.android.gms.auth.api.credentials.internal.b */
public final class C0123b extends C0122y {
    private final C0142h f3209d;

    public C0123b(Context context, Looper looper, C0301t c0301t, C0142h c0142h, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 68, c0301t, c0229q, c0230r);
        this.f3209d = c0142h;
    }

    protected C0129h m5770a(IBinder iBinder) {
        return C0130i.m5793a(iBinder);
    }

    protected String m5771a() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    protected /* synthetic */ IInterface m5772b(IBinder iBinder) {
        return m5770a(iBinder);
    }

    protected String m5773b() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    protected Bundle m5774c() {
        return this.f3209d == null ? new Bundle() : this.f3209d.m5815a();
    }
}
