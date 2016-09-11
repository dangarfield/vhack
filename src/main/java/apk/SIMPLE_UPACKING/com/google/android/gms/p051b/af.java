package com.google.android.gms.p051b;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.b.af */
final class af extends ae {
    af(int i, String str, Boolean bool) {
        super(str, bool, null);
    }

    public /* synthetic */ Object m6094a(SharedPreferences sharedPreferences) {
        return m6095b(sharedPreferences);
    }

    public Boolean m6095b(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(m6091a(), ((Boolean) m6092b()).booleanValue()));
    }
}
