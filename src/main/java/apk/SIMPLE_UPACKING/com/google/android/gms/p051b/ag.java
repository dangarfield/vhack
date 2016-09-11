package com.google.android.gms.p051b;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.b.ag */
final class ag extends ae {
    ag(int i, String str, Integer num) {
        super(str, num, null);
    }

    public /* synthetic */ Object m6096a(SharedPreferences sharedPreferences) {
        return m6097b(sharedPreferences);
    }

    public Integer m6097b(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(m6091a(), ((Integer) m6092b()).intValue()));
    }
}
