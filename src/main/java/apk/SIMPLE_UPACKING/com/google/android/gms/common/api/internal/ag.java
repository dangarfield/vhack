package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.ab;
import java.lang.ref.WeakReference;

class ag implements DeathRecipient, ai {
    private final WeakReference f4169a;
    private final WeakReference f4170b;
    private final WeakReference f4171c;

    private ag(aj ajVar, ab abVar, IBinder iBinder) {
        this.f4170b = new WeakReference(abVar);
        this.f4169a = new WeakReference(ajVar);
        this.f4171c = new WeakReference(iBinder);
    }

    private void m7351a() {
        aj ajVar = (aj) this.f4169a.get();
        ab abVar = (ab) this.f4170b.get();
        if (!(abVar == null || ajVar == null)) {
            abVar.m7299a(ajVar.m5985a().intValue());
        }
        IBinder iBinder = (IBinder) this.f4171c.get();
        if (this.f4171c != null) {
            iBinder.unlinkToDeath(this, 0);
        }
    }

    public void m7352a(aj ajVar) {
        m7351a();
    }

    public void binderDied() {
        m7351a();
    }
}
