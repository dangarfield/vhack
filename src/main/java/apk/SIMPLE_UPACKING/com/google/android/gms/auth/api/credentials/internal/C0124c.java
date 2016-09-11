package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.credentials.internal.c */
public class C0124c implements Creator {
    static void m5775a(DeleteRequest deleteRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7953a(parcel, 1, deleteRequest.m5714a(), i, false);
        C0300c.m7949a(parcel, 1000, deleteRequest.f3177a);
        C0300c.m7947a(parcel, a);
    }

    public DeleteRequest m5776a(Parcel parcel) {
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
            return new DeleteRequest(i, credential);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public DeleteRequest[] m5777a(int i) {
        return new DeleteRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5776a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5777a(i);
    }
}
