package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3151a;
    private final boolean f3152b;
    private final String[] f3153c;
    private final CredentialPickerConfig f3154d;
    private final CredentialPickerConfig f3155e;

    static {
        CREATOR = new C0118h();
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.f3151a = i;
        this.f3152b = z;
        this.f3153c = (String[]) bf.m7873a((Object) strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new C0112b().m5694a();
        }
        this.f3154d = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new C0112b().m5694a();
        }
        this.f3155e = credentialPickerConfig2;
    }

    public boolean m5679a() {
        return this.f3152b;
    }

    public String[] m5680b() {
        return this.f3153c;
    }

    public CredentialPickerConfig m5681c() {
        return this.f3154d;
    }

    public CredentialPickerConfig m5682d() {
        return this.f3155e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0118h.m5708a(this, parcel, i);
    }
}
