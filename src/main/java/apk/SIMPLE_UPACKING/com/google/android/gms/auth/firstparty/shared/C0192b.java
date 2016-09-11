package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.firstparty.shared.b */
public class C0192b implements Creator {
    static void m6059a(FACLData fACLData, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, fACLData.f3365a);
        C0300c.m7953a(parcel, 2, fACLData.f3366b, i, false);
        C0300c.m7957a(parcel, 3, fACLData.f3367c, false);
        C0300c.m7959a(parcel, 4, fACLData.f3368d);
        C0300c.m7957a(parcel, 5, fACLData.f3369e, false);
        C0300c.m7947a(parcel, a);
    }

    public FACLData m6060a(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = C0298a.m7928b(parcel);
        String str2 = null;
        FACLConfig fACLConfig = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    fACLConfig = (FACLConfig) C0298a.m7925a(parcel, a, FACLConfig.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FACLData(i, fACLConfig, str2, z, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public FACLData[] m6061a(int i) {
        return new FACLData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6060a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6061a(i);
    }
}
