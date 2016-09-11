package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p047a.C0003b;
import com.google.android.gms.p047a.C0005d;
import com.google.android.gms.p051b.eq;
import com.google.android.gms.p051b.fi;

@fi
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final C0080a CREATOR;
    public final int f3060a;
    public final C0088i f3061b;
    public final eq f3062c;
    public final Context f3063d;
    public final C0087h f3064e;

    static {
        CREATOR = new C0080a();
    }

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.f3060a = i;
        this.f3061b = (C0088i) C0005d.m5324a(C0003b.m5322a(iBinder));
        this.f3062c = (eq) C0005d.m5324a(C0003b.m5322a(iBinder2));
        this.f3063d = (Context) C0005d.m5324a(C0003b.m5322a(iBinder3));
        this.f3064e = (C0087h) C0005d.m5324a(C0003b.m5322a(iBinder4));
    }

    public static GInAppPurchaseManagerInfoParcel m5561a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder m5562a() {
        return C0005d.m5323a(this.f3064e).asBinder();
    }

    IBinder m5563b() {
        return C0005d.m5323a(this.f3061b).asBinder();
    }

    IBinder m5564c() {
        return C0005d.m5323a(this.f3062c).asBinder();
    }

    IBinder m5565d() {
        return C0005d.m5323a(this.f3063d).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0080a.m5566a(this, parcel, i);
    }
}
