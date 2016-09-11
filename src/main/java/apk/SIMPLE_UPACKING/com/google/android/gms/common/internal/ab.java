package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class ab {
    private Object f4370a;
    private boolean f4371b;
    final /* synthetic */ C0122y f4372d;

    public ab(C0122y c0122y, Object obj) {
        this.f4372d = c0122y;
        this.f4370a = obj;
        this.f4371b = false;
    }

    protected abstract void m7708a(Object obj);

    protected abstract void m7709b();

    public void m7710c() {
        synchronized (this) {
            Object obj = this.f4370a;
            if (this.f4371b) {
                Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                m7708a(obj);
            } catch (RuntimeException e) {
                m7709b();
                throw e;
            }
        }
        m7709b();
        synchronized (this) {
            this.f4371b = true;
        }
        m7711d();
    }

    public void m7711d() {
        m7712e();
        synchronized (this.f4372d.f3201s) {
            this.f4372d.f3201s.remove(this);
        }
    }

    public void m7712e() {
        synchronized (this) {
            this.f4370a = null;
        }
    }
}
