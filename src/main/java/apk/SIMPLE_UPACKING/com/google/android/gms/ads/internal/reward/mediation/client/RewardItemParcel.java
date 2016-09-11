package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.fi;

@fi
public final class RewardItemParcel implements SafeParcelable {
    public static final C0097d CREATOR;
    public final int f3087a;
    public final String f3088b;
    public final int f3089c;

    static {
        CREATOR = new C0097d();
    }

    public RewardItemParcel(int i, String str, int i2) {
        this.f3087a = i;
        this.f3088b = str;
        this.f3089c = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RewardItemParcel)) {
            return false;
        }
        RewardItemParcel rewardItemParcel = (RewardItemParcel) obj;
        return bc.m7871a(this.f3088b, rewardItemParcel.f3088b) && bc.m7871a(Integer.valueOf(this.f3089c), Integer.valueOf(rewardItemParcel.f3089c));
    }

    public int hashCode() {
        return bc.m7869a(this.f3088b, Integer.valueOf(this.f3089c));
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0097d.m5625a(this, parcel, i);
    }
}
