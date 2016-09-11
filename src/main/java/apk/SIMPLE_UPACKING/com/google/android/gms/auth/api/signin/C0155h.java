package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.auth.api.signin.h */
public enum C0155h {
    GOOGLE("google.com", C0001R.string.auth_google_play_services_client_google_display_name, "https://accounts.google.com"),
    FACEBOOK("facebook.com", C0001R.string.auth_google_play_services_client_facebook_display_name, "https://www.facebook.com");
    
    private final String f3290c;
    private final int f3291d;
    private final String f3292e;

    private C0155h(String str, int i, String str2) {
        this.f3290c = str;
        this.f3291d = i;
        this.f3292e = str2;
    }

    public static C0155h m5892a(String str) {
        if (str != null) {
            for (C0155h c0155h : C0155h.values()) {
                if (c0155h.m5894a().equals(str)) {
                    return c0155h;
                }
            }
            Log.w("IdProvider", "Unrecognized providerId: " + str);
        }
        return null;
    }

    public CharSequence m5893a(Context context) {
        return context.getResources().getString(this.f3291d);
    }

    public String m5894a() {
        return this.f3290c;
    }

    public String toString() {
        return this.f3290c;
    }
}
