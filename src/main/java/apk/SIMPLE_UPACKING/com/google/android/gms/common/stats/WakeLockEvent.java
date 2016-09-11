package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent extends C0314h implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4477a;
    private final long f4478b;
    private int f4479c;
    private final String f4480d;
    private final int f4481e;
    private final List f4482f;
    private final String f4483g;
    private final long f4484h;
    private int f4485i;
    private final String f4486j;
    private final String f4487k;
    private final float f4488l;
    private final long f4489m;
    private long f4490n;

    static {
        CREATOR = new C0323j();
    }

    WakeLockEvent(int i, long j, int i2, String str, int i3, List list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        this.f4477a = i;
        this.f4478b = j;
        this.f4479c = i2;
        this.f4480d = str;
        this.f4486j = str3;
        this.f4481e = i3;
        this.f4490n = -1;
        this.f4482f = list;
        this.f4483g = str2;
        this.f4484h = j2;
        this.f4485i = i4;
        this.f4487k = str4;
        this.f4488l = f;
        this.f4489m = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List list, String str2, long j2, int i3, String str3, String str4, float f, long j3) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3);
    }

    public long m8015a() {
        return this.f4478b;
    }

    public int m8016b() {
        return this.f4479c;
    }

    public String m8017c() {
        return this.f4480d;
    }

    public String m8018d() {
        return this.f4486j;
    }

    public int describeContents() {
        return 0;
    }

    public int m8019e() {
        return this.f4481e;
    }

    public List m8020f() {
        return this.f4482f;
    }

    public String m8021g() {
        return this.f4483g;
    }

    public long m8022h() {
        return this.f4484h;
    }

    public long m8023i() {
        return this.f4490n;
    }

    public int m8024j() {
        return this.f4485i;
    }

    public String m8025k() {
        return this.f4487k;
    }

    public String m8026l() {
        return "\t" + m8017c() + "\t" + m8019e() + "\t" + (m8020f() == null ? "" : TextUtils.join(",", m8020f())) + "\t" + m8024j() + "\t" + (m8018d() == null ? "" : m8018d()) + "\t" + (m8025k() == null ? "" : m8025k()) + "\t" + m8027m();
    }

    public float m8027m() {
        return this.f4488l;
    }

    public long m8028n() {
        return this.f4489m;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0323j.m8050a(this, parcel, i);
    }
}
