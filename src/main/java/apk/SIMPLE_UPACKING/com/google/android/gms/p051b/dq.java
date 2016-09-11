package com.google.android.gms.p051b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.p047a.C0003b;
import java.util.List;

/* renamed from: com.google.android.gms.b.dq */
public abstract class dq extends Binder implements dp {
    public static dp m6370a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dp)) ? new dr(iBinder) : (dp) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        String a;
        boolean h;
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                a = m6358a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                List b = m6360b();
                parcel2.writeNoException();
                parcel2.writeList(b);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                a = m6362c();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                bh d = m6363d();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(d != null ? d.asBinder() : null);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                a = m6364e();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                a = m6365f();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                m6366g();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                m6359a(C0003b.m5322a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                m6361b(C0003b.m5322a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                h = m6367h();
                parcel2.writeNoException();
                if (h) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                h = m6368i();
                parcel2.writeNoException();
                if (h) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                Bundle j = m6369j();
                parcel2.writeNoException();
                if (j != null) {
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
