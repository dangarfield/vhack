package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class PasswordSpecification implements SafeParcelable {
    public static final C0133j CREATOR;
    public static final PasswordSpecification f3159a;
    public static final PasswordSpecification f3160b;
    final int f3161c;
    final String f3162d;
    final List f3163e;
    final List f3164f;
    final int f3165g;
    final int f3166h;
    private final int[] f3167i;
    private final Random f3168j;

    static {
        CREATOR = new C0133j();
        f3159a = new C0114d().m5699a(12, 16).m5700a("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").m5701a("abcdefghijkmnopqrstxyz", 1).m5701a("ABCDEFGHJKLMNPQRSTXY", 1).m5701a("3456789", 1).m5698a();
        f3160b = new C0114d().m5699a(12, 16).m5700a("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").m5701a("abcdefghijklmnopqrstuvwxyz", 1).m5701a("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).m5701a("1234567890", 1).m5698a();
    }

    PasswordSpecification(int i, String str, List list, List list2, int i2, int i3) {
        this.f3161c = i;
        this.f3162d = str;
        this.f3163e = Collections.unmodifiableList(list);
        this.f3164f = Collections.unmodifiableList(list2);
        this.f3165g = i2;
        this.f3166h = i3;
        this.f3167i = m5688a();
        this.f3168j = new SecureRandom();
    }

    private int m5685a(char c) {
        return c - 32;
    }

    private int[] m5688a() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String toCharArray : this.f3163e) {
            for (char a : toCharArray.toCharArray()) {
                iArr[m5685a(a)] = i;
            }
            i++;
        }
        return iArr;
    }

    private static String m5689b(Collection collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    private static boolean m5690b(int i, int i2, int i3) {
        return i < i2 || i > i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0133j.m5802a(this, parcel, i);
    }
}
