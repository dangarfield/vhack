package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.C0141f;

/* renamed from: com.google.android.gms.auth.api.h */
public final class C0142h implements C0141f {
    private final String f3212a;
    private final PasswordSpecification f3213b;

    public Bundle m5815a() {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", this.f3212a);
        bundle.putParcelable("password_specification", this.f3213b);
        return bundle;
    }
}
