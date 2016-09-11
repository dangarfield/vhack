package com.google.android.gms.p051b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;

/* renamed from: com.google.android.gms.b.jw */
public class jw extends C0122y {
    public jw(Context context, Looper looper, C0301t c0301t, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 39, c0301t, c0229q, c0230r);
    }

    protected ka m6899a(IBinder iBinder) {
        return kb.m6908a(iBinder);
    }

    public String m6900a() {
        return "com.google.android.gms.common.service.START";
    }

    protected /* synthetic */ IInterface m6901b(IBinder iBinder) {
        return m6899a(iBinder);
    }

    protected String m6902b() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
