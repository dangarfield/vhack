package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.j */
public class C0323j implements Creator {
    static void m8050a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, wakeLockEvent.f4477a);
        C0300c.m7950a(parcel, 2, wakeLockEvent.m8015a());
        C0300c.m7957a(parcel, 4, wakeLockEvent.m8017c(), false);
        C0300c.m7949a(parcel, 5, wakeLockEvent.m8019e());
        C0300c.m7966b(parcel, 6, wakeLockEvent.m8020f(), false);
        C0300c.m7950a(parcel, 8, wakeLockEvent.m8022h());
        C0300c.m7957a(parcel, 10, wakeLockEvent.m8018d(), false);
        C0300c.m7949a(parcel, 11, wakeLockEvent.m8016b());
        C0300c.m7957a(parcel, 12, wakeLockEvent.m8021g(), false);
        C0300c.m7957a(parcel, 13, wakeLockEvent.m8025k(), false);
        C0300c.m7949a(parcel, 14, wakeLockEvent.m8024j());
        C0300c.m7948a(parcel, 15, wakeLockEvent.m8027m());
        C0300c.m7950a(parcel, 16, wakeLockEvent.m8028n());
        C0300c.m7947a(parcel, a);
    }

    public WakeLockEvent m8051a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
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
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    list = C0298a.m7945p(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    j2 = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                    i4 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                    f = C0298a.m7937h(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                    j3 = C0298a.m7935f(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public WakeLockEvent[] m8052a(int i) {
        return new WakeLockEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8051a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8052a(i);
    }
}
