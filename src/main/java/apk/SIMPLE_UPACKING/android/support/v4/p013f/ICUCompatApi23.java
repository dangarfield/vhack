package android.support.v4.p013f;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.f.f */
class ICUCompatApi23 {
    private static Method f831a;

    static {
        try {
            f831a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m1443a(Locale locale) {
        try {
            return ((Locale) f831a.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
