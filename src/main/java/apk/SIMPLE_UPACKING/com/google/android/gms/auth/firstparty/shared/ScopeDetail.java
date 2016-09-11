package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail implements SafeParcelable {
    public static final C0193c CREATOR;
    final int f3370a;
    String f3371b;
    String f3372c;
    String f3373d;
    String f3374e;
    String f3375f;
    List f3376g;
    public FACLData f3377h;

    static {
        CREATOR = new C0193c();
    }

    ScopeDetail(int i, String str, String str2, String str3, String str4, String str5, List list, FACLData fACLData) {
        this.f3370a = i;
        this.f3371b = str;
        this.f3372c = str2;
        this.f3373d = str3;
        this.f3374e = str4;
        this.f3375f = str5;
        this.f3376g = list;
        this.f3377h = fACLData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0193c.m6062a(this, parcel, i);
    }
}
