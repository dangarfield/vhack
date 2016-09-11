package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.auth.api.signin.g */
public class C0154g implements Creator {
    static void m5889a(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, googleSignInOptions.f3263e);
        C0300c.m7968c(parcel, 2, googleSignInOptions.m5854a(), false);
        C0300c.m7953a(parcel, 3, googleSignInOptions.m5855b(), i, false);
        C0300c.m7959a(parcel, 4, googleSignInOptions.m5856c());
        C0300c.m7959a(parcel, 5, googleSignInOptions.m5857d());
        C0300c.m7959a(parcel, 6, googleSignInOptions.m5858e());
        C0300c.m7957a(parcel, 7, googleSignInOptions.m5859f(), false);
        C0300c.m7957a(parcel, 8, googleSignInOptions.m5860g(), false);
        C0300c.m7947a(parcel, a);
    }

    public GoogleSignInOptions m5890a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    arrayList = C0298a.m7931c(parcel, a, Scope.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    account = (Account) C0298a.m7925a(parcel, a, Account.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    z3 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str2, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInOptions[] m5891a(int i) {
        return new GoogleSignInOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5890a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5891a(i);
    }
}
