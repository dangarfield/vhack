package com.google.android.gms.p051b;

import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.ar */
public abstract class ar {
    @fi
    public static final ar f3453a;
    @fi
    public static final ar f3454b;
    @fi
    public static final ar f3455c;

    static {
        f3453a = new as();
        f3454b = new at();
        f3455c = new au();
    }

    public abstract String m6115a(String str, String str2);

    public final void m6116a(Map map, String str, String str2) {
        map.put(str, m6115a((String) map.get(str), str2));
    }
}
