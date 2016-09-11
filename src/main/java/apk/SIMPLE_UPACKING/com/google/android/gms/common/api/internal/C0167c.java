package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0224w;
import com.google.android.gms.common.api.C0227i;
import com.google.android.gms.common.api.C0257n;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.bf;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.common.api.internal.c */
public abstract class C0167c extends C0165e implements aj, C0166d {
    private final C0227i f3336a;
    private AtomicReference f3337b;

    protected C0167c(C0227i c0227i, C0257n c0257n) {
        super((C0257n) bf.m7874a((Object) c0257n, (Object) "GoogleApiClient must not be null"));
        this.f3337b = new AtomicReference();
        this.f3336a = (C0227i) bf.m7873a((Object) c0227i);
    }

    private void m5996a(RemoteException remoteException) {
        m6003c(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    protected abstract void m5997a(C0121h c0121h);

    public void m5998a(ai aiVar) {
        this.f3337b.set(aiVar);
    }

    public /* synthetic */ void m5999a(Object obj) {
        super.m5976a((C0224w) obj);
    }

    public final C0227i m6000b() {
        return this.f3336a;
    }

    public final void m6001b(C0121h c0121h) {
        try {
            m5997a(c0121h);
        } catch (RemoteException e) {
            m5996a(e);
            throw e;
        } catch (RemoteException e2) {
            m5996a(e2);
        }
    }

    public void m6002c() {
        m5977a(null);
    }

    public final void m6003c(Status status) {
        bf.m7882b(!status.m7292e(), "Failed result must not be success");
        m5976a(m5978b(status));
    }

    protected void m6004d() {
        ai aiVar = (ai) this.f3337b.getAndSet(null);
        if (aiVar != null) {
            aiVar.m7339a(this);
        }
    }
}
