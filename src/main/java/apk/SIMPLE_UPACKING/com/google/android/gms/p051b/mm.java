package com.google.android.gms.p051b;

/* renamed from: com.google.android.gms.b.mm */
public abstract class mm {
    protected volatile int f3890B;

    public mm() {
        this.f3890B = -1;
    }

    public void m6962a(mi miVar) {
    }

    public abstract mm m6963b(mh mhVar);

    protected int m6964c() {
        return 0;
    }

    public /* synthetic */ Object clone() {
        return m6967f();
    }

    public int m6965d() {
        if (this.f3890B < 0) {
            m6966e();
        }
        return this.f3890B;
    }

    public int m6966e() {
        int c = m6964c();
        this.f3890B = c;
        return c;
    }

    public mm m6967f() {
        return (mm) super.clone();
    }

    public String toString() {
        return mn.m7187a(this);
    }
}
