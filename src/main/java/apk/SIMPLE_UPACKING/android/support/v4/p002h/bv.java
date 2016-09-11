package android.support.v4.p002h;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
/* renamed from: android.support.v4.h.bv */
class bv implements ch {
    WeakHashMap f927a;

    bv() {
        this.f927a = null;
    }

    public boolean m2049a(View view, int i) {
        return (view instanceof bn) && m2025a((bn) view, i);
    }

    public boolean m2053b(View view, int i) {
        return (view instanceof bn) && m2026b((bn) view, i);
    }

    public int m2035a(View view) {
        return 2;
    }

    public void m2044a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
    }

    public boolean m2052b(View view) {
        return false;
    }

    public boolean m2057c(View view) {
        return false;
    }

    public void m2058d(View view) {
        view.invalidate();
    }

    public void m2046a(View view, Runnable runnable) {
        view.postDelayed(runnable, m2036a());
    }

    public void m2047a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, m2036a() + j);
    }

    long m2036a() {
        return 10;
    }

    public int m2061e(View view) {
        return 0;
    }

    public void m2055c(View view, int i) {
    }

    public float m2063f(View view) {
        return 1.0f;
    }

    public void m2041a(View view, int i, Paint paint) {
    }

    public int m2065g(View view) {
        return 0;
    }

    public int m2066h(View view) {
        return 0;
    }

    public int m2034a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    public int m2067i(View view) {
        return view.getMeasuredWidth();
    }

    public int m2068j(View view) {
        return 0;
    }

    public void m2060d(View view, int i) {
    }

    public int m2069k(View view) {
        return view.getPaddingLeft();
    }

    public int m2070l(View view) {
        return view.getPaddingRight();
    }

    public void m2040a(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public boolean m2071m(View view) {
        return true;
    }

    public float m2072n(View view) {
        return 0.0f;
    }

    public float m2073o(View view) {
        return 0.0f;
    }

    public int m2074p(View view) {
        return ci.m2168d(view);
    }

    public int m2075q(View view) {
        return ci.m2169e(view);
    }

    public di m2076r(View view) {
        return new di(view);
    }

    public void m2038a(View view, float f) {
    }

    public void m2050b(View view, float f) {
    }

    public void m2054c(View view, float f) {
    }

    public int m2077s(View view) {
        return 0;
    }

    public void m2078t(View view) {
    }

    public void m2059d(View view, float f) {
    }

    public float m2079u(View view) {
        return 0.0f;
    }

    public float m2080v(View view) {
        return 0.0f;
    }

    public boolean m2081w(View view) {
        return false;
    }

    public void m2048a(View view, boolean z) {
    }

    public void m2082x(View view) {
    }

    public void m2045a(View view, bm bmVar) {
    }

    public ec m2037a(View view, ec ecVar) {
        return ecVar;
    }

    public void m2051b(View view, boolean z) {
    }

    public void m2056c(View view, boolean z) {
    }

    public boolean m2083y(View view) {
        return false;
    }

    public ColorStateList m2084z(View view) {
        return ci.m2161a(view);
    }

    public void m2042a(View view, ColorStateList colorStateList) {
        ci.m2163a(view, colorStateList);
    }

    public void m2043a(View view, Mode mode) {
        ci.m2164a(view, mode);
    }

    public Mode m2027A(View view) {
        return ci.m2165b(view);
    }

    private boolean m2025a(bn bnVar, int i) {
        int computeHorizontalScrollOffset = bnVar.computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = bnVar.computeHorizontalScrollRange() - bnVar.computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            return false;
        }
        if (i < 0) {
            if (computeHorizontalScrollOffset <= 0) {
                return false;
            }
            return true;
        } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m2026b(bn bnVar, int i) {
        int computeVerticalScrollOffset = bnVar.computeVerticalScrollOffset();
        int computeVerticalScrollRange = bnVar.computeVerticalScrollRange() - bnVar.computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        if (i < 0) {
            if (computeVerticalScrollOffset <= 0) {
                return false;
            }
            return true;
        } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
            return false;
        } else {
            return true;
        }
    }

    public void m2028B(View view) {
        if (view instanceof bi) {
            ((bi) view).stopNestedScroll();
        }
    }

    public boolean m2029C(View view) {
        return ci.m2167c(view);
    }

    public int m2033a(int i, int i2) {
        return i | i2;
    }

    public float m2030D(View view) {
        return m2080v(view) + m2079u(view);
    }

    public boolean m2031E(View view) {
        return ci.m2170f(view);
    }

    public boolean m2032F(View view) {
        return false;
    }

    public void m2039a(View view, int i, int i2) {
    }

    public void m2062e(View view, int i) {
        ci.m2166b(view, i);
    }

    public void m2064f(View view, int i) {
        ci.m2162a(view, i);
    }
}
