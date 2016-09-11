package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class am {
    final /* synthetic */ ak f4402a;
    private final an f4403b;
    private final Set f4404c;
    private int f4405d;
    private boolean f4406e;
    private IBinder f4407f;
    private final al f4408g;
    private ComponentName f4409h;

    public am(ak akVar, al alVar) {
        this.f4402a = akVar;
        this.f4408g = alVar;
        this.f4403b = new an(this);
        this.f4404c = new HashSet();
        this.f4405d = 2;
    }

    public void m7753a(ServiceConnection serviceConnection, String str) {
        this.f4402a.f4398d.m8042a(this.f4402a.f4396b, serviceConnection, str, this.f4408g.m7747a());
        this.f4404c.add(serviceConnection);
    }

    @TargetApi(14)
    public void m7754a(String str) {
        this.f4405d = 3;
        this.f4406e = this.f4402a.f4398d.m8044a(this.f4402a.f4396b, str, this.f4408g.m7747a(), this.f4403b, 129);
        if (!this.f4406e) {
            this.f4405d = 2;
            try {
                this.f4402a.f4398d.m8041a(this.f4402a.f4396b, this.f4403b);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public boolean m7755a() {
        return this.f4406e;
    }

    public boolean m7756a(ServiceConnection serviceConnection) {
        return this.f4404c.contains(serviceConnection);
    }

    public int m7757b() {
        return this.f4405d;
    }

    public void m7758b(ServiceConnection serviceConnection, String str) {
        this.f4402a.f4398d.m8045b(this.f4402a.f4396b, serviceConnection);
        this.f4404c.remove(serviceConnection);
    }

    public void m7759b(String str) {
        this.f4402a.f4398d.m8041a(this.f4402a.f4396b, this.f4403b);
        this.f4406e = false;
        this.f4405d = 2;
    }

    public boolean m7760c() {
        return this.f4404c.isEmpty();
    }

    public IBinder m7761d() {
        return this.f4407f;
    }

    public ComponentName m7762e() {
        return this.f4409h;
    }
}
