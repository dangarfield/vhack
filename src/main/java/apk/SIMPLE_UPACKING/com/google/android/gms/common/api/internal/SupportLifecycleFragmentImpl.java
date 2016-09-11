package com.google.android.gms.common.api.internal;

import android.content.DialogInterface.OnCancelListener;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.C0269b;
import com.google.android.gms.common.C0274e;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class SupportLifecycleFragmentImpl extends ax {
    protected /* synthetic */ C0268j m7330K() {
        return m7331a();
    }

    protected C0269b m7331a() {
        return C0269b.m7645a();
    }

    protected void m7332a(int i, ConnectionResult connectionResult) {
        C0274e.m7675a(connectionResult.m7281c(), m1173g(), this, 2, this);
    }

    protected void m7333b(int i, ConnectionResult connectionResult) {
        this.a = ap.m7334a(m1173g().getApplicationContext(), new C0228a(this, m7331a().m7647a(m1173g(), (OnCancelListener) this)));
    }
}
