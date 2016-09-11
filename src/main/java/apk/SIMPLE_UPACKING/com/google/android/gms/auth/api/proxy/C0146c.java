package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.proxy.c */
public class C0146c implements Creator {
    static void m5820a(ProxyRequest proxyRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7957a(parcel, 1, proxyRequest.f3231k, false);
        C0300c.m7949a(parcel, 1000, proxyRequest.f3230j);
        C0300c.m7949a(parcel, 2, proxyRequest.f3232l);
        C0300c.m7950a(parcel, 3, proxyRequest.f3233m);
        C0300c.m7960a(parcel, 4, proxyRequest.f3234n, false);
        C0300c.m7951a(parcel, 5, proxyRequest.f3235o, false);
        C0300c.m7947a(parcel, a);
    }

    public ProxyRequest m5821a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = C0298a.m7928b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    j = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    bArr = C0298a.m7942m(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    bundle = C0298a.m7941l(parcel, a);
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
            return new ProxyRequest(i2, str, i, j, bArr, bundle);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ProxyRequest[] m5822a(int i) {
        return new ProxyRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5821a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5822a(i);
    }
}
