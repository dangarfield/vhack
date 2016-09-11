package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class bg implements Creator {
    static void m7884a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, resolveAccountRequest.f4351a);
        C0300c.m7953a(parcel, 2, resolveAccountRequest.m7691a(), i, false);
        C0300c.m7949a(parcel, 3, resolveAccountRequest.m7692b());
        C0300c.m7953a(parcel, 4, resolveAccountRequest.m7693c(), i, false);
        C0300c.m7947a(parcel, a);
    }

    public ResolveAccountRequest m7885a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = C0298a.m7928b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int d;
            GoogleSignInAccount googleSignInAccount2;
            int a = C0298a.m7923a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = C0298a.m7933d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    d = i2;
                    int i4 = i;
                    account2 = (Account) C0298a.m7925a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    account2 = account;
                    d = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = C0298a.m7933d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    googleSignInAccount2 = (GoogleSignInAccount) C0298a.m7925a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
            }
            i2 = d;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountRequest[] m7886a(int i) {
        return new ResolveAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7885a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7886a(i);
    }
}
