package com.google.android.gms.common.api;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.common.api.m */
public class C0262m {
    public static String m7616a(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
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
                return "ERROR";
            case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                return "INTERRUPTED";
            case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                return "TIMEOUT";
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                return "CANCELED";
            case R.Toolbar_maxButtonHeight /*17*/:
                return "API_NOT_CONNECTED";
            case 3000:
                return "AUTH_API_INVALID_CREDENTIALS";
            case 3001:
                return "AUTH_API_ACCESS_FORBIDDEN";
            case 3002:
                return "AUTH_API_CLIENT_ERROR";
            case 3003:
                return "AUTH_API_SERVER_ERROR";
            case 3004:
                return "AUTH_TOKEN_ERROR";
            case 3005:
                return "AUTH_URL_RESOLUTION";
            default:
                return "unknown status code: " + i;
        }
    }
}
