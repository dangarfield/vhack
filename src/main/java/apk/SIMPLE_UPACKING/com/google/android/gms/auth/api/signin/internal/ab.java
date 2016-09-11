package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class ab implements Creator {
    static void m5926a(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, signInConfiguration.f3297a);
        C0300c.m7957a(parcel, 2, signInConfiguration.m5901a(), false);
        C0300c.m7957a(parcel, 3, signInConfiguration.m5902b(), false);
        C0300c.m7953a(parcel, 4, signInConfiguration.m5903c(), i, false);
        C0300c.m7953a(parcel, 5, signInConfiguration.m5904d(), i, false);
        C0300c.m7957a(parcel, 7, signInConfiguration.m5905e(), false);
        C0300c.m7947a(parcel, a);
    }

    public SignInConfiguration m5927a(Parcel parcel) {
        String str = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        GoogleSignInOptions googleSignInOptions = null;
        EmailSignInOptions emailSignInOptions = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    emailSignInOptions = (EmailSignInOptions) C0298a.m7925a(parcel, a, EmailSignInOptions.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    googleSignInOptions = (GoogleSignInOptions) C0298a.m7925a(parcel, a, GoogleSignInOptions.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInConfiguration(i, str3, str2, emailSignInOptions, googleSignInOptions, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public SignInConfiguration[] m5928a(int i) {
        return new SignInConfiguration[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5927a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5928a(i);
    }
}
