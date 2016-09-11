package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.signin.internal.j */
public class C0391j implements Creator {
    static void m8984a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, recordConsentRequest.f4963a);
        C0300c.m7953a(parcel, 2, recordConsentRequest.m8946a(), i, false);
        C0300c.m7961a(parcel, 3, recordConsentRequest.m8947b(), i, false);
        C0300c.m7957a(parcel, 4, recordConsentRequest.m8948c(), false);
        C0300c.m7947a(parcel, a);
    }

    public RecordConsentRequest m8985a(Parcel parcel) {
        String str = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int d;
            String str2;
            int a = C0298a.m7923a(parcel);
            String str3;
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = C0298a.m7933d(parcel, a);
                    str2 = str3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    d = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) C0298a.m7925a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    account2 = account;
                    d = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) C0298a.m7930b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str2 = C0298a.m7939j(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
            }
            i = d;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public RecordConsentRequest[] m8986a(int i) {
        return new RecordConsentRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8985a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8986a(i);
    }
}
