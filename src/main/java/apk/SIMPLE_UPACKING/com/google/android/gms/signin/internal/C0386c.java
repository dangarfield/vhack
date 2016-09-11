package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

/* renamed from: com.google.android.gms.signin.internal.c */
public class C0386c implements Creator {
    static void m8955a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, checkServerAuthResult.f4960a);
        C0300c.m7959a(parcel, 2, checkServerAuthResult.f4961b);
        C0300c.m7968c(parcel, 3, checkServerAuthResult.f4962c, false);
        C0300c.m7947a(parcel, a);
    }

    public CheckServerAuthResult m8956a(Parcel parcel) {
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    list = C0298a.m7931c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public CheckServerAuthResult[] m8957a(int i) {
        return new CheckServerAuthResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8956a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8957a(i);
    }
}
