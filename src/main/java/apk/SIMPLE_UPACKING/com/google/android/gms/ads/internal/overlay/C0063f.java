package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.gj;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.f */
final class C0063f extends RelativeLayout {
    gj f3035a;

    public C0063f(Context context, String str) {
        super(context);
        this.f3035a = new gj(context, str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f3035a.m6599a(motionEvent);
        return false;
    }
}
