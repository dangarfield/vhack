package com.google.android.gms.p051b;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.b.ai */
final class ai extends ae {
    ai(int i, String str, String str2) {
        super(str, str2, null);
    }

    public /* synthetic */ Object m6100a(SharedPreferences sharedPreferences) {
        return m6101b(sharedPreferences);
    }

    public String m6101b(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(m6091a(), (String) m6092b());
    }
}
