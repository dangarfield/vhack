package com.google.android.gms.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.bf;

/* renamed from: com.google.android.gms.measurement.e */
public final class C0358e {
    private static volatile C0358e f4612e;
    private final String f4613a;
    private final Status f4614b;
    private final boolean f4615c;
    private final boolean f4616d;

    C0358e(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(C0001R.string.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resourcePackageName);
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.f4616d = z;
            z = z2;
        } else {
            this.f4616d = false;
        }
        this.f4615c = z;
        int identifier2 = resources.getIdentifier("google_app_id", "string", resourcePackageName);
        if (identifier2 == 0) {
            if (this.f4615c) {
                this.f4614b = new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");
            } else {
                this.f4614b = Status.f4131a;
            }
            this.f4613a = null;
            return;
        }
        String string = resources.getString(identifier2);
        if (TextUtils.isEmpty(string)) {
            if (this.f4615c) {
                this.f4614b = new Status(10, "The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '" + string + "'.");
            } else {
                this.f4614b = Status.f4131a;
            }
            this.f4613a = null;
            return;
        }
        this.f4613a = string;
        this.f4614b = Status.f4131a;
    }

    C0358e(Context context, String str, boolean z) {
        this.f4613a = str;
        this.f4614b = Status.f4131a;
        this.f4615c = z;
        this.f4616d = !z;
    }

    public static Status m8186a(Context context) {
        bf.m7874a((Object) context, (Object) "Context must not be null.");
        if (f4612e == null) {
            synchronized (C0358e.class) {
                if (f4612e == null) {
                    f4612e = new C0358e(context);
                }
            }
        }
        return f4612e.f4614b;
    }

    public static Status m8187a(Context context, String str, boolean z) {
        bf.m7874a((Object) context, (Object) "Context must not be null.");
        bf.m7876a(str, (Object) "App ID must be nonempty.");
        synchronized (C0358e.class) {
            if (f4612e != null) {
                Status a = f4612e.m8191a(str);
                return a;
            }
            f4612e = new C0358e(context, str, z);
            return f4612e.f4614b;
        }
    }

    public static String m8188a() {
        if (f4612e == null) {
            synchronized (C0358e.class) {
                if (f4612e == null) {
                    throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
                }
            }
        }
        return f4612e.m8192b();
    }

    public static boolean m8189c() {
        if (f4612e == null) {
            synchronized (C0358e.class) {
                if (f4612e == null) {
                    throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
                }
            }
        }
        return f4612e.m8193e();
    }

    public static boolean m8190d() {
        if (f4612e == null) {
            synchronized (C0358e.class) {
                if (f4612e == null) {
                    throw new IllegalStateException("Initialize must be called before isMeasurementExplicitlyDisabled.");
                }
            }
        }
        return f4612e.f4616d;
    }

    Status m8191a(String str) {
        return (this.f4613a == null || this.f4613a.equals(str)) ? Status.f4131a : new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + this.f4613a + "'.");
    }

    String m8192b() {
        return this.f4613a;
    }

    boolean m8193e() {
        return this.f4614b.m7292e() && this.f4615c;
    }
}
