package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0106g;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0225a;
import com.google.android.gms.common.api.C0227i;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.internal.C0301t;
import com.google.android.gms.common.internal.C0302u;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p051b.lz;
import com.google.android.gms.signin.internal.SignInResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.common.api.internal.o */
public class C0242o implements ak {
    private final al f4236a;
    private final Lock f4237b;
    private final Context f4238c;
    private final C0268j f4239d;
    private ConnectionResult f4240e;
    private int f4241f;
    private int f4242g;
    private int f4243h;
    private final Bundle f4244i;
    private final Set f4245j;
    private lz f4246k;
    private int f4247l;
    private boolean f4248m;
    private boolean f4249n;
    private ap f4250o;
    private boolean f4251p;
    private boolean f4252q;
    private final C0301t f4253r;
    private final Map f4254s;
    private final C0106g f4255t;
    private ArrayList f4256u;

    public C0242o(al alVar, C0301t c0301t, Map map, C0268j c0268j, C0106g c0106g, Lock lock, Context context) {
        this.f4242g = 0;
        this.f4244i = new Bundle();
        this.f4245j = new HashSet();
        this.f4256u = new ArrayList();
        this.f4236a = alVar;
        this.f4253r = c0301t;
        this.f4254s = map;
        this.f4239d = c0268j;
        this.f4255t = c0106g;
        this.f4237b = lock;
        this.f4238c = context;
    }

    private void m7485a(SignInResponse signInResponse) {
        if (m7492b(0)) {
            ConnectionResult a = signInResponse.m8950a();
            if (a.m7280b()) {
                ResolveAccountResponse b = signInResponse.m8951b();
                ConnectionResult b2 = b.m7695b();
                if (b2.m7280b()) {
                    this.f4249n = true;
                    this.f4250o = b.m7694a();
                    this.f4251p = b.m7696c();
                    this.f4252q = b.m7697d();
                    m7500e();
                    return;
                }
                Log.wtf("GoogleApiClientConnecting", "Sign-in succeeded with resolve account failure: " + b2, new Exception());
                m7497c(b2);
            } else if (m7493b(a)) {
                m7507h();
                m7500e();
            } else {
                m7497c(a);
            }
        }
    }

    private void m7486a(boolean z) {
        if (this.f4246k != null) {
            if (this.f4246k.m5723h() && z) {
                this.f4246k.m7066f();
            }
            this.f4246k.m5722g();
            this.f4250o = null;
        }
    }

    private boolean m7487a(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || m7488a(connectionResult)) ? this.f4240e == null || i < this.f4241f : false;
    }

    private boolean m7488a(ConnectionResult connectionResult) {
        return connectionResult.m7279a() || this.f4239d.m7643b(connectionResult.m7281c()) != null;
    }

    private void m7491b(ConnectionResult connectionResult, C0225a c0225a, int i) {
        if (i != 2) {
            int a = c0225a.m7294a().m5650a();
            if (m7487a(a, i, connectionResult)) {
                this.f4240e = connectionResult;
                this.f4241f = a;
            }
        }
        this.f4236a.f4174b.put(c0225a.m7296c(), connectionResult);
    }

    private boolean m7492b(int i) {
        if (this.f4242g == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.f4236a.f4179g.m7607p());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + m7495c(this.f4242g) + " but received callback for step " + m7495c(i), new Exception());
        m7497c(new ConnectionResult(8, null));
        return false;
    }

    private boolean m7493b(ConnectionResult connectionResult) {
        return this.f4247l != 2 ? this.f4247l == 1 && !connectionResult.m7279a() : true;
    }

    private String m7495c(int i) {
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void m7497c(ConnectionResult connectionResult) {
        m7508i();
        m7486a(!connectionResult.m7279a());
        this.f4236a.m7376a(connectionResult);
        this.f4236a.f4180h.m7396a(connectionResult);
    }

    private boolean m7499d() {
        this.f4243h--;
        if (this.f4243h > 0) {
            return false;
        }
        if (this.f4243h < 0) {
            Log.i("GoogleApiClientConnecting", this.f4236a.f4179g.m7607p());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m7497c(new ConnectionResult(8, null));
            return false;
        } else if (this.f4240e == null) {
            return true;
        } else {
            this.f4236a.f4178f = this.f4241f;
            m7497c(this.f4240e);
            return false;
        }
    }

    private void m7500e() {
        if (this.f4243h == 0) {
            if (!this.f4248m || this.f4249n) {
                m7503f();
            }
        }
    }

    private void m7503f() {
        ArrayList arrayList = new ArrayList();
        this.f4242g = 1;
        this.f4243h = this.f4236a.f4173a.size();
        for (C0227i c0227i : this.f4236a.f4173a.keySet()) {
            if (!this.f4236a.f4174b.containsKey(c0227i)) {
                arrayList.add(this.f4236a.f4173a.get(c0227i));
            } else if (m7499d()) {
                m7505g();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f4256u.add(ao.m7393a().submit(new C0249t(this, arrayList)));
        }
    }

    private void m7505g() {
        this.f4236a.m7388h();
        ao.m7393a().execute(new C0243p(this));
        if (this.f4246k != null) {
            if (this.f4251p) {
                this.f4246k.m7064a(this.f4250o, this.f4252q);
            }
            m7486a(false);
        }
        for (C0227i c0227i : this.f4236a.f4174b.keySet()) {
            ((C0121h) this.f4236a.f4173a.get(c0227i)).m5722g();
        }
        this.f4236a.f4180h.m7395a(this.f4244i.isEmpty() ? null : this.f4244i);
    }

    private void m7507h() {
        this.f4248m = false;
        this.f4236a.f4179g.f4278d = Collections.emptySet();
        for (C0227i c0227i : this.f4245j) {
            if (!this.f4236a.f4174b.containsKey(c0227i)) {
                this.f4236a.f4174b.put(c0227i, new ConnectionResult(17, null));
            }
        }
    }

    private void m7508i() {
        Iterator it = this.f4256u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f4256u.clear();
    }

    private Set m7510j() {
        if (this.f4253r == null) {
            return Collections.emptySet();
        }
        Set hashSet = new HashSet(this.f4253r.m7975d());
        Map f = this.f4253r.m7977f();
        for (C0225a c0225a : f.keySet()) {
            if (!this.f4236a.f4174b.containsKey(c0225a.m7296c())) {
                hashSet.addAll(((C0302u) f.get(c0225a)).f4453a);
            }
        }
        return hashSet;
    }

    public C0167c m7513a(C0167c c0167c) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void m7514a() {
        this.f4236a.f4174b.clear();
        this.f4248m = false;
        this.f4240e = null;
        this.f4242g = 0;
        this.f4247l = 2;
        this.f4249n = false;
        this.f4251p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (C0225a c0225a : this.f4254s.keySet()) {
            C0121h c0121h = (C0121h) this.f4236a.f4173a.get(c0225a.m7296c());
            int intValue = ((Integer) this.f4254s.get(c0225a)).intValue();
            int i2 = (c0225a.m7294a().m5650a() == 1 ? 1 : 0) | i;
            if (c0121h.m5724i()) {
                this.f4248m = true;
                if (intValue < this.f4247l) {
                    this.f4247l = intValue;
                }
                if (intValue != 0) {
                    this.f4245j.add(c0225a.m7296c());
                }
            }
            hashMap.put(c0121h, new C0245q(this, c0225a, intValue));
            i = i2;
        }
        if (i != 0) {
            this.f4248m = false;
        }
        if (this.f4248m) {
            this.f4253r.m7972a(Integer.valueOf(this.f4236a.f4179g.m7608q()));
            C0229q c0255w = new C0255w();
            this.f4246k = (lz) this.f4255t.m5651a(this.f4238c, this.f4236a.f4179g.m7595c(), this.f4253r, this.f4253r.m7980i(), c0255w, c0255w);
        }
        this.f4243h = this.f4236a.f4173a.size();
        this.f4256u.add(ao.m7393a().submit(new C0247r(this, hashMap)));
    }

    public void m7515a(int i) {
        m7497c(new ConnectionResult(8, null));
    }

    public void m7516a(Bundle bundle) {
        if (m7492b(1)) {
            if (bundle != null) {
                this.f4244i.putAll(bundle);
            }
            if (m7499d()) {
                m7505g();
            }
        }
    }

    public void m7517a(ConnectionResult connectionResult, C0225a c0225a, int i) {
        if (m7492b(1)) {
            m7491b(connectionResult, c0225a, i);
            if (m7499d()) {
                m7505g();
            }
        }
    }

    public boolean m7518b() {
        m7508i();
        m7486a(true);
        this.f4236a.m7376a(null);
        return true;
    }

    public void m7519c() {
    }
}
