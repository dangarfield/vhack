package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.credentials.internal.d */
public class C0125d implements Creator {
    static void m5778a(GeneratePasswordRequest generatePasswordRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7953a(parcel, 1, generatePasswordRequest.m5715a(), i, false);
        C0300c.m7949a(parcel, 1000, generatePasswordRequest.f3179a);
        C0300c.m7947a(parcel, a);
    }

    public GeneratePasswordRequest m5779a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        PasswordSpecification passwordSpecification = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    passwordSpecification = (PasswordSpecification) C0298a.m7925a(parcel, a, PasswordSpecification.CREATOR);
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
            return new GeneratePasswordRequest(i, passwordSpecification);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public GeneratePasswordRequest[] m5780a(int i) {
        return new GeneratePasswordRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5779a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5780a(i);
    }
}
