package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class ad implements Creator {
    static void m7303a(Status status, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, status.m7293f());
        C0300c.m7949a(parcel, 1000, status.m7291d());
        C0300c.m7957a(parcel, 2, status.m7290c(), false);
        C0300c.m7953a(parcel, 3, status.m7289b(), i, false);
        C0300c.m7947a(parcel, a);
    }

    public Status m7304a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = C0298a.m7928b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    pendingIntent = (PendingIntent) C0298a.m7925a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public Status[] m7305a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7304a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7305a(i);
    }
}
