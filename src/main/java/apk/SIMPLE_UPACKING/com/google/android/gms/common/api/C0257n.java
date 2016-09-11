package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.C0167c;
import com.google.android.gms.common.api.internal.av;
import com.google.android.gms.common.api.internal.ba;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.common.api.n */
public abstract class C0257n {
    private static final Set f4274a;

    static {
        f4274a = Collections.newSetFromMap(new WeakHashMap());
    }

    public static Set m7549a() {
        return f4274a;
    }

    public C0121h m7551a(C0227i c0227i) {
        throw new UnsupportedOperationException();
    }

    public C0167c m7552a(C0167c c0167c) {
        throw new UnsupportedOperationException();
    }

    public void m7553a(int i) {
        throw new UnsupportedOperationException();
    }

    public void m7554a(ba baVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void m7555a(C0230r c0230r);

    public abstract void m7556a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public boolean m7557a(av avVar) {
        throw new UnsupportedOperationException();
    }

    public Context m7558b() {
        throw new UnsupportedOperationException();
    }

    public void m7559b(ba baVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void m7560b(C0230r c0230r);

    public Looper m7561c() {
        throw new UnsupportedOperationException();
    }

    public void m7562d() {
        throw new UnsupportedOperationException();
    }

    public abstract void m7563e();

    public abstract ConnectionResult m7564f();

    public abstract void m7565g();

    public abstract C0164t m7566h();
}
