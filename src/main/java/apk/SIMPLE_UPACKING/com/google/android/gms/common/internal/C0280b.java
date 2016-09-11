package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.api.C0259j;

/* renamed from: com.google.android.gms.common.internal.b */
public class C0280b extends C0122y {
    private final C0259j f4416d;

    public C0280b(Context context, Looper looper, int i, C0229q c0229q, C0230r c0230r, C0301t c0301t, C0259j c0259j) {
        super(context, looper, i, c0301t, c0229q, c0230r);
        this.f4416d = c0259j;
    }

    protected String m7863a() {
        return this.f4416d.m7610a();
    }

    protected void m7864a(int i, IInterface iInterface) {
        this.f4416d.m7611a(i, iInterface);
    }

    protected IInterface m7865b(IBinder iBinder) {
        return this.f4416d.m7609a(iBinder);
    }

    protected String m7866b() {
        return this.f4416d.m7612b();
    }
}
