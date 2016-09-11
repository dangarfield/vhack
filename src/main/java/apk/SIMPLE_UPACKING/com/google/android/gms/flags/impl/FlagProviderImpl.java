package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.p047a.C0002a;
import com.google.android.gms.p047a.C0005d;
import com.google.android.gms.p051b.kw;

public class FlagProviderImpl extends kw {
    private boolean f4525a;
    private SharedPreferences f4526b;

    public FlagProviderImpl() {
        this.f4525a = false;
    }

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return C0326b.m8058a(this.f4526b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return C0328d.m8060a(this.f4526b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return C0330f.m8062a(this.f4526b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return C0332h.m8064a(this.f4526b, str, str2);
    }

    public void init(C0002a c0002a) {
        Context context = (Context) C0005d.m5324a(c0002a);
        if (!this.f4525a) {
            try {
                this.f4526b = C0334j.m8066a(context.createPackageContext("com.google.android.gms", 0));
                this.f4525a = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
