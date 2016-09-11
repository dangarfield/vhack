package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p014g.ArrayMap;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0106g;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0225a;
import com.google.android.gms.common.api.C0227i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0301t;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.common.api.internal.h */
public class C0235h implements aq {
    private final Context f4215a;
    private final C0258z f4216b;
    private final Looper f4217c;
    private final al f4218d;
    private final al f4219e;
    private final Map f4220f;
    private final Set f4221g;
    private final C0121h f4222h;
    private Bundle f4223i;
    private ConnectionResult f4224j;
    private ConnectionResult f4225k;
    private boolean f4226l;
    private final Lock f4227m;
    private int f4228n;

    public C0235h(Context context, C0258z c0258z, Lock lock, Looper looper, C0268j c0268j, Map map, C0301t c0301t, Map map2, C0106g c0106g, ArrayList arrayList) {
        this.f4220f = new ArrayMap();
        this.f4221g = Collections.newSetFromMap(new WeakHashMap());
        this.f4224j = null;
        this.f4225k = null;
        this.f4226l = false;
        this.f4228n = 0;
        this.f4215a = context;
        this.f4216b = c0258z;
        this.f4227m = lock;
        this.f4217c = looper;
        C0121h c0121h = null;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        for (C0227i c0227i : map.keySet()) {
            C0121h c0121h2 = (C0121h) map.get(c0227i);
            if (c0121h2.m5720d()) {
                c0121h = c0121h2;
            }
            if (c0121h2.m5724i()) {
                arrayMap.put(c0227i, c0121h2);
            } else {
                arrayMap2.put(c0227i, c0121h2);
            }
        }
        this.f4222h = c0121h;
        if (arrayMap.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (C0225a c0225a : map2.keySet()) {
            C0227i c = c0225a.m7296c();
            if (arrayMap.containsKey(c)) {
                arrayMap3.put(c0225a, map2.get(c0225a));
            } else if (arrayMap2.containsKey(c)) {
                arrayMap4.put(c0225a, map2.get(c0225a));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0234g c0234g = (C0234g) it.next();
            if (arrayMap3.containsKey(c0234g.f4212a)) {
                arrayList2.add(c0234g);
            } else if (arrayMap4.containsKey(c0234g.f4212a)) {
                arrayList3.add(c0234g);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        Context context2 = context;
        this.f4218d = new al(context2, this.f4216b, lock, looper, c0268j, arrayMap2, null, arrayMap4, null, arrayList3, new C0236i(this));
        Context context3 = context;
        this.f4219e = new al(context3, this.f4216b, lock, looper, c0268j, arrayMap, c0301t, arrayMap3, c0106g, arrayList2, new C0237j(this));
        for (C0227i c0227i2 : arrayMap2.keySet()) {
            this.f4220f.put(c0227i2, this.f4218d);
        }
        for (C0227i c0227i22 : arrayMap.keySet()) {
            this.f4220f.put(c0227i22, this.f4219e);
        }
    }

    private void m7432a(int i, boolean z) {
        this.f4216b.m7583a(i, z);
        this.f4225k = null;
        this.f4224j = null;
    }

    private void m7433a(Bundle bundle) {
        if (this.f4223i == null) {
            this.f4223i = bundle;
        } else if (bundle != null) {
            this.f4223i.putAll(bundle);
        }
    }

    private void m7434a(ConnectionResult connectionResult) {
        switch (this.f4228n) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f4216b.m7585a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m7449l();
        this.f4228n = 0;
    }

    private static boolean m7440b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m7280b();
    }

    private boolean m7441b(C0167c c0167c) {
        C0227i b = c0167c.m6000b();
        bf.m7882b(this.f4220f.containsKey(b), "GoogleApiClient is not configured to use the API required for this call.");
        return ((al) this.f4220f.get(b)).equals(this.f4219e);
    }

    private void m7446i() {
        this.f4225k = null;
        this.f4224j = null;
        this.f4218d.m7373a();
        this.f4219e.m7373a();
    }

    private void m7447j() {
        if (C0235h.m7440b(this.f4224j)) {
            if (C0235h.m7440b(this.f4225k) || m7450m()) {
                m7448k();
            } else if (this.f4225k == null) {
            } else {
                if (this.f4228n == 1) {
                    m7449l();
                    return;
                }
                m7434a(this.f4225k);
                this.f4218d.m7383c();
            }
        } else if (this.f4224j != null && C0235h.m7440b(this.f4225k)) {
            this.f4219e.m7383c();
            m7434a(this.f4224j);
        } else if (this.f4224j != null && this.f4225k != null) {
            ConnectionResult connectionResult = this.f4224j;
            if (this.f4219e.f4178f < this.f4218d.f4178f) {
                connectionResult = this.f4225k;
            }
            m7434a(connectionResult);
        }
    }

    private void m7448k() {
        switch (this.f4228n) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f4216b.m7584a(this.f4223i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m7449l();
        this.f4228n = 0;
    }

    private void m7449l() {
        for (av t : this.f4221g) {
            t.m5964t();
        }
        this.f4221g.clear();
    }

    private boolean m7450m() {
        return this.f4225k != null && this.f4225k.m7281c() == 4;
    }

    private PendingIntent m7451n() {
        return this.f4222h == null ? null : PendingIntent.getActivity(this.f4215a, this.f4216b.m7608q(), this.f4222h.m5721e(), 134217728);
    }

    public C0167c m7452a(C0167c c0167c) {
        if (!m7441b(c0167c)) {
            return this.f4218d.m7372a(c0167c);
        }
        if (!m7450m()) {
            return this.f4219e.m7372a(c0167c);
        }
        c0167c.m6003c(new Status(4, null, m7451n()));
        return c0167c;
    }

    public void m7453a() {
        this.f4228n = 2;
        this.f4226l = false;
        m7446i();
    }

    public void m7454a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f4219e.m7380a(str + "  ", fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f4218d.m7380a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public boolean m7455a(av avVar) {
        this.f4227m.lock();
        try {
            if ((m7459e() || m7458d()) && !m7462h()) {
                this.f4221g.add(avVar);
                if (this.f4228n == 0) {
                    this.f4228n = 1;
                }
                this.f4225k = null;
                this.f4219e.m7373a();
                return true;
            }
            this.f4227m.unlock();
            return false;
        } finally {
            this.f4227m.unlock();
        }
    }

    public ConnectionResult m7456b() {
        throw new UnsupportedOperationException();
    }

    public boolean m7457c() {
        this.f4225k = null;
        this.f4224j = null;
        this.f4228n = 0;
        boolean c = this.f4218d.m7383c();
        boolean c2 = this.f4219e.m7383c();
        m7449l();
        return c && c2;
    }

    public boolean m7458d() {
        boolean z = true;
        this.f4227m.lock();
        try {
            if (!(this.f4218d.m7384d() && (m7462h() || m7450m() || this.f4228n == 1))) {
                z = false;
            }
            this.f4227m.unlock();
            return z;
        } catch (Throwable th) {
            this.f4227m.unlock();
        }
    }

    public boolean m7459e() {
        this.f4227m.lock();
        try {
            boolean z = this.f4228n == 2;
            this.f4227m.unlock();
            return z;
        } catch (Throwable th) {
            this.f4227m.unlock();
        }
    }

    public void m7460f() {
        this.f4218d.m7386f();
        this.f4219e.m7386f();
    }

    public void m7461g() {
        this.f4227m.lock();
        try {
            boolean e = m7459e();
            this.f4219e.m7383c();
            this.f4225k = new ConnectionResult(4);
            if (e) {
                new Handler(this.f4217c).post(new C0238k(this));
            } else {
                m7449l();
            }
            this.f4227m.unlock();
        } catch (Throwable th) {
            this.f4227m.unlock();
        }
    }

    public boolean m7462h() {
        return this.f4219e.m7384d();
    }
}
