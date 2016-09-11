package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* compiled from: LayoutInflaterCompat */
/* renamed from: android.support.v4.h.ab */
public final class ab {
    static final ac f907a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f907a = new af();
        } else if (i >= 11) {
            f907a = new ae();
        } else {
            f907a = new ad();
        }
    }

    public static void m1768a(LayoutInflater layoutInflater, al alVar) {
        f907a.m1770a(layoutInflater, alVar);
    }

    public static al m1767a(LayoutInflater layoutInflater) {
        return f907a.m1769a(layoutInflater);
    }
}
