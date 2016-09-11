package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* renamed from: com.google.android.gms.ads.internal.overlay.i */
class C0066i implements Runnable {
    final /* synthetic */ Drawable f3044a;
    final /* synthetic */ C0065h f3045b;

    C0066i(C0065h c0065h, Drawable drawable) {
        this.f3045b = c0065h;
        this.f3044a = drawable;
    }

    public void run() {
        this.f3045b.f3043a.f3030o.getWindow().setBackgroundDrawable(this.f3044a);
    }
}
