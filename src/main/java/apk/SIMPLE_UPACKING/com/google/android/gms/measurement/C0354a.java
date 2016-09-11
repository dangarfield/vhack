package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.bx;

/* renamed from: com.google.android.gms.measurement.a */
public class C0354a {
    private final bx f4606a;

    public C0354a(bx bxVar) {
        bf.m7873a((Object) bxVar);
        this.f4606a = bxVar;
    }

    public static C0354a m8183a(Context context) {
        return bx.m8735a(context).m8774m();
    }

    public void m8184a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f4606a.m8773l().m8838a(str, str2, bundle);
    }
}
