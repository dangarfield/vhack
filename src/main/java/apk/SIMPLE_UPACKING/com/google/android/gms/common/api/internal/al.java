package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0106g;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0225a;
import com.google.android.gms.common.internal.C0301t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class al implements aq {
    final Map f4173a;
    final Map f4174b;
    final C0301t f4175c;
    final Map f4176d;
    final C0106g f4177e;
    int f4178f;
    final C0258z f4179g;
    final ar f4180h;
    private final Lock f4181i;
    private final Condition f4182j;
    private final Context f4183k;
    private final C0268j f4184l;
    private final an f4185m;
    private volatile ak f4186n;
    private ConnectionResult f4187o;

    public al(Context context, C0258z c0258z, Lock lock, Looper looper, C0268j c0268j, Map map, C0301t c0301t, Map map2, C0106g c0106g, ArrayList arrayList, ar arVar) {
        this.f4174b = new HashMap();
        this.f4187o = null;
        this.f4183k = context;
        this.f4181i = lock;
        this.f4184l = c0268j;
        this.f4173a = map;
        this.f4175c = c0301t;
        this.f4176d = map2;
        this.f4177e = c0106g;
        this.f4179g = c0258z;
        this.f4180h = arVar;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C0234g) it.next()).m7429a(this);
        }
        this.f4185m = new an(this, looper);
        this.f4182j = lock.newCondition();
        this.f4186n = new C0256y(this);
    }

    public C0167c m7372a(C0167c c0167c) {
        return this.f4186n.m7354a(c0167c);
    }

    public void m7373a() {
        this.f4186n.m7360c();
    }

    public void m7374a(int i) {
        this.f4181i.lock();
        try {
            this.f4186n.m7356a(i);
        } finally {
            this.f4181i.unlock();
        }
    }

    public void m7375a(Bundle bundle) {
        this.f4181i.lock();
        try {
            this.f4186n.m7357a(bundle);
        } finally {
            this.f4181i.unlock();
        }
    }

    void m7376a(ConnectionResult connectionResult) {
        this.f4181i.lock();
        try {
            this.f4187o = connectionResult;
            this.f4186n = new C0256y(this);
            this.f4186n.m7355a();
            this.f4182j.signalAll();
        } finally {
            this.f4181i.unlock();
        }
    }

    public void m7377a(ConnectionResult connectionResult, C0225a c0225a, int i) {
        this.f4181i.lock();
        try {
            this.f4186n.m7358a(connectionResult, c0225a, i);
        } finally {
            this.f4181i.unlock();
        }
    }

    void m7378a(am amVar) {
        this.f4185m.sendMessage(this.f4185m.obtainMessage(1, amVar));
    }

    void m7379a(RuntimeException runtimeException) {
        this.f4185m.sendMessage(this.f4185m.obtainMessage(2, runtimeException));
    }

    public void m7380a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "  ";
        for (C0225a c0225a : this.f4176d.keySet()) {
            printWriter.append(str).append(c0225a.m7298e()).println(":");
            ((C0121h) this.f4173a.get(c0225a.m7296c())).m5719a(str2, fileDescriptor, printWriter, strArr);
        }
    }

    public boolean m7381a(av avVar) {
        return false;
    }

    public ConnectionResult m7382b() {
        m7373a();
        while (m7390j()) {
            try {
                this.f4182j.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return m7384d() ? ConnectionResult.f4122a : this.f4187o != null ? this.f4187o : new ConnectionResult(13, null);
    }

    public boolean m7383c() {
        boolean b = this.f4186n.m7359b();
        if (b) {
            this.f4174b.clear();
        }
        return b;
    }

    public boolean m7384d() {
        return this.f4186n instanceof C0239l;
    }

    void m7385e() {
        this.f4181i.lock();
        try {
            this.f4186n = new C0242o(this, this.f4175c, this.f4176d, this.f4184l, this.f4177e, this.f4181i, this.f4183k);
            this.f4186n.m7355a();
            this.f4182j.signalAll();
        } finally {
            this.f4181i.unlock();
        }
    }

    public void m7386f() {
        if (m7384d()) {
            ((C0239l) this.f4186n).m7478d();
        }
    }

    public void m7387g() {
    }

    void m7388h() {
        this.f4181i.lock();
        try {
            this.f4179g.m7605n();
            this.f4186n = new C0239l(this);
            this.f4186n.m7355a();
            this.f4182j.signalAll();
        } finally {
            this.f4181i.unlock();
        }
    }

    void m7389i() {
        for (C0121h g : this.f4173a.values()) {
            g.m5722g();
        }
    }

    public boolean m7390j() {
        return this.f4186n instanceof C0242o;
    }
}
