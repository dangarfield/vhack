package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.credentials.i */
public class C0119i implements Creator {
    static void m5711a(IdToken idToken, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7957a(parcel, 1, idToken.m5683a(), false);
        C0300c.m7949a(parcel, 1000, idToken.f3156a);
        C0300c.m7957a(parcel, 2, idToken.m5684b(), false);
        C0300c.m7947a(parcel, a);
    }

    public IdToken m5712a(Parcel parcel) {
        String str = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case 1000:
                    i = C0298a.m7933d(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new IdToken(i, str2, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public IdToken[] m5713a(int i) {
        return new IdToken[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5712a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5713a(i);
    }
}
