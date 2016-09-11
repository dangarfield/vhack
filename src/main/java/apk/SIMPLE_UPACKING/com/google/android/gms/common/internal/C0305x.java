package com.google.android.gms.common.internal;

import android.accounts.Account;
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

/* renamed from: com.google.android.gms.common.internal.x */
public class C0305x implements Creator {
    static void m7985a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, getServiceRequest.f4343a);
        C0300c.m7949a(parcel, 2, getServiceRequest.f4344b);
        C0300c.m7949a(parcel, 3, getServiceRequest.f4345c);
        C0300c.m7957a(parcel, 4, getServiceRequest.f4346d, false);
        C0300c.m7952a(parcel, 5, getServiceRequest.f4347e, false);
        C0300c.m7961a(parcel, 6, getServiceRequest.f4348f, i, false);
        C0300c.m7951a(parcel, 7, getServiceRequest.f4349g, false);
        C0300c.m7953a(parcel, 8, getServiceRequest.f4350h, i, false);
        C0300c.m7947a(parcel, a);
    }

    public GetServiceRequest m7986a(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = C0298a.m7928b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    iBinder = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    scopeArr = (Scope[]) C0298a.m7930b(parcel, a, Scope.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    bundle = C0298a.m7941l(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    account = (Account) C0298a.m7925a(parcel, a, Account.CREATOR);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public GetServiceRequest[] m7987a(int i) {
        return new GetServiceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7986a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7987a(i);
    }
}
