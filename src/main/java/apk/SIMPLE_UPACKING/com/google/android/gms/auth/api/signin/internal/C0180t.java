package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.signin.internal.t */
public class C0180t implements Creator {
    static void m6041a(IdpTokenType idpTokenType, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, idpTokenType.f3295c);
        C0300c.m7957a(parcel, 2, idpTokenType.m5898a(), false);
        C0300c.m7947a(parcel, a);
    }

    public IdpTokenType m6042a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new IdpTokenType(i, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public IdpTokenType[] m6043a(int i) {
        return new IdpTokenType[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6042a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6043a(i);
    }
}
