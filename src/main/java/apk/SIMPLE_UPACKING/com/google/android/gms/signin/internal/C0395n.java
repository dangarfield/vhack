package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.signin.internal.n */
public class C0395n implements Creator {
    static void m9002a(SignInResponse signInResponse, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, signInResponse.f4969a);
        C0300c.m7953a(parcel, 2, signInResponse.m8950a(), i, false);
        C0300c.m7953a(parcel, 3, signInResponse.m8951b(), i, false);
        C0300c.m7947a(parcel, a);
    }

    public SignInResponse m9003a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int d;
            ResolveAccountResponse resolveAccountResponse2;
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    d = C0298a.m7933d(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    d = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) C0298a.m7925a(parcel, a, ConnectionResult.CREATOR);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    resolveAccountResponse2 = (ResolveAccountResponse) C0298a.m7925a(parcel, a, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
            }
            i = d;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() == b) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public SignInResponse[] m9004a(int i) {
        return new SignInResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9003a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9004a(i);
    }
}
