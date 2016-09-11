package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0106g;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0226d;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0301t;
import com.google.android.gms.p051b.id;

/* renamed from: com.google.android.gms.auth.api.d */
final class C0134d extends C0106g {
    C0134d() {
    }

    public id m5805a(Context context, Looper looper, C0301t c0301t, C0226d c0226d, C0229q c0229q, C0230r c0230r) {
        return new id(context, looper, c0301t, c0229q, c0230r);
    }

    public /* synthetic */ C0121h m5806a(Context context, Looper looper, C0301t c0301t, Object obj, C0229q c0229q, C0230r c0230r) {
        return m5805a(context, looper, c0301t, (C0226d) obj, c0229q, c0230r);
    }
}
