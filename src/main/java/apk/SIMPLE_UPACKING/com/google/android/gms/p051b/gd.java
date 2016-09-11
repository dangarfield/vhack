package com.google.android.gms.p051b;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.b.gd */
class gd implements Callable {
    final /* synthetic */ Context f3686a;
    final /* synthetic */ gc f3687b;

    gd(gc gcVar, Context context) {
        this.f3687b = gcVar;
        this.f3686a = context;
    }

    public File m6585a() {
        return this.f3686a.getCacheDir();
    }

    public /* synthetic */ Object call() {
        return m6585a();
    }
}
