package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.common.internal.e */
public class C0283e implements Creator {
    static void m7894a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, authAccountRequest.f4338a);
        C0300c.m7952a(parcel, 2, authAccountRequest.f4339b, false);
        C0300c.m7961a(parcel, 3, authAccountRequest.f4340c, i, false);
        C0300c.m7955a(parcel, 4, authAccountRequest.f4341d, false);
        C0300c.m7955a(parcel, 5, authAccountRequest.f4342e, false);
        C0300c.m7947a(parcel, a);
    }

    public AuthAccountRequest m7895a(Parcel parcel) {
        Integer num = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    iBinder = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    scopeArr = (Scope[]) C0298a.m7930b(parcel, a, Scope.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    num2 = C0298a.m7934e(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    num = C0298a.m7934e(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountRequest[] m7896a(int i) {
        return new AuthAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7895a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7896a(i);
    }
}
