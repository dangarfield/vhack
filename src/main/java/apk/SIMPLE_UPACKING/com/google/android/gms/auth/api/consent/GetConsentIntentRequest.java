package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetConsentIntentRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final ScopeDetail[] f3129a;
    private final int f3130b;
    private final String f3131c;
    private final int f3132d;
    private final String f3133e;
    private final Account f3134f;
    private final boolean f3135g;
    private final int f3136h;
    private final String f3137i;

    static {
        CREATOR = new C0110b();
    }

    GetConsentIntentRequest(int i, String str, int i2, String str2, Account account, ScopeDetail[] scopeDetailArr, boolean z, int i3, String str3) {
        this.f3130b = i;
        this.f3131c = str;
        this.f3132d = i2;
        this.f3133e = str2;
        this.f3134f = (Account) bf.m7873a((Object) account);
        this.f3129a = scopeDetailArr;
        this.f3135g = z;
        this.f3136h = i3;
        this.f3137i = str3;
    }

    public int m5657a() {
        return this.f3130b;
    }

    public String m5658b() {
        return this.f3131c;
    }

    public int m5659c() {
        return this.f3132d;
    }

    public String m5660d() {
        return this.f3133e;
    }

    public int describeContents() {
        return 0;
    }

    public Account m5661e() {
        return this.f3134f;
    }

    public boolean m5662f() {
        return this.f3135g;
    }

    public int m5663g() {
        return this.f3136h;
    }

    public String m5664h() {
        return this.f3137i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0110b.m5665a(this, parcel, i);
    }
}
