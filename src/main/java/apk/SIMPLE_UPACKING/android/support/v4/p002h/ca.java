package android.support.v4.p002h;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
/* renamed from: android.support.v4.h.ca */
class ca extends by {
    static Field f928b;
    static boolean f929c;

    ca() {
    }

    static {
        f929c = false;
    }

    public boolean m2106a(View view, int i) {
        return cl.m2193a(view, i);
    }

    public boolean m2108b(View view, int i) {
        return cl.m2194b(view, i);
    }

    public void m2104a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        cl.m2191a(view, accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.m1756a());
    }

    public boolean m2107b(View view) {
        boolean z = true;
        if (f929c) {
            return false;
        }
        if (f928b == null) {
            try {
                f928b = View.class.getDeclaredField("mAccessibilityDelegate");
                f928b.setAccessible(true);
            } catch (Throwable th) {
                f929c = true;
                return false;
            }
        }
        try {
            if (f928b.get(view) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            f929c = true;
            return false;
        }
    }

    public di m2109r(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        di diVar = (di) this.a.get(view);
        if (diVar != null) {
            return diVar;
        }
        diVar = new di(view);
        this.a.put(view, diVar);
        return diVar;
    }

    public void m2105a(View view, boolean z) {
        cl.m2192a(view, z);
    }
}
