package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.proxy.d */
public class C0147d implements Creator {
    static void m5823a(ProxyResponse proxyResponse, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, proxyResponse.f3237b);
        C0300c.m7949a(parcel, 1000, proxyResponse.f3236a);
        C0300c.m7953a(parcel, 2, proxyResponse.f3238c, i, false);
        C0300c.m7949a(parcel, 3, proxyResponse.f3239d);
        C0300c.m7951a(parcel, 4, proxyResponse.f3240e, false);
        C0300c.m7960a(parcel, 5, proxyResponse.f3241f, false);
        C0300c.m7947a(parcel, a);
    }

    public ProxyResponse m5824a(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int b = C0298a.m7928b(parcel);
        Bundle bundle = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    pendingIntent = (PendingIntent) C0298a.m7925a(parcel, a, PendingIntent.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    bundle = C0298a.m7941l(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    bArr = C0298a.m7942m(parcel, a);
                    break;
                case 1000:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProxyResponse(i3, i2, pendingIntent, i, bundle, bArr);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ProxyResponse[] m5825a(int i) {
        return new ProxyResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5824a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5825a(i);
    }
}
