package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.ac;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0122y;
import com.google.android.gms.common.internal.C0301t;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.lz;
import com.google.android.gms.p051b.ma;

/* renamed from: com.google.android.gms.signin.internal.l */
public class C0393l extends C0122y implements lz {
    private final boolean f4974d;
    private final C0301t f4975e;
    private final Bundle f4976f;
    private Integer f4977g;

    public C0393l(Context context, Looper looper, boolean z, C0301t c0301t, Bundle bundle, C0229q c0229q, C0230r c0230r) {
        super(context, looper, 44, c0301t, c0229q, c0230r);
        this.f4974d = z;
        this.f4975e = c0301t;
        this.f4976f = bundle;
        this.f4977g = c0301t.m7981j();
    }

    public C0393l(Context context, Looper looper, boolean z, C0301t c0301t, ma maVar, C0229q c0229q, C0230r c0230r) {
        this(context, looper, z, c0301t, C0393l.m8987a(c0301t), c0229q, c0230r);
    }

    public static Bundle m8987a(C0301t c0301t) {
        ma i = c0301t.m7980i();
        Integer j = c0301t.m7981j();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c0301t.m7973b());
        if (j != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", j.intValue());
        }
        if (i != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", i.m7080a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", i.m7081b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", i.m7082c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", i.m7083d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", i.m7084e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", i.m7085f());
        }
        return bundle;
    }

    private ResolveAccountRequest m8988t() {
        Account c = this.f4975e.m7974c();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(c.name)) {
            googleSignInAccount = ac.m5929a(m5764n()).m5931a();
        }
        return new ResolveAccountRequest(c, this.f4977g.intValue(), googleSignInAccount);
    }

    protected C0388g m8989a(IBinder iBinder) {
        return C0389h.m8973a(iBinder);
    }

    protected String m8990a() {
        return "com.google.android.gms.signin.service.START";
    }

    public void m8991a(ap apVar, boolean z) {
        try {
            ((C0388g) m5768r()).m8967a(apVar, this.f4977g.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void m8992a(C0250d c0250d) {
        bf.m7874a((Object) c0250d, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((C0388g) m5768r()).m8970a(new SignInRequest(m8988t()), c0250d);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                c0250d.m7529a(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected /* synthetic */ IInterface m8993b(IBinder iBinder) {
        return m8989a(iBinder);
    }

    protected String m8994b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle m8995c() {
        if (!m5764n().getPackageName().equals(this.f4975e.m7978g())) {
            this.f4976f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f4975e.m7978g());
        }
        return this.f4976f;
    }

    public void m8996f() {
        try {
            ((C0388g) m5768r()).m8963a(this.f4977g.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public boolean m8997i() {
        return this.f4974d;
    }

    public void m8998k() {
        m5749a(new ae(this));
    }
}
