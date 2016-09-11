package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/* renamed from: android.support.v7.view.b */
public abstract class ActionMode {
    private Object f1237a;
    private boolean f1238b;

    public abstract MenuInflater m2994a();

    public abstract void m2995a(int i);

    public abstract void m2996a(View view);

    public abstract void m2997a(CharSequence charSequence);

    public abstract Menu m3000b();

    public abstract void m3001b(int i);

    public abstract void m3002b(CharSequence charSequence);

    public abstract void m3003c();

    public abstract void m3004d();

    public abstract CharSequence m3005f();

    public abstract CharSequence m3006g();

    public abstract View m3008i();

    public void m2998a(Object obj) {
        this.f1237a = obj;
    }

    public Object m3009j() {
        return this.f1237a;
    }

    public void m2999a(boolean z) {
        this.f1238b = z;
    }

    public boolean m3010k() {
        return this.f1238b;
    }

    public boolean m3007h() {
        return false;
    }
}
