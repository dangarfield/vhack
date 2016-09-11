package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public abstract class ax extends Binder implements aw {
    public static aw m7816a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aw)) ? new ay(iBinder) : (aw) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        ValidateAccountRequest validateAccountRequest = null;
        at a;
        int readInt;
        String readString;
        Bundle bundle;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7780a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7774a(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7773a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7772a(au.m7715a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7786b(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7788c(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7790d(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7792e(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7781a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7778a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7794f(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7796g(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7798h(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7800i(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7802j(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7804k(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.Toolbar_maxButtonHeight /*17*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7806l(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.Toolbar_collapseIcon /*18*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7808m(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.Toolbar_collapseContentDescription /*19*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7775a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case R.Toolbar_navigationIcon /*20*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7782a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case R.Toolbar_navigationContentDescription /*21*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7785b(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.Toolbar_logoDescription /*22*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7787c(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.Toolbar_titleTextColor /*23*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7809n(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.Toolbar_subtitleTextColor /*24*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7789d(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionMenuTextAppearance /*25*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7810o(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionMenuTextColor /*26*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7791e(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeStyle /*27*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7811p(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7771a();
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeSplitBackground /*30*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7779a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeCloseDrawable /*31*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7793f(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeCutDrawable /*32*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7795g(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeCopyDrawable /*33*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7777a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModePasteDrawable /*34*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7776a(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7797h(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeShareDrawable /*36*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7799i(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeFindDrawable /*37*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7812q(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7813r(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7801j(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7814s(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_dialogTheme /*42*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7803k(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_dialogPreferredPadding /*43*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m7815t(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_listDividerAlertDialog /*44*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7805l(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_actionDropDownStyle /*45*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m7807m(au.m7715a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                GetServiceRequest getServiceRequest;
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    getServiceRequest = (GetServiceRequest) GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                m7783a(a, getServiceRequest);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = au.m7715a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    validateAccountRequest = (ValidateAccountRequest) ValidateAccountRequest.CREATOR.createFromParcel(parcel);
                }
                m7784a(a, validateAccountRequest);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
