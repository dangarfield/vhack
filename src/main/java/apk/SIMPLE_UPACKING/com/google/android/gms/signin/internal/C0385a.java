package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.signin.internal.a */
public class C0385a implements Creator {
    static void m8952a(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, authAccountResult.f4957a);
        C0300c.m7949a(parcel, 2, authAccountResult.m8944b());
        C0300c.m7953a(parcel, 3, authAccountResult.m8945c(), i, false);
        C0300c.m7947a(parcel, a);
    }

    public AuthAccountResult m8953a(Parcel parcel) {
        int i = 0;
        int b = C0298a.m7928b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    intent = (Intent) C0298a.m7925a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountResult[] m8954a(int i) {
        return new AuthAccountResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8953a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8954a(i);
    }
}
