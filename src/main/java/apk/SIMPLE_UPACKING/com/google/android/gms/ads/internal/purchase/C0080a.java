package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.purchase.a */
public class C0080a implements Creator {
    static void m5566a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, gInAppPurchaseManagerInfoParcel.f3060a);
        C0300c.m7952a(parcel, 3, gInAppPurchaseManagerInfoParcel.m5563b(), false);
        C0300c.m7952a(parcel, 4, gInAppPurchaseManagerInfoParcel.m5564c(), false);
        C0300c.m7952a(parcel, 5, gInAppPurchaseManagerInfoParcel.m5565d(), false);
        C0300c.m7952a(parcel, 6, gInAppPurchaseManagerInfoParcel.m5562a(), false);
        C0300c.m7947a(parcel, a);
    }

    public GInAppPurchaseManagerInfoParcel m5567a(Parcel parcel) {
        IBinder iBinder = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    iBinder4 = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    iBinder3 = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    iBinder2 = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    iBinder = C0298a.m7940k(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public GInAppPurchaseManagerInfoParcel[] m5568a(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5567a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5568a(i);
    }
}
