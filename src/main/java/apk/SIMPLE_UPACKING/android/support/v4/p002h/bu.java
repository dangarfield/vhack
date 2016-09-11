package android.support.v4.p002h;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ViewCompat */
/* renamed from: android.support.v4.h.bu */
public final class bu {
    static final ch f926a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f926a = new cg();
        } else if (i >= 21) {
            f926a = new cf();
        } else if (i >= 19) {
            f926a = new ce();
        } else if (i >= 17) {
            f926a = new cc();
        } else if (i >= 16) {
            f926a = new cb();
        } else if (i >= 15) {
            f926a = new bz();
        } else if (i >= 14) {
            f926a = new ca();
        } else if (i >= 11) {
            f926a = new by();
        } else if (i >= 9) {
            f926a = new bx();
        } else if (i >= 7) {
            f926a = new bw();
        } else {
            f926a = new bv();
        }
    }

    public static boolean m1934a(View view, int i) {
        return f926a.m1991a(view, i);
    }

    public static boolean m1938b(View view, int i) {
        return f926a.m1995b(view, i);
    }

    public static int m1921a(View view) {
        return f926a.m1978a(view);
    }

    public static void m1929a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        f926a.m1986a(view, accessibilityDelegateCompat);
    }

    public static boolean m1937b(View view) {
        return f926a.m1994b(view);
    }

    public static boolean m1942c(View view) {
        return f926a.m1999c(view);
    }

    public static void m1943d(View view) {
        f926a.m2000d(view);
    }

    public static void m1931a(View view, Runnable runnable) {
        f926a.m1988a(view, runnable);
    }

    public static void m1932a(View view, Runnable runnable, long j) {
        f926a.m1989a(view, runnable, j);
    }

    public static int m1946e(View view) {
        return f926a.m2003e(view);
    }

    public static void m1940c(View view, int i) {
        f926a.m1997c(view, i);
    }

    public static float m1948f(View view) {
        return f926a.m2005f(view);
    }

    public static void m1926a(View view, int i, Paint paint) {
        f926a.m1983a(view, i, paint);
    }

    public static int m1950g(View view) {
        return f926a.m2007g(view);
    }

    public static int m1951h(View view) {
        return f926a.m2008h(view);
    }

    public static int m1920a(int i, int i2, int i3) {
        return f926a.m1977a(i, i2, i3);
    }

    public static int m1952i(View view) {
        return f926a.m2009i(view);
    }

    public static int m1953j(View view) {
        return f926a.m2010j(view);
    }

    public static int m1919a(int i, int i2) {
        return f926a.m1976a(i, i2);
    }

    public static void m1945d(View view, int i) {
        f926a.m2002d(view, i);
    }

    public static int m1954k(View view) {
        return f926a.m2011k(view);
    }

    public static int m1955l(View view) {
        return f926a.m2012l(view);
    }

    public static void m1925a(View view, int i, int i2, int i3, int i4) {
        f926a.m1982a(view, i, i2, i3, i4);
    }

    public static float m1956m(View view) {
        return f926a.m2014n(view);
    }

    public static float m1957n(View view) {
        return f926a.m2015o(view);
    }

    public static int m1958o(View view) {
        return f926a.m2016p(view);
    }

    public static int m1959p(View view) {
        return f926a.m2017q(view);
    }

    public static di m1960q(View view) {
        return f926a.m2018r(view);
    }

    public static void m1923a(View view, float f) {
        f926a.m1980a(view, f);
    }

    public static void m1935b(View view, float f) {
        f926a.m1992b(view, f);
    }

    public static void m1939c(View view, float f) {
        f926a.m1996c(view, f);
    }

    public static void m1944d(View view, float f) {
        f926a.m2001d(view, f);
    }

    public static int m1961r(View view) {
        return f926a.m2019s(view);
    }

    public static void m1962s(View view) {
        f926a.m2020t(view);
    }

    public static boolean m1963t(View view) {
        return f926a.m2021w(view);
    }

    public static void m1933a(View view, boolean z) {
        f926a.m1990a(view, z);
    }

    public static void m1964u(View view) {
        f926a.m2022x(view);
    }

    public static void m1930a(View view, bm bmVar) {
        f926a.m1987a(view, bmVar);
    }

    public static ec m1922a(View view, ec ecVar) {
        return f926a.m1979a(view, ecVar);
    }

    public static void m1936b(View view, boolean z) {
        f926a.m1993b(view, z);
    }

    public static void m1941c(View view, boolean z) {
        f926a.m1998c(view, z);
    }

    public static boolean m1965v(View view) {
        return f926a.m2013m(view);
    }

    public static boolean m1966w(View view) {
        return f926a.m2023y(view);
    }

    public static ColorStateList m1967x(View view) {
        return f926a.m2024z(view);
    }

    public static void m1927a(View view, ColorStateList colorStateList) {
        f926a.m1984a(view, colorStateList);
    }

    public static Mode m1968y(View view) {
        return f926a.m1970A(view);
    }

    public static void m1928a(View view, Mode mode) {
        f926a.m1985a(view, mode);
    }

    public static void m1969z(View view) {
        f926a.m1971B(view);
    }

    public static boolean m1915A(View view) {
        return f926a.m1972C(view);
    }

    public static float m1916B(View view) {
        return f926a.m1973D(view);
    }

    public static void m1947e(View view, int i) {
        f926a.m2006f(view, i);
    }

    public static void m1949f(View view, int i) {
        f926a.m2004e(view, i);
    }

    public static boolean m1917C(View view) {
        return f926a.m1974E(view);
    }

    public static boolean m1918D(View view) {
        return f926a.m1975F(view);
    }

    public static void m1924a(View view, int i, int i2) {
        f926a.m1981a(view, i, i2);
    }
}
