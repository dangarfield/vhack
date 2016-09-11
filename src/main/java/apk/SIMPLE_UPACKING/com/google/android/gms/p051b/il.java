package com.google.android.gms.p051b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;

/* renamed from: com.google.android.gms.b.il */
public class il extends C0122y {
    public il(Context context, Looper looper, C0301t c0301t, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 92, c0301t, c0229q, c0230r);
    }

    protected im m6807a(IBinder iBinder) {
        return in.m6812a(iBinder);
    }

    protected String m6808a() {
        return "com.google.android.gms.auth.api.consent.START";
    }

    protected /* synthetic */ IInterface m6809b(IBinder iBinder) {
        return m6807a(iBinder);
    }

    protected String m6810b() {
        return "com.google.android.gms.auth.api.consent.internal.IConsentService";
    }
}
