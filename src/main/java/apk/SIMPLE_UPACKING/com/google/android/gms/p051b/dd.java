package com.google.android.gms.p051b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.C0095b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p047a.C0002a;
import com.google.android.gms.p047a.C0003b;

/* renamed from: com.google.android.gms.b.dd */
public abstract class dd extends Binder implements dc {
    public static dc m6289a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dc)) ? new de(iBinder) : (dc) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AdRequestParcel adRequestParcel = null;
        C0002a a;
        IBinder asBinder;
        Bundle j;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6274a(C0003b.m5322a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.m5403a(parcel) : null, parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m5400a(parcel) : null, parcel.readString(), dg.m6317a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = m6269a();
                parcel2.writeNoException();
                if (a != null) {
                    asBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = C0003b.m5322a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    adRequestParcel = AdRequestParcel.CREATOR.m5400a(parcel);
                }
                m6271a(a, adRequestParcel, parcel.readString(), dg.m6317a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6278b();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6279c();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6275a(C0003b.m5322a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.m5403a(parcel) : null, parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m5400a(parcel) : null, parcel.readString(), parcel.readString(), dg.m6317a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6272a(C0003b.m5322a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m5400a(parcel) : null, parcel.readString(), parcel.readString(), dg.m6317a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6280d();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6281e();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6270a(C0003b.m5322a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m5400a(parcel) : null, parcel.readString(), C0095b.m5614a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                if (parcel.readInt() != 0) {
                    adRequestParcel = AdRequestParcel.CREATOR.m5400a(parcel);
                }
                m6276a(adRequestParcel, parcel.readString());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6282f();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                boolean g = m6283g();
                parcel2.writeNoException();
                parcel2.writeInt(g ? 1 : 0);
                return true;
            case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                m6273a(C0003b.m5322a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m5400a(parcel) : null, parcel.readString(), parcel.readString(), dg.m6317a(parcel.readStrongBinder()), parcel.readInt() != 0 ? NativeAdOptionsParcel.CREATOR.m5434a(parcel) : null, parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                dm h = m6284h();
                parcel2.writeNoException();
                if (h != null) {
                    asBinder = h.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                dp i3 = m6285i();
                parcel2.writeNoException();
                if (i3 != null) {
                    asBinder = i3.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case R.Toolbar_maxButtonHeight /*17*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                j = m6286j();
                parcel2.writeNoException();
                if (j != null) {
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case R.Toolbar_collapseIcon /*18*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                j = m6287k();
                parcel2.writeNoException();
                if (j != null) {
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case R.Toolbar_collapseContentDescription /*19*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                j = m6288l();
                parcel2.writeNoException();
                if (j != null) {
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case R.Toolbar_navigationIcon /*20*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                if (parcel.readInt() != 0) {
                    adRequestParcel = AdRequestParcel.CREATOR.m5400a(parcel);
                }
                m6277a(adRequestParcel, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
