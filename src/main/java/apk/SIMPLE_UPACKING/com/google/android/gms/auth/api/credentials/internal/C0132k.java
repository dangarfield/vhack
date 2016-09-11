package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.credentials.internal.k */
public class C0132k implements Creator {
    static void m5799a(SaveRequest saveRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7953a(parcel, 1, saveRequest.m5716a(), i, false);
        C0300c.m7949a(parcel, 1000, saveRequest.f3181a);
        C0300c.m7947a(parcel, a);
    }

    public SaveRequest m5800a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        Credential credential = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    credential = (Credential) C0298a.m7925a(parcel, a, Credential.CREATOR);
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
            return new SaveRequest(i, credential);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public SaveRequest[] m5801a(int i) {
        return new SaveRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5800a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5801a(i);
    }
}
