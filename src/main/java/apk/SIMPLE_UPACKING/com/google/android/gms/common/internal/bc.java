package com.google.android.gms.common.internal;

import java.util.Arrays;

public final class bc {
    public static int m7869a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static be m7870a(Object obj) {
        return new be(null);
    }

    public static boolean m7871a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
