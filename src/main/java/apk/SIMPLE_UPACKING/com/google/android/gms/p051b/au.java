package com.google.android.gms.p051b;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.b.au */
final class au extends ar {
    au() {
    }

    private String m6119a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    public String m6120a(String str, String str2) {
        String a = m6119a(str);
        String a2 = m6119a(str2);
        return TextUtils.isEmpty(a) ? a2 : TextUtils.isEmpty(a2) ? a : a + "," + a2;
    }
}
