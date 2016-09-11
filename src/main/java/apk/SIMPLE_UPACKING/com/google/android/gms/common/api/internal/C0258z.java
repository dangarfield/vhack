package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0106g;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0164t;
import com.google.android.gms.common.api.C0227i;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.api.C0257n;
import com.google.android.gms.common.api.C0263o;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ab;
import com.google.android.gms.common.internal.C0301t;
import com.google.android.gms.common.internal.ah;
import com.google.android.gms.common.internal.ai;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p051b.jo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.common.api.internal.z */
public final class C0258z extends C0257n implements ar {
    final Queue f4275a;
    ah f4276b;
    final Map f4277c;
    Set f4278d;
    final C0301t f4279e;
    final Map f4280f;
    final C0106g f4281g;
    final Set f4282h;
    Set f4283i;
    private final Lock f4284j;
    private final ah f4285k;
    private aq f4286l;
    private final int f4287m;
    private final Context f4288n;
    private final Looper f4289o;
    private volatile boolean f4290p;
    private long f4291q;
    private long f4292r;
    private final af f4293s;
    private final C0268j f4294t;
    private final Set f4295u;
    private ab f4296v;
    private final ArrayList f4297w;
    private Integer f4298x;
    private final ai f4299y;
    private final ai f4300z;

    public C0258z(Context context, Lock lock, Looper looper, C0301t c0301t, C0268j c0268j, C0106g c0106g, Map map, List list, List list2, Map map2, int i, int i2, ArrayList arrayList) {
        this.f4286l = null;
        this.f4275a = new LinkedList();
        this.f4291q = 120000;
        this.f4292r = 5000;
        this.f4278d = new HashSet();
        this.f4295u = Collections.newSetFromMap(new WeakHashMap());
        this.f4282h = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
        this.f4298x = null;
        this.f4283i = null;
        this.f4299y = new aa(this);
        this.f4300z = new ab(this);
        this.f4288n = context;
        this.f4284j = lock;
        this.f4285k = new ah(looper, this.f4300z);
        this.f4289o = looper;
        this.f4293s = new af(this, looper);
        this.f4294t = c0268j;
        this.f4287m = i;
        if (this.f4287m >= 0) {
            this.f4298x = Integer.valueOf(i2);
        }
        this.f4280f = map;
        this.f4277c = map2;
        this.f4297w = arrayList;
        for (C0229q a : list) {
            this.f4285k.m7733a(a);
        }
        for (C0230r a2 : list2) {
            this.f4285k.m7734a(a2);
        }
        this.f4279e = c0301t;
        this.f4281g = c0106g;
    }

    public static int m7567a(Iterable iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (C0121h c0121h : iterable) {
            if (c0121h.m5724i()) {
                i2 = 1;
            }
            i = c0121h.m5720d() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    private static void m7569a(aj ajVar, ab abVar, IBinder iBinder) {
        if (ajVar.m5992e()) {
            ajVar.m5986a(new ag(abVar, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            ajVar.m5986a(null);
            ajVar.m5993f();
            abVar.m7299a(ajVar.m5985a().intValue());
        } else {
            Object agVar = new ag(abVar, iBinder, null);
            ajVar.m5986a(agVar);
            try {
                iBinder.linkToDeath(agVar, 0);
            } catch (RemoteException e) {
                ajVar.m5993f();
                abVar.m7299a(ajVar.m5985a().intValue());
            }
        }
    }

    private void m7571a(C0257n c0257n, aw awVar, boolean z) {
        jo.f3858c.m6892a(c0257n).m5971a(new ae(this, awVar, z, c0257n));
    }

    static String m7572b(int i) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return "SIGN_IN_MODE_REQUIRED";
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return "SIGN_IN_MODE_OPTIONAL";
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m7574c(int i) {
        if (this.f4298x == null) {
            this.f4298x = Integer.valueOf(i);
        } else if (this.f4298x.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + C0258z.m7572b(i) + ". Mode was already set to " + C0258z.m7572b(this.f4298x.intValue()));
        }
        if (this.f4286l == null) {
            Object obj = null;
            Object obj2 = null;
            for (C0121h c0121h : this.f4277c.values()) {
                if (c0121h.m5724i()) {
                    obj2 = 1;
                }
                obj = c0121h.m5720d() ? 1 : obj;
            }
            switch (this.f4298x.intValue()) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    if (obj2 != null) {
                        this.f4286l = new C0235h(this.f4288n, this, this.f4284j, this.f4289o, this.f4294t, this.f4277c, this.f4279e, this.f4280f, this.f4281g, this.f4297w);
                        return;
                    }
                    break;
            }
            this.f4286l = new al(this.f4288n, this, this.f4284j, this.f4289o, this.f4294t, this.f4277c, this.f4279e, this.f4280f, this.f4281g, this.f4297w, this);
        }
    }

    private void m7577r() {
        this.f4285k.m7735b();
        this.f4286l.m7362a();
    }

    private void m7578s() {
        this.f4284j.lock();
        try {
            if (m7603l()) {
                m7577r();
            }
            this.f4284j.unlock();
        } catch (Throwable th) {
            this.f4284j.unlock();
        }
    }

    private void m7579t() {
        this.f4284j.lock();
        try {
            if (m7605n()) {
                m7577r();
            }
            this.f4284j.unlock();
        } catch (Throwable th) {
            this.f4284j.unlock();
        }
    }

    public C0121h m7580a(C0227i c0227i) {
        Object obj = (C0121h) this.f4277c.get(c0227i);
        bf.m7874a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public C0167c m7581a(C0167c c0167c) {
        bf.m7882b(c0167c.m6000b() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.f4284j.lock();
        try {
            if (this.f4286l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m7603l()) {
                this.f4275a.add(c0167c);
                while (!this.f4275a.isEmpty()) {
                    aj ajVar = (aj) this.f4275a.remove();
                    m7586a(ajVar);
                    ajVar.m5990c(Status.f4133c);
                }
            } else {
                c0167c = this.f4286l.m7361a(c0167c);
                this.f4284j.unlock();
            }
            return c0167c;
        } finally {
            this.f4284j.unlock();
        }
    }

    public void m7582a(int i) {
        boolean z = true;
        this.f4284j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            bf.m7882b(z, "Illegal sign-in mode: " + i);
            m7574c(i);
            m7577r();
        } finally {
            this.f4284j.unlock();
        }
    }

    public void m7583a(int i, boolean z) {
        if (i == 1 && !z) {
            m7604m();
        }
        for (aj ajVar : this.f4282h) {
            if (z) {
                ajVar.m5989c();
            }
            ajVar.m5991d(new Status(8, "The connection to Google Play services was lost"));
        }
        this.f4282h.clear();
        this.f4285k.m7730a(i);
        this.f4285k.m7729a();
        if (i == 2) {
            m7577r();
        }
    }

    public void m7584a(Bundle bundle) {
        while (!this.f4275a.isEmpty()) {
            m7581a((C0167c) this.f4275a.remove());
        }
        this.f4285k.m7731a(bundle);
    }

    public void m7585a(ConnectionResult connectionResult) {
        if (!this.f4294t.m7641a(this.f4288n, connectionResult.m7281c())) {
            m7605n();
        }
        if (!m7603l()) {
            this.f4285k.m7732a(connectionResult);
            this.f4285k.m7729a();
        }
    }

    void m7586a(aj ajVar) {
        this.f4282h.add(ajVar);
        ajVar.m5986a(this.f4299y);
    }

    public void m7587a(ba baVar) {
        this.f4284j.lock();
        try {
            if (this.f4283i == null) {
                this.f4283i = new HashSet();
            }
            this.f4283i.add(baVar);
        } finally {
            this.f4284j.unlock();
        }
    }

    public void m7588a(C0230r c0230r) {
        this.f4285k.m7734a(c0230r);
    }

    public void m7589a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f4288n);
        printWriter.append(str).append("mResuming=").print(this.f4290p);
        printWriter.append(" mWorkQueue.size()=").print(this.f4275a.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.f4282h.size());
        if (this.f4286l != null) {
            this.f4286l.m7363a(str, fileDescriptor, printWriter, strArr);
        }
    }

    void m7590a(boolean z) {
        for (aj ajVar : this.f4282h) {
            if (ajVar.m5985a() != null) {
                ajVar.m5989c();
                C0258z.m7569a(ajVar, this.f4296v, m7580a(ajVar.m5987b()).m5725j());
                this.f4282h.remove(ajVar);
            } else if (z) {
                ajVar.m5994g();
            } else {
                ajVar.m5993f();
                this.f4282h.remove(ajVar);
            }
        }
    }

    public boolean m7591a(av avVar) {
        return this.f4286l != null && this.f4286l.m7364a(avVar);
    }

    public Context m7592b() {
        return this.f4288n;
    }

    public void m7593b(ba baVar) {
        this.f4284j.lock();
        try {
            if (this.f4283i == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f4283i.remove(baVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m7606o()) {
                this.f4286l.m7368f();
            }
            this.f4284j.unlock();
        } catch (Throwable th) {
            this.f4284j.unlock();
        }
    }

    public void m7594b(C0230r c0230r) {
        this.f4285k.m7736b(c0230r);
    }

    public Looper m7595c() {
        return this.f4289o;
    }

    public void m7596d() {
        if (this.f4286l != null) {
            this.f4286l.m7369g();
        }
    }

    public void m7597e() {
        boolean z = false;
        this.f4284j.lock();
        try {
            if (this.f4287m >= 0) {
                if (this.f4298x != null) {
                    z = true;
                }
                bf.m7878a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f4298x == null) {
                this.f4298x = Integer.valueOf(C0258z.m7567a(this.f4277c.values(), false));
            } else if (this.f4298x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m7582a(this.f4298x.intValue());
        } finally {
            this.f4284j.unlock();
        }
    }

    public ConnectionResult m7598f() {
        boolean z = true;
        bf.m7878a(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f4284j.lock();
        try {
            if (this.f4287m >= 0) {
                if (this.f4298x == null) {
                    z = false;
                }
                bf.m7878a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f4298x == null) {
                this.f4298x = Integer.valueOf(C0258z.m7567a(this.f4277c.values(), false));
            } else if (this.f4298x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m7574c(this.f4298x.intValue());
            this.f4285k.m7735b();
            ConnectionResult b = this.f4286l.m7365b();
            return b;
        } finally {
            this.f4284j.unlock();
        }
    }

    public void m7599g() {
        this.f4284j.lock();
        try {
            boolean z = (this.f4286l == null || this.f4286l.m7366c()) ? false : true;
            m7590a(z);
            for (as a : this.f4295u) {
                a.m7397a();
            }
            this.f4295u.clear();
            for (aj ajVar : this.f4275a) {
                ajVar.m5986a(null);
                ajVar.m5993f();
            }
            this.f4275a.clear();
            if (this.f4286l != null) {
                m7605n();
                this.f4285k.m7729a();
                this.f4284j.unlock();
            }
        } finally {
            this.f4284j.unlock();
        }
    }

    public C0164t m7600h() {
        bf.m7878a(m7602k(), (Object) "GoogleApiClient is not connected yet.");
        bf.m7878a(this.f4298x.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        aw awVar = new aw(this);
        if (this.f4277c.containsKey(jo.f3856a)) {
            m7571a((C0257n) this, awVar, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            C0257n b = new C0263o(this.f4288n).m7625a(jo.f3857b).m7627a(new ac(this, atomicReference, awVar)).m7628a(new ad(this, awVar)).m7624a(this.f4293s).m7630b();
            atomicReference.set(b);
            b.m7563e();
        }
        return awVar;
    }

    public void m7601j() {
        m7599g();
        m7597e();
    }

    public boolean m7602k() {
        return this.f4286l != null && this.f4286l.m7367d();
    }

    boolean m7603l() {
        return this.f4290p;
    }

    void m7604m() {
        if (!m7603l()) {
            this.f4290p = true;
            if (this.f4276b == null) {
                this.f4276b = (ah) ap.m7335a(this.f4288n.getApplicationContext(), new ah(this), this.f4294t);
            }
            this.f4293s.sendMessageDelayed(this.f4293s.obtainMessage(1), this.f4291q);
            this.f4293s.sendMessageDelayed(this.f4293s.obtainMessage(2), this.f4292r);
        }
    }

    boolean m7605n() {
        if (!m7603l()) {
            return false;
        }
        this.f4290p = false;
        this.f4293s.removeMessages(2);
        this.f4293s.removeMessages(1);
        if (this.f4276b != null) {
            this.f4276b.m7337b();
            this.f4276b = null;
        }
        return true;
    }

    boolean m7606o() {
        boolean z = false;
        this.f4284j.lock();
        try {
            if (this.f4283i != null) {
                if (!this.f4283i.isEmpty()) {
                    z = true;
                }
                this.f4284j.unlock();
            }
            return z;
        } finally {
            this.f4284j.unlock();
        }
    }

    String m7607p() {
        Writer stringWriter = new StringWriter();
        m7589a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int m7608q() {
        return System.identityHashCode(this);
    }
}
