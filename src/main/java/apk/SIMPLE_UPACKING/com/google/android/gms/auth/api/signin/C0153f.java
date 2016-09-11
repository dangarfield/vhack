package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

/* renamed from: com.google.android.gms.auth.api.signin.f */
public class C0153f implements Creator {
    static void m5886a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, googleSignInAccount.f3248b);
        C0300c.m7957a(parcel, 2, googleSignInAccount.m5834a(), false);
        C0300c.m7957a(parcel, 3, googleSignInAccount.m5836b(), false);
        C0300c.m7957a(parcel, 4, googleSignInAccount.m5837c(), false);
        C0300c.m7957a(parcel, 5, googleSignInAccount.m5838d(), false);
        C0300c.m7953a(parcel, 6, googleSignInAccount.m5839e(), i, false);
        C0300c.m7957a(parcel, 7, googleSignInAccount.m5840f(), false);
        C0300c.m7950a(parcel, 8, googleSignInAccount.m5841g());
        C0300c.m7957a(parcel, 9, googleSignInAccount.m5842h(), false);
        C0300c.m7968c(parcel, 10, googleSignInAccount.f3249c, false);
        C0300c.m7947a(parcel, a);
    }

    public GoogleSignInAccount m5887a(Parcel parcel) {
        List list = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
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
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    j = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    list = C0298a.m7931c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str6, str5, str4, str3, uri, str2, j, str, list);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] m5888a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5887a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5888a(i);
    }
}
