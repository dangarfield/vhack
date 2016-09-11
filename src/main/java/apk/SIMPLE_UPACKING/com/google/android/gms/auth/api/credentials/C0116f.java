package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

/* renamed from: com.google.android.gms.auth.api.credentials.f */
public class C0116f implements Creator {
    static void m5702a(Credential credential, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7957a(parcel, 1, credential.m5668a(), false);
        C0300c.m7949a(parcel, 1000, credential.f3138a);
        C0300c.m7957a(parcel, 2, credential.m5669b(), false);
        C0300c.m7953a(parcel, 3, credential.m5670c(), i, false);
        C0300c.m7968c(parcel, 4, credential.m5671d(), false);
        C0300c.m7957a(parcel, 5, credential.m5672e(), false);
        C0300c.m7957a(parcel, 6, credential.m5674g(), false);
        C0300c.m7957a(parcel, 7, credential.m5673f(), false);
        C0300c.m7957a(parcel, 8, credential.m5675h(), false);
        C0300c.m7947a(parcel, a);
    }

    public Credential m5703a(Parcel parcel) {
        String str = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str6 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str5 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    uri = (Uri) C0298a.m7925a(parcel, a, Uri.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    list = C0298a.m7931c(parcel, a, IdToken.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case 1000:
                    i = C0298a.m7933d(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Credential(i, str6, str5, uri, list, str4, str3, str2, str);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public Credential[] m5704a(int i) {
        return new Credential[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5703a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5704a(i);
    }
}
