package com.google.android.gms.p051b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.p047a.C0003b;
import java.util.List;

/* renamed from: com.google.android.gms.b.dn */
public abstract class dn extends Binder implements dm {
    public static dm m6343a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dm)) ? new C0200do(iBinder) : (dm) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        String a;
        boolean j;
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                a = m6329a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                List b = m6331b();
                parcel2.writeNoException();
                parcel2.writeList(b);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                a = m6333c();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                bh d = m6334d();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(d != null ? d.asBinder() : null);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                a = m6335e();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                double f = m6336f();
                parcel2.writeNoException();
                parcel2.writeDouble(f);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                a = m6337g();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                a = m6338h();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                m6339i();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                m6330a(C0003b.m5322a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                m6332b(C0003b.m5322a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                j = m6340j();
                parcel2.writeNoException();
                if (j) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                j = m6341k();
                parcel2.writeNoException();
                if (j) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                Bundle l = m6342l();
                parcel2.writeNoException();
                if (l != null) {
                    parcel2.writeInt(1);
                    l.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
