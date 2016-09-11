package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

/* renamed from: com.google.android.gms.common.internal.w */
public class C0304w implements OnClickListener {
    private final Activity f4455a;
    private final Fragment f4456b;
    private final Intent f4457c;
    private final int f4458d;

    public C0304w(Activity activity, Intent intent, int i) {
        this.f4455a = activity;
        this.f4456b = null;
        this.f4457c = intent;
        this.f4458d = i;
    }

    public C0304w(Fragment fragment, Intent intent, int i) {
        this.f4455a = null;
        this.f4456b = fragment;
        this.f4457c = intent;
        this.f4458d = i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f4457c != null && this.f4456b != null) {
                this.f4456b.m1146a(this.f4457c, this.f4458d);
            } else if (this.f4457c != null) {
                this.f4455a.startActivityForResult(this.f4457c, this.f4458d);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
