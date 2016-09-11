package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.common.i */
public class C0277i implements Creator {
    static void m7682a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, connectionResult.f4123b);
        C0300c.m7949a(parcel, 2, connectionResult.m7281c());
        C0300c.m7953a(parcel, 3, connectionResult.m7282d(), i, false);
        C0300c.m7957a(parcel, 4, connectionResult.m7283e(), false);
        C0300c.m7947a(parcel, a);
    }

    public ConnectionResult m7683a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C0298a.m7928b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = C0298a.m7923a(parcel);
            String str3;
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = C0298a.m7933d(parcel, a);
                    str2 = str3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = C0298a.m7933d(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) C0298a.m7925a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str2 = C0298a.m7939j(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m7684a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7683a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7684a(i);
    }
}
