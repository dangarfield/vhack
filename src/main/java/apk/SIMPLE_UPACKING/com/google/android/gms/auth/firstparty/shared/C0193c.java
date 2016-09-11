package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.auth.firstparty.shared.c */
public class C0193c implements Creator {
    static void m6062a(ScopeDetail scopeDetail, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, scopeDetail.f3370a);
        C0300c.m7957a(parcel, 2, scopeDetail.f3371b, false);
        C0300c.m7957a(parcel, 3, scopeDetail.f3372c, false);
        C0300c.m7957a(parcel, 4, scopeDetail.f3373d, false);
        C0300c.m7957a(parcel, 5, scopeDetail.f3374e, false);
        C0300c.m7957a(parcel, 6, scopeDetail.f3375f, false);
        C0300c.m7966b(parcel, 7, scopeDetail.f3376g, false);
        C0300c.m7953a(parcel, 8, scopeDetail.f3377h, i, false);
        C0300c.m7947a(parcel, a);
    }

    public ScopeDetail m6063a(Parcel parcel) {
        FACLData fACLData = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        List arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str5 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    arrayList = C0298a.m7945p(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    fACLData = (FACLData) C0298a.m7925a(parcel, a, FACLData.CREATOR);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ScopeDetail(i, str5, str4, str3, str2, str, arrayList, fACLData);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ScopeDetail[] m6064a(int i) {
        return new ScopeDetail[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6063a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6064a(i);
    }
}
