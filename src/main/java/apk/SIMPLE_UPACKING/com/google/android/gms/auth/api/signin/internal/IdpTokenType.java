package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdpTokenType implements SafeParcelable {
    public static final Creator CREATOR;
    public static final IdpTokenType f3293a;
    public static final IdpTokenType f3294b;
    final int f3295c;
    private final String f3296d;

    static {
        f3293a = new IdpTokenType("accessToken");
        f3294b = new IdpTokenType("idToken");
        CREATOR = new C0180t();
    }

    IdpTokenType(int i, String str) {
        this.f3295c = i;
        this.f3296d = bf.m7875a(str);
    }

    private IdpTokenType(String str) {
        this(1, str);
    }

    public String m5898a() {
        return this.f3296d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.f3296d.equals(((IdpTokenType) obj).m5898a());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return this.f3296d.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0180t.m6041a(this, parcel, i);
    }
}
