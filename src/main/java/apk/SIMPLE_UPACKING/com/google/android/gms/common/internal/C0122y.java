package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.api.C0244s;
import com.google.android.gms.common.api.C0262m;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.y */
public abstract class C0122y implements C0121h, ai {
    public static final String[] f3183c;
    final Handler f3184a;
    protected AtomicInteger f3185b;
    private int f3186d;
    private long f3187e;
    private long f3188f;
    private int f3189g;
    private long f3190h;
    private final Context f3191i;
    private final C0301t f3192j;
    private final Looper f3193k;
    private final aj f3194l;
    private final C0268j f3195m;
    private final Object f3196n;
    private final Object f3197o;
    private aw f3198p;
    private C0244s f3199q;
    private IInterface f3200r;
    private final ArrayList f3201s;
    private ad f3202t;
    private int f3203u;
    private final Set f3204v;
    private final Account f3205w;
    private final C0229q f3206x;
    private final C0230r f3207y;
    private final int f3208z;

    static {
        f3183c = new String[]{"service_esmobile", "service_googleme"};
    }

    protected C0122y(Context context, Looper looper, int i, C0301t c0301t, C0229q c0229q, C0230r c0230r) {
        this(context, looper, aj.m7737a(context), C0268j.m7636b(), i, c0301t, (C0229q) bf.m7873a((Object) c0229q), (C0230r) bf.m7873a((Object) c0230r));
    }

    protected C0122y(Context context, Looper looper, aj ajVar, C0268j c0268j, int i, C0301t c0301t, C0229q c0229q, C0230r c0230r) {
        this.f3196n = new Object();
        this.f3197o = new Object();
        this.f3199q = new ae(this);
        this.f3201s = new ArrayList();
        this.f3203u = 1;
        this.f3185b = new AtomicInteger(0);
        this.f3191i = (Context) bf.m7874a((Object) context, (Object) "Context must not be null");
        this.f3193k = (Looper) bf.m7874a((Object) looper, (Object) "Looper must not be null");
        this.f3194l = (aj) bf.m7874a((Object) ajVar, (Object) "Supervisor must not be null");
        this.f3195m = (C0268j) bf.m7874a((Object) c0268j, (Object) "API availability must not be null");
        this.f3184a = new aa(this, looper);
        this.f3208z = i;
        this.f3192j = (C0301t) bf.m7873a((Object) c0301t);
        this.f3205w = c0301t.m7973b();
        this.f3204v = m5733b(c0301t.m7976e());
        this.f3206x = c0229q;
        this.f3207y = c0230r;
    }

    private boolean m5730a(int i, int i2, IInterface iInterface) {
        boolean z;
        synchronized (this.f3196n) {
            if (this.f3203u != i) {
                z = false;
            } else {
                m5734b(i2, iInterface);
                z = true;
            }
        }
        return z;
    }

    private Set m5733b(Set set) {
        Set<Scope> a = m5742a(set);
        if (a == null) {
            return a;
        }
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5734b(int r5, android.os.IInterface r6) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        r2 = 3;
        if (r5 != r2) goto L_0x001d;
    L_0x0005:
        r3 = r0;
    L_0x0006:
        if (r6 == 0) goto L_0x001f;
    L_0x0008:
        r2 = r0;
    L_0x0009:
        if (r3 != r2) goto L_0x0021;
    L_0x000b:
        com.google.android.gms.common.internal.bf.m7881b(r0);
        r1 = r4.f3196n;
        monitor-enter(r1);
        r4.f3203u = r5;	 Catch:{ all -> 0x0027 }
        r4.f3200r = r6;	 Catch:{ all -> 0x0027 }
        r4.m5746a(r5, r6);	 Catch:{ all -> 0x0027 }
        switch(r5) {
            case 1: goto L_0x002e;
            case 2: goto L_0x0023;
            case 3: goto L_0x002a;
            default: goto L_0x001b;
        };	 Catch:{ all -> 0x0027 }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        return;
    L_0x001d:
        r3 = r1;
        goto L_0x0006;
    L_0x001f:
        r2 = r1;
        goto L_0x0009;
    L_0x0021:
        r0 = r1;
        goto L_0x000b;
    L_0x0023:
        r4.m5739f();	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r4.m5747a(r6);	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
    L_0x002e:
        r4.m5740t();	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.y.b(int, android.os.IInterface):void");
    }

    private void m5739f() {
        if (this.f3202t != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + m5741a());
            this.f3194l.m7739b(m5741a(), this.f3202t, c_());
            this.f3185b.incrementAndGet();
        }
        this.f3202t = new ad(this, this.f3185b.get());
        if (!this.f3194l.m7738a(m5741a(), this.f3202t, c_())) {
            Log.e("GmsClient", "unable to connect to service: " + m5741a());
            m5744a(8, this.f3185b.get());
        }
    }

    private void m5740t() {
        if (this.f3202t != null) {
            this.f3194l.m7739b(m5741a(), this.f3202t, c_());
            this.f3202t = null;
        }
    }

    protected abstract String m5741a();

    protected Set m5742a(Set set) {
        return set;
    }

    protected void m5743a(int i) {
        this.f3186d = i;
        this.f3187e = System.currentTimeMillis();
    }

    protected void m5744a(int i, int i2) {
        this.f3184a.sendMessage(this.f3184a.obtainMessage(5, i2, -1, new ag(this, i)));
    }

    protected void m5745a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f3184a.sendMessage(this.f3184a.obtainMessage(1, i2, -1, new af(this, i, iBinder, bundle)));
    }

    void m5746a(int i, IInterface iInterface) {
    }

    protected void m5747a(IInterface iInterface) {
        this.f3188f = System.currentTimeMillis();
    }

    protected void m5748a(ConnectionResult connectionResult) {
        this.f3189g = connectionResult.m7281c();
        this.f3190h = System.currentTimeMillis();
    }

    public void m5749a(C0244s c0244s) {
        this.f3199q = (C0244s) bf.m7874a((Object) c0244s, (Object) "Connection progress callbacks cannot be null.");
        m5734b(2, null);
    }

    public void m5750a(ap apVar, Set set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.f3208z).m7689a(this.f3191i.getPackageName()).m7687a(m5755c());
            if (set != null) {
                a.m7690a((Collection) set);
            }
            if (m5760i()) {
                a.m7686a(m5765o()).m7688a(apVar);
            } else if (m5769s()) {
                a.m7686a(this.f3205w);
            }
            synchronized (this.f3197o) {
                if (this.f3198p != null) {
                    this.f3198p.m7783a(new ac(this, this.f3185b.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m5754b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void m5751a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f3196n) {
            int i = this.f3203u;
            IInterface iInterface = this.f3200r;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                printWriter.print("DISCONNECTED");
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                printWriter.print("CONNECTING");
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                printWriter.print("CONNECTED");
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(m5753b()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f3188f > 0) {
            printWriter.append(str).append("lastConnectedTime=").println(this.f3188f + " " + simpleDateFormat.format(new Date(this.f3188f)));
        }
        if (this.f3187e > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f3186d) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f3186d));
                    break;
            }
            printWriter.append(" lastSuspendedTime=").println(this.f3187e + " " + simpleDateFormat.format(new Date(this.f3187e)));
        }
        if (this.f3190h > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(C0262m.m7616a(this.f3189g));
            printWriter.append(" lastFailedTime=").println(this.f3190h + " " + simpleDateFormat.format(new Date(this.f3190h)));
        }
    }

    protected abstract IInterface m5752b(IBinder iBinder);

    protected abstract String m5753b();

    public void m5754b(int i) {
        this.f3184a.sendMessage(this.f3184a.obtainMessage(4, this.f3185b.get(), i));
    }

    public Bundle b_() {
        return null;
    }

    protected Bundle m5755c() {
        return new Bundle();
    }

    protected final String c_() {
        return this.f3192j.m7979h();
    }

    public boolean m5756d() {
        return false;
    }

    public Intent m5757e() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public void m5758g() {
        this.f3185b.incrementAndGet();
        synchronized (this.f3201s) {
            int size = this.f3201s.size();
            for (int i = 0; i < size; i++) {
                ((ab) this.f3201s.get(i)).m7712e();
            }
            this.f3201s.clear();
        }
        synchronized (this.f3197o) {
            this.f3198p = null;
        }
        m5734b(1, null);
    }

    public boolean m5759h() {
        boolean z;
        synchronized (this.f3196n) {
            z = this.f3203u == 3;
        }
        return z;
    }

    public boolean m5760i() {
        return false;
    }

    public IBinder m5761j() {
        IBinder iBinder;
        synchronized (this.f3197o) {
            if (this.f3198p == null) {
                iBinder = null;
            } else {
                iBinder = this.f3198p.asBinder();
            }
        }
        return iBinder;
    }

    public void m5762l() {
        int a = this.f3195m.m7638a(this.f3191i);
        if (a != 0) {
            m5734b(1, null);
            this.f3199q = new ae(this);
            this.f3184a.sendMessage(this.f3184a.obtainMessage(3, this.f3185b.get(), a));
            return;
        }
        m5749a(new ae(this));
    }

    public boolean m5763m() {
        boolean z;
        synchronized (this.f3196n) {
            z = this.f3203u == 2;
        }
        return z;
    }

    public final Context m5764n() {
        return this.f3191i;
    }

    public final Account m5765o() {
        return this.f3205w != null ? this.f3205w : new Account("<<default account>>", "com.google");
    }

    protected final C0301t m5766p() {
        return this.f3192j;
    }

    protected final void m5767q() {
        if (!m5759h()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final IInterface m5768r() {
        IInterface iInterface;
        synchronized (this.f3196n) {
            if (this.f3203u == 4) {
                throw new DeadObjectException();
            }
            m5767q();
            bf.m7878a(this.f3200r != null, (Object) "Client is connected but service is null");
            iInterface = this.f3200r;
        }
        return iInterface;
    }

    public boolean m5769s() {
        return false;
    }
}
