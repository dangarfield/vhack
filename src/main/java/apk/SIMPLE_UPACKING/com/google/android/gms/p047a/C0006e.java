package com.google.android.gms.p047a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.C0273r;
import com.google.android.gms.common.internal.bf;

/* renamed from: com.google.android.gms.a.e */
public abstract class C0006e {
    private final String f2861a;
    private Object f2862b;

    protected C0006e(String str) {
        this.f2861a = str;
    }

    protected final Object m5325a(Context context) {
        if (this.f2862b == null) {
            bf.m7873a((Object) context);
            Context e = C0273r.m7666e(context);
            if (e == null) {
                throw new C0007f("Could not get remote context.");
            }
            try {
                this.f2862b = m5326b((IBinder) e.getClassLoader().loadClass(this.f2861a).newInstance());
            } catch (Throwable e2) {
                throw new C0007f("Could not load creator class.", e2);
            } catch (Throwable e22) {
                throw new C0007f("Could not instantiate creator.", e22);
            } catch (Throwable e222) {
                throw new C0007f("Could not access creator.", e222);
            }
        }
        return this.f2862b;
    }

    protected abstract Object m5326b(IBinder iBinder);
}
