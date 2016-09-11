package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class ae implements Creator {
    static void m8250a(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, userAttributeParcel.f4634a);
        C0300c.m7957a(parcel, 2, userAttributeParcel.f4635b, false);
        C0300c.m7950a(parcel, 3, userAttributeParcel.f4636c);
        C0300c.m7956a(parcel, 4, userAttributeParcel.f4637d, false);
        C0300c.m7954a(parcel, 5, userAttributeParcel.f4638e, false);
        C0300c.m7957a(parcel, 6, userAttributeParcel.f4639f, false);
        C0300c.m7957a(parcel, 7, userAttributeParcel.f4640g, false);
        C0300c.m7947a(parcel, a);
    }

    public UserAttributeParcel m8251a(Parcel parcel) {
        String str = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    j = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    l = C0298a.m7936g(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    f = C0298a.m7938i(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public UserAttributeParcel[] m8252a(int i) {
        return new UserAttributeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8251a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8252a(i);
    }
}
