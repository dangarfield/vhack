package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.consent.b */
public class C0110b implements Creator {
    static void m5665a(GetConsentIntentRequest getConsentIntentRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, getConsentIntentRequest.m5657a());
        C0300c.m7957a(parcel, 2, getConsentIntentRequest.m5658b(), false);
        C0300c.m7949a(parcel, 3, getConsentIntentRequest.m5659c());
        C0300c.m7957a(parcel, 4, getConsentIntentRequest.m5660d(), false);
        C0300c.m7953a(parcel, 5, getConsentIntentRequest.m5661e(), i, false);
        C0300c.m7961a(parcel, 6, getConsentIntentRequest.f3129a, i, false);
        C0300c.m7959a(parcel, 7, getConsentIntentRequest.m5662f());
        C0300c.m7949a(parcel, 8, getConsentIntentRequest.m5663g());
        C0300c.m7957a(parcel, 9, getConsentIntentRequest.m5664h(), false);
        C0300c.m7947a(parcel, a);
    }

    public GetConsentIntentRequest m5666a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = C0298a.m7928b(parcel);
        boolean z = false;
        ScopeDetail[] scopeDetailArr = null;
        Account account = null;
        String str2 = null;
        int i2 = 0;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    account = (Account) C0298a.m7925a(parcel, a, Account.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    scopeDetailArr = (ScopeDetail[]) C0298a.m7930b(parcel, a, ScopeDetail.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetConsentIntentRequest(i3, str3, i2, str2, account, scopeDetailArr, z, i, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public GetConsentIntentRequest[] m5667a(int i) {
        return new GetConsentIntentRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5666a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5667a(i);
    }
}
