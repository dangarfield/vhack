package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;

public class bb extends C0122y {
    public bb(Context context, Looper looper, C0301t c0301t, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 93, c0301t, c0229q, c0230r);
    }

    public ax m8569a(IBinder iBinder) {
        return ay.m8497a(iBinder);
    }

    protected String m8570a() {
        return "com.google.android.gms.measurement.START";
    }

    public /* synthetic */ IInterface m8571b(IBinder iBinder) {
        return m8569a(iBinder);
    }

    protected String m8572b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
