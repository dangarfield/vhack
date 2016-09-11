package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.C0105a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.C0273r;
import com.google.android.gms.common.api.C0139c;
import com.google.android.gms.common.api.C0257n;
import com.google.android.gms.common.api.C0263o;

/* renamed from: com.google.android.gms.auth.api.signin.internal.v */
public class C0182v extends C0174l {
    private final Context f3347a;

    public C0182v(Context context) {
        this.f3347a = context;
    }

    private void m6047b() {
        if (!C0273r.m7660b(this.f3347a, Binder.getCallingUid())) {
            throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
        }
    }

    private void m6048c() {
        ac a = ac.m5929a(this.f3347a);
        GoogleSignInAccount a2 = a.m5931a();
        C0139c c0139c = GoogleSignInOptions.f3261d;
        if (a2 != null) {
            c0139c = a.m5937b();
        }
        C0257n b = new C0263o(this.f3347a).m7626a(C0105a.f3114j, c0139c).m7630b();
        try {
            if (b.m7564f().m7280b()) {
                if (a2 != null) {
                    C0105a.f3121q.m5877a(b);
                } else {
                    b.m7566h();
                }
            }
            b.m7565g();
        } catch (Throwable th) {
            b.m7565g();
        }
    }

    public void m6049a() {
        m6047b();
        m6048c();
    }
}
