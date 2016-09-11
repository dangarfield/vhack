package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

/* renamed from: com.google.android.gms.auth.api.credentials.j */
public class C0133j implements Creator {
    static void m5802a(PasswordSpecification passwordSpecification, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7957a(parcel, 1, passwordSpecification.f3162d, false);
        C0300c.m7949a(parcel, 1000, passwordSpecification.f3161c);
        C0300c.m7966b(parcel, 2, passwordSpecification.f3163e, false);
        C0300c.m7958a(parcel, 3, passwordSpecification.f3164f, false);
        C0300c.m7949a(parcel, 4, passwordSpecification.f3165g);
        C0300c.m7949a(parcel, 5, passwordSpecification.f3166h);
        C0300c.m7947a(parcel, a);
    }

    public PasswordSpecification m5803a(Parcel parcel) {
        List list = null;
        int i = 0;
        int b = C0298a.m7928b(parcel);
        int i2 = 0;
        List list2 = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    list2 = C0298a.m7945p(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    list = C0298a.m7944o(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case 1000:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PasswordSpecification(i3, str, list2, list, i2, i);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public PasswordSpecification[] m5804a(int i) {
        return new PasswordSpecification[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5803a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5804a(i);
    }
}
