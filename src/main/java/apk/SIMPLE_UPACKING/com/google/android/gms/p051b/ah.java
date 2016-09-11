package com.google.android.gms.p051b;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.b.ah */
final class ah extends ae {
    ah(int i, String str, Long l) {
        super(str, l, null);
    }

    public /* synthetic */ Object m6098a(SharedPreferences sharedPreferences) {
        return m6099b(sharedPreferences);
    }

    public Long m6099b(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(m6091a(), ((Long) m6092b()).longValue()));
    }
}
