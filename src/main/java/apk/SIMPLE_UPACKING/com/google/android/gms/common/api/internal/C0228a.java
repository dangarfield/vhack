package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* renamed from: com.google.android.gms.common.api.internal.a */
class C0228a extends ap {
    final /* synthetic */ Dialog f4155a;
    final /* synthetic */ SupportLifecycleFragmentImpl f4156b;

    C0228a(SupportLifecycleFragmentImpl supportLifecycleFragmentImpl, Dialog dialog) {
        this.f4156b = supportLifecycleFragmentImpl;
        this.f4155a = dialog;
    }

    protected void m7338a() {
        this.f4156b.m7319L();
        this.f4155a.dismiss();
    }
}
