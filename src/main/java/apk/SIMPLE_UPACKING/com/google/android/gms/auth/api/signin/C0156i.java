package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.signin.i */
public class C0156i implements Creator {
    static void m5895a(SignInAccount signInAccount, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, signInAccount.f3271a);
        C0300c.m7957a(parcel, 2, signInAccount.m5875j(), false);
        C0300c.m7957a(parcel, 3, signInAccount.m5866a(), false);
        C0300c.m7957a(parcel, 4, signInAccount.m5867b(), false);
        C0300c.m7957a(parcel, 5, signInAccount.m5868c(), false);
        C0300c.m7953a(parcel, 6, signInAccount.m5869d(), i, false);
        C0300c.m7953a(parcel, 7, signInAccount.m5871f(), i, false);
        C0300c.m7957a(parcel, 8, signInAccount.m5872g(), false);
        C0300c.m7957a(parcel, 9, signInAccount.m5873h(), false);
        C0300c.m7947a(parcel, a);
    }

    public SignInAccount m5896a(Parcel parcel) {
        String str = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        String str2 = "";
        GoogleSignInAccount googleSignInAccount = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str6 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str5 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    uri = (Uri) C0298a.m7925a(parcel, a, Uri.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    googleSignInAccount = (GoogleSignInAccount) C0298a.m7925a(parcel, a, GoogleSignInAccount.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    str2 = C0298a.m7939j(parcel, a);
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
            return new SignInAccount(i, str6, str5, str4, str3, uri, googleSignInAccount, str2, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public SignInAccount[] m5897a(int i) {
        return new SignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5896a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5897a(i);
    }
}
