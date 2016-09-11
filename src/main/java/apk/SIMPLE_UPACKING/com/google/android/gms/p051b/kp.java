package com.google.android.gms.p051b;

import com.google.android.gms.common.internal.C0285g;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.b.kp */
public class kp {
    private static final Pattern f3870a;

    static {
        f3870a = Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean m6946a(String str) {
        return str == null || C0285g.f4421a.m7903b((CharSequence) str);
    }
}
