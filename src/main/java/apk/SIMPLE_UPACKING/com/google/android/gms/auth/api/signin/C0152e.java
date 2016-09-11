package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.signin.e */
public class C0152e implements Creator {
    static void m5883a(EmailSignInOptions emailSignInOptions, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, emailSignInOptions.f3242a);
        C0300c.m7953a(parcel, 2, emailSignInOptions.m5827a(), i, false);
        C0300c.m7957a(parcel, 3, emailSignInOptions.m5829c(), false);
        C0300c.m7953a(parcel, 4, emailSignInOptions.m5828b(), i, false);
        C0300c.m7947a(parcel, a);
    }

    public EmailSignInOptions m5884a(Parcel parcel) {
        Uri uri = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        String str = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < b) {
            String str2;
            Uri uri3;
            int d;
            Uri uri4;
            int a = C0298a.m7923a(parcel);
            Uri uri5;
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    uri5 = uri;
                    str2 = str;
                    uri3 = uri2;
                    d = C0298a.m7933d(parcel, a);
                    uri4 = uri5;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    d = i;
                    String str3 = str;
                    uri3 = (Uri) C0298a.m7925a(parcel, a, Uri.CREATOR);
                    uri4 = uri;
                    str2 = str3;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    uri3 = uri2;
                    d = i;
                    uri5 = uri;
                    str2 = C0298a.m7939j(parcel, a);
                    uri4 = uri5;
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    uri4 = (Uri) C0298a.m7925a(parcel, a, Uri.CREATOR);
                    str2 = str;
                    uri3 = uri2;
                    d = i;
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    uri4 = uri;
                    str2 = str;
                    uri3 = uri2;
                    d = i;
                    break;
            }
            i = d;
            uri2 = uri3;
            str = str2;
            uri = uri4;
        }
        if (parcel.dataPosition() == b) {
            return new EmailSignInOptions(i, uri2, str, uri);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public EmailSignInOptions[] m5885a(int i) {
        return new EmailSignInOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5884a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5885a(i);
    }
}
