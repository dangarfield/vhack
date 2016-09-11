package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.common.internal.c */
public class C0281c implements Creator {
    static void m7890a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, validateAccountRequest.f4360a);
        C0300c.m7949a(parcel, 2, validateAccountRequest.m7698a());
        C0300c.m7952a(parcel, 3, validateAccountRequest.f4361b, false);
        C0300c.m7961a(parcel, 4, validateAccountRequest.m7699b(), i, false);
        C0300c.m7951a(parcel, 5, validateAccountRequest.m7701d(), false);
        C0300c.m7957a(parcel, 6, validateAccountRequest.m7700c(), false);
        C0300c.m7947a(parcel, a);
    }

    public ValidateAccountRequest m7891a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = C0298a.m7928b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    scopeArr = (Scope[]) C0298a.m7930b(parcel, a, Scope.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    bundle = C0298a.m7941l(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ValidateAccountRequest[] m7892a(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7891a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7892a(i);
    }
}
