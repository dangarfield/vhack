package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.credentials.h */
public class C0118h implements Creator {
    static void m5708a(CredentialRequest credentialRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7959a(parcel, 1, credentialRequest.m5679a());
        C0300c.m7949a(parcel, 1000, credentialRequest.f3151a);
        C0300c.m7962a(parcel, 2, credentialRequest.m5680b(), false);
        C0300c.m7953a(parcel, 3, credentialRequest.m5681c(), i, false);
        C0300c.m7953a(parcel, 4, credentialRequest.m5682d(), i, false);
        C0300c.m7947a(parcel, a);
    }

    public CredentialRequest m5709a(Parcel parcel) {
        boolean z = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int b = C0298a.m7928b(parcel);
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] strArr = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    strArr = C0298a.m7943n(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    credentialPickerConfig2 = (CredentialPickerConfig) C0298a.m7925a(parcel, a, CredentialPickerConfig.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    credentialPickerConfig = (CredentialPickerConfig) C0298a.m7925a(parcel, a, CredentialPickerConfig.CREATOR);
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
            return new CredentialRequest(i, z, strArr, credentialPickerConfig2, credentialPickerConfig);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public CredentialRequest[] m5710a(int i) {
        return new CredentialRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5709a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5710a(i);
    }
}
