package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.C0151d;
import com.google.android.gms.auth.api.signin.C0190m;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;

/* renamed from: com.google.android.gms.auth.api.signin.internal.i */
public class C0171i extends C0122y {
    private final GoogleSignInOptions f3341d;

    public C0171i(Context context, Looper looper, C0301t c0301t, GoogleSignInOptions googleSignInOptions, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 91, c0301t, c0229q, c0230r);
        if (googleSignInOptions == null) {
            googleSignInOptions = new C0151d().m5882c();
        }
        if (!c0301t.m7976e().isEmpty()) {
            C0151d c0151d = new C0151d(googleSignInOptions);
            for (Scope a : c0301t.m7976e()) {
                c0151d.m5880a(a, new Scope[0]);
            }
            googleSignInOptions = c0151d.m5882c();
        }
        this.f3341d = googleSignInOptions;
    }

    protected C0176p m6010a(IBinder iBinder) {
        return C0177q.m6033a(iBinder);
    }

    protected String m6011a() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected /* synthetic */ IInterface m6012b(IBinder iBinder) {
        return m6010a(iBinder);
    }

    protected String m6013b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public boolean m6014d() {
        return true;
    }

    public Intent m6015e() {
        Parcelable a = new C0190m(m5764n().getPackageName()).m6055a(this.f3341d).m6054a().m6053a();
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(m5764n(), SignInHubActivity.class);
        intent.putExtra("config", a);
        return intent;
    }

    public GoogleSignInOptions m6016f() {
        return this.f3341d;
    }
}
