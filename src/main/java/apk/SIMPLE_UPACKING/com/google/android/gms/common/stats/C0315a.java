package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.common.stats.a */
public class C0315a implements Creator {
    static void m8029a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, connectionEvent.f4465a);
        C0300c.m7950a(parcel, 2, connectionEvent.m8003a());
        C0300c.m7957a(parcel, 4, connectionEvent.m8005c(), false);
        C0300c.m7957a(parcel, 5, connectionEvent.m8006d(), false);
        C0300c.m7957a(parcel, 6, connectionEvent.m8007e(), false);
        C0300c.m7957a(parcel, 7, connectionEvent.m8008f(), false);
        C0300c.m7957a(parcel, 8, connectionEvent.m8009g(), false);
        C0300c.m7950a(parcel, 10, connectionEvent.m8013k());
        C0300c.m7950a(parcel, 11, connectionEvent.m8012j());
        C0300c.m7949a(parcel, 12, connectionEvent.m8004b());
        C0300c.m7957a(parcel, 13, connectionEvent.m8010h(), false);
        C0300c.m7947a(parcel, a);
    }

    public ConnectionEvent m8030a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    j = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    str5 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    j2 = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                    j3 = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                    str6 = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ConnectionEvent[] m8031a(int i) {
        return new ConnectionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8030a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8031a(i);
    }
}
