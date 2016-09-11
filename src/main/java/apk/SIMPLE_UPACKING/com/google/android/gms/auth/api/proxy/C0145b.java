package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.proxy.b */
public class C0145b implements Creator {
    static void m5817a(ProxyGrpcRequest proxyGrpcRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7957a(parcel, 1, proxyGrpcRequest.f3216b, false);
        C0300c.m7949a(parcel, 1000, proxyGrpcRequest.f3215a);
        C0300c.m7949a(parcel, 2, proxyGrpcRequest.f3217c);
        C0300c.m7950a(parcel, 3, proxyGrpcRequest.f3218d);
        C0300c.m7960a(parcel, 4, proxyGrpcRequest.f3219e, false);
        C0300c.m7957a(parcel, 5, proxyGrpcRequest.f3220f, false);
        C0300c.m7947a(parcel, a);
    }

    public ProxyGrpcRequest m5818a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = C0298a.m7928b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str2 = C0298a.m7939j(parcel, a);
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
                    str = C0298a.m7939j(parcel, a);
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
            return new ProxyGrpcRequest(i2, str2, i, j, bArr, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ProxyGrpcRequest[] m5819a(int i) {
        return new ProxyGrpcRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5818a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5819a(i);
    }
}
