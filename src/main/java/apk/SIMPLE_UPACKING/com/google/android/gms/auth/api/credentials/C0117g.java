package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.credentials.g */
public class C0117g implements Creator {
    static void m5705a(CredentialPickerConfig credentialPickerConfig, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7959a(parcel, 1, credentialPickerConfig.m5676a());
        C0300c.m7949a(parcel, 1000, credentialPickerConfig.f3147a);
        C0300c.m7959a(parcel, 2, credentialPickerConfig.m5677b());
        C0300c.m7959a(parcel, 3, credentialPickerConfig.m5678c());
        C0300c.m7947a(parcel, a);
    }

    public CredentialPickerConfig m5706a(Parcel parcel) {
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    z3 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    z = C0298a.m7932c(parcel, a);
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
            return new CredentialPickerConfig(i, z3, z2, z);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public CredentialPickerConfig[] m5707a(int i) {
        return new CredentialPickerConfig[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5706a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5707a(i);
    }
}
