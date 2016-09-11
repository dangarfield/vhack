package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;

/* compiled from: RemoteInput */
public final class cq extends cy {
    public static final cz f637a;
    private static final cs f638g;
    private final String f639b;
    private final CharSequence f640c;
    private final CharSequence[] f641d;
    private final boolean f642e;
    private final Bundle f643f;

    public String m1051a() {
        return this.f639b;
    }

    public CharSequence m1052b() {
        return this.f640c;
    }

    public CharSequence[] m1053c() {
        return this.f641d;
    }

    public boolean m1054d() {
        return this.f642e;
    }

    public Bundle m1055e() {
        return this.f643f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f638g = new ct();
        } else if (VERSION.SDK_INT >= 16) {
            f638g = new cv();
        } else {
            f638g = new cu();
        }
        f637a = new cr();
    }
}
