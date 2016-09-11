package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent extends C0314h implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4465a;
    private final long f4466b;
    private int f4467c;
    private final String f4468d;
    private final String f4469e;
    private final String f4470f;
    private final String f4471g;
    private final String f4472h;
    private final String f4473i;
    private final long f4474j;
    private final long f4475k;
    private long f4476l;

    static {
        CREATOR = new C0315a();
    }

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f4465a = i;
        this.f4466b = j;
        this.f4467c = i2;
        this.f4468d = str;
        this.f4469e = str2;
        this.f4470f = str3;
        this.f4471g = str4;
        this.f4476l = -1;
        this.f4472h = str5;
        this.f4473i = str6;
        this.f4474j = j2;
        this.f4475k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public long m8003a() {
        return this.f4466b;
    }

    public int m8004b() {
        return this.f4467c;
    }

    public String m8005c() {
        return this.f4468d;
    }

    public String m8006d() {
        return this.f4469e;
    }

    public int describeContents() {
        return 0;
    }

    public String m8007e() {
        return this.f4470f;
    }

    public String m8008f() {
        return this.f4471g;
    }

    public String m8009g() {
        return this.f4472h;
    }

    public String m8010h() {
        return this.f4473i;
    }

    public long m8011i() {
        return this.f4476l;
    }

    public long m8012j() {
        return this.f4475k;
    }

    public long m8013k() {
        return this.f4474j;
    }

    public String m8014l() {
        return "\t" + m8005c() + "/" + m8006d() + "\t" + m8007e() + "/" + m8008f() + "\t" + (this.f4472h == null ? "" : this.f4472h) + "\t" + m8012j();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0315a.m8029a(this, parcel, i);
    }
}
