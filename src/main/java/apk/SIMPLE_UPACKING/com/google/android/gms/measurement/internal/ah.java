package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class ah implements Creator {
    static void m8309a(AppMetadata appMetadata, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, appMetadata.f4617a);
        C0300c.m7957a(parcel, 2, appMetadata.f4618b, false);
        C0300c.m7957a(parcel, 3, appMetadata.f4619c, false);
        C0300c.m7957a(parcel, 4, appMetadata.f4620d, false);
        C0300c.m7957a(parcel, 5, appMetadata.f4621e, false);
        C0300c.m7950a(parcel, 6, appMetadata.f4622f);
        C0300c.m7950a(parcel, 7, appMetadata.f4623g);
        C0300c.m7957a(parcel, 8, appMetadata.f4624h, false);
        C0300c.m7959a(parcel, 9, appMetadata.f4625i);
        C0300c.m7959a(parcel, 10, appMetadata.f4626j);
        C0300c.m7947a(parcel, a);
    }

    public AppMetadata m8310a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    j = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    j2 = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    str5 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z, z2);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public AppMetadata[] m8311a(int i) {
        return new AppMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8310a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8311a(i);
    }
}
