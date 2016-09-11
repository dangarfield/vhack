package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.firstparty.shared.a */
public class C0191a implements Creator {
    static void m6056a(FACLConfig fACLConfig, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, fACLConfig.f3358a);
        C0300c.m7959a(parcel, 2, fACLConfig.f3359b);
        C0300c.m7957a(parcel, 3, fACLConfig.f3360c, false);
        C0300c.m7959a(parcel, 4, fACLConfig.f3361d);
        C0300c.m7959a(parcel, 5, fACLConfig.f3362e);
        C0300c.m7959a(parcel, 6, fACLConfig.f3363f);
        C0300c.m7959a(parcel, 7, fACLConfig.f3364g);
        C0300c.m7947a(parcel, a);
    }

    public FACLConfig m6057a(Parcel parcel) {
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    z5 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    z4 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z3 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FACLConfig(i, z5, str, z4, z3, z2, z);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public FACLConfig[] m6058a(int i) {
        return new FACLConfig[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6057a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6058a(i);
    }
}
