package android.support.v4.p013f;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.f.g */
class ICUCompatIcs {
    private static Method f832a;
    private static Method f833b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f832a = cls.getMethod("getScript", new Class[]{String.class});
                f833b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f832a = null;
            f833b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m1445a(Locale locale) {
        String b = ICUCompatIcs.m1446b(locale);
        if (b != null) {
            return ICUCompatIcs.m1444a(b);
        }
        return null;
    }

    private static String m1444a(String str) {
        try {
            if (f832a != null) {
                return (String) f832a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String m1446b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f833b != null) {
                return (String) f833b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
