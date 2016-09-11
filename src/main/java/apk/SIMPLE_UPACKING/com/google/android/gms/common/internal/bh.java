package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class bh implements Creator {
    static void m7887a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, resolveAccountResponse.f4355a);
        C0300c.m7952a(parcel, 2, resolveAccountResponse.f4356b, false);
        C0300c.m7953a(parcel, 3, resolveAccountResponse.m7695b(), i, false);
        C0300c.m7959a(parcel, 4, resolveAccountResponse.m7696c());
        C0300c.m7959a(parcel, 5, resolveAccountResponse.m7697d());
        C0300c.m7947a(parcel, a);
    }

    public ResolveAccountResponse m7888a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) C0298a.m7925a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountResponse[] m7889a(int i) {
        return new ResolveAccountResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7888a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7889a(i);
    }
}
