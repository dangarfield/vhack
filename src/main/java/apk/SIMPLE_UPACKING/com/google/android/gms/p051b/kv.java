package com.google.android.gms.p051b;

import android.os.IInterface;
import com.google.android.gms.p047a.C0002a;

/* renamed from: com.google.android.gms.b.kv */
public interface kv extends IInterface {
    boolean getBooleanFlagValue(String str, boolean z, int i);

    int getIntFlagValue(String str, int i, int i2);

    long getLongFlagValue(String str, long j, int i);

    String getStringFlagValue(String str, String str2, int i);

    void init(C0002a c0002a);
}
