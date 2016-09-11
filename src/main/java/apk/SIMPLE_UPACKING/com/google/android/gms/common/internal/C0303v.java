package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p018b.R;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p051b.ki;

/* renamed from: com.google.android.gms.common.internal.v */
public final class C0303v {
    public static final String m7982a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return resources.getString(C0001R.string.common_google_play_services_install_title);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
            case R.AppCompatTheme_dialogTheme /*42*/:
                return resources.getString(C0001R.string.common_google_play_services_update_title);
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return resources.getString(C0001R.string.common_google_play_services_enable_title);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return null;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return resources.getString(C0001R.string.common_google_play_services_invalid_account_title);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return resources.getString(C0001R.string.common_google_play_services_network_error_title);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C0001R.string.common_google_play_services_unsupported_title);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case R.Toolbar_maxButtonHeight /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return resources.getString(C0001R.string.common_google_play_services_sign_in_failed_title);
            case R.Toolbar_collapseIcon /*18*/:
                return resources.getString(C0001R.string.common_google_play_services_updating_title);
            case R.Toolbar_navigationIcon /*20*/:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return resources.getString(C0001R.string.common_google_play_services_restricted_profile_title);
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    public static String m7983a(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                if (ki.m6926a(resources)) {
                    return resources.getString(C0001R.string.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(C0001R.string.common_google_play_services_install_text_phone, new Object[]{str});
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return resources.getString(C0001R.string.common_google_play_services_update_text, new Object[]{str});
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return resources.getString(C0001R.string.common_google_play_services_enable_text, new Object[]{str});
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return resources.getString(C0001R.string.common_google_play_services_invalid_account_text);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return resources.getString(C0001R.string.common_google_play_services_network_error_text);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return resources.getString(C0001R.string.common_google_play_services_unsupported_text, new Object[]{str});
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                return resources.getString(C0001R.string.common_google_play_services_api_unavailable_text, new Object[]{str});
            case R.Toolbar_maxButtonHeight /*17*/:
                return resources.getString(C0001R.string.common_google_play_services_sign_in_failed_text);
            case R.Toolbar_collapseIcon /*18*/:
                return resources.getString(C0001R.string.common_google_play_services_updating_text, new Object[]{str});
            case R.Toolbar_navigationIcon /*20*/:
                return resources.getString(C0001R.string.common_google_play_services_restricted_profile_text);
            case R.AppCompatTheme_dialogTheme /*42*/:
                return resources.getString(C0001R.string.common_google_play_services_wear_update_text);
            default:
                return resources.getString(C0001R.string.common_google_play_services_unknown_issue, new Object[]{str});
        }
    }

    public static String m7984b(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return resources.getString(C0001R.string.common_google_play_services_install_button);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return resources.getString(C0001R.string.common_google_play_services_update_button);
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return resources.getString(C0001R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
