package android.support.v7.widget;

import android.view.View;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: OrientationHelper */
public abstract class dp {
    protected final ei f2129a;
    private int f2130b;

    public abstract int m4300a(View view);

    public abstract void m4302a(int i);

    public abstract int m4304b(View view);

    public abstract int m4305c();

    public abstract int m4306c(View view);

    public abstract int m4307d();

    public abstract int m4308d(View view);

    public abstract int m4309e();

    public abstract int m4310f();

    public abstract int m4311g();

    public abstract int m4312h();

    public abstract int m4313i();

    private dp(ei eiVar) {
        this.f2130b = Integer.MIN_VALUE;
        this.f2129a = eiVar;
    }

    public void m4301a() {
        this.f2130b = m4310f();
    }

    public int m4303b() {
        return Integer.MIN_VALUE == this.f2130b ? 0 : m4310f() - this.f2130b;
    }

    public static dp m4298a(ei eiVar, int i) {
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return m4297a(eiVar);
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return m4299b(eiVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static dp m4297a(ei eiVar) {
        return new dq(eiVar);
    }

    public static dp m4299b(ei eiVar) {
        return new dr(eiVar);
    }
}
