package android.support.v4.p013f;

import android.os.Build.VERSION;
import java.util.Locale;

/* renamed from: android.support.v4.f.h */
public final class TextUtilsCompat {
    public static final Locale f834a;
    private static final TextUtilsCompat f835b;
    private static String f836c;
    private static String f837d;

    static {
        if (VERSION.SDK_INT >= 17) {
            f835b = new TextUtilsCompat();
        } else {
            f835b = new TextUtilsCompat();
        }
        f834a = new Locale("", "");
        f836c = "Arab";
        f837d = "Hebr";
    }

    public static int m1447a(Locale locale) {
        return f835b.m1451a(locale);
    }
}
