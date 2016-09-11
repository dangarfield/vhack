package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public final class ConnectionResult implements SafeParcelable {
    public static final Creator CREATOR;
    public static final ConnectionResult f4122a;
    final int f4123b;
    private final int f4124c;
    private final PendingIntent f4125d;
    private final String f4126e;

    static {
        f4122a = new ConnectionResult(0);
        CREATOR = new C0277i();
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f4123b = i;
        this.f4124c = i2;
        this.f4125d = pendingIntent;
        this.f4126e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String m7277a(int i) {
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return "SUCCESS";
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return "SERVICE_MISSING";
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return "SERVICE_DISABLED";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return "SIGN_IN_REQUIRED";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return "INVALID_ACCOUNT";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return "RESOLUTION_REQUIRED";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return "NETWORK_ERROR";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                return "INTERNAL_ERROR";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return "SERVICE_INVALID";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                return "DEVELOPER_ERROR";
            case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                return "LICENSE_CHECK_FAILED";
            case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                return "CANCELED";
            case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                return "TIMEOUT";
            case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                return "INTERRUPTED";
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                return "API_UNAVAILABLE";
            case R.Toolbar_maxButtonHeight /*17*/:
                return "SIGN_IN_FAILED";
            case R.Toolbar_collapseIcon /*18*/:
                return "SERVICE_UPDATING";
            case R.Toolbar_collapseContentDescription /*19*/:
                return "SERVICE_MISSING_PERMISSION";
            case R.Toolbar_navigationIcon /*20*/:
                return "RESTRICTED_PROFILE";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public void m7278a(Activity activity, int i) {
        if (m7279a()) {
            activity.startIntentSenderForResult(this.f4125d.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public boolean m7279a() {
        return (this.f4124c == 0 || this.f4125d == null) ? false : true;
    }

    public boolean m7280b() {
        return this.f4124c == 0;
    }

    public int m7281c() {
        return this.f4124c;
    }

    public PendingIntent m7282d() {
        return this.f4125d;
    }

    public int describeContents() {
        return 0;
    }

    public String m7283e() {
        return this.f4126e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f4124c == connectionResult.f4124c && bc.m7871a(this.f4125d, connectionResult.f4125d) && bc.m7871a(this.f4126e, connectionResult.f4126e);
    }

    public int hashCode() {
        return bc.m7869a(Integer.valueOf(this.f4124c), this.f4125d, this.f4126e);
    }

    public String toString() {
        return bc.m7870a((Object) this).m7872a("statusCode", m7277a(this.f4124c)).m7872a("resolution", this.f4125d).m7872a("message", this.f4126e).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0277i.m7682a(this, parcel, i);
    }
}
