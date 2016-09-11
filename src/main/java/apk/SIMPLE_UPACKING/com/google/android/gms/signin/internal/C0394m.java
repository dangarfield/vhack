package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.signin.internal.m */
public class C0394m implements Creator {
    static void m8999a(SignInRequest signInRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, signInRequest.f4967a);
        C0300c.m7953a(parcel, 2, signInRequest.m8949a(), i, false);
        C0300c.m7947a(parcel, a);
    }

    public SignInRequest m9000a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    resolveAccountRequest = (ResolveAccountRequest) C0298a.m7925a(parcel, a, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public SignInRequest[] m9001a(int i) {
        return new SignInRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9000a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9001a(i);
    }
}
