package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.fp;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.a */
public class C0057a {
    public boolean m5457a(Context context, Intent intent, C0077t c0077t) {
        try {
            fp.m6505e("Launching an intent: " + intent.toURI());
            C0056g.m5439c().m6533a(context, intent);
            if (c0077t != null) {
                c0077t.m5553a();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            C0099b.m5643d(e.getMessage());
            return false;
        }
    }

    public boolean m5458a(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, C0077t c0077t) {
        int i = 0;
        if (adLauncherIntentInfoParcel == null) {
            C0099b.m5643d("No intent data for launcher overlay.");
            return i;
        } else if (adLauncherIntentInfoParcel.f2998i != null) {
            return m5457a(context, adLauncherIntentInfoParcel.f2998i, c0077t);
        } else {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.f2992c)) {
                C0099b.m5643d("Open GMSG did not contain a URL.");
                return i;
            }
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.f2993d)) {
                intent.setData(Uri.parse(adLauncherIntentInfoParcel.f2992c));
            } else {
                intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.f2992c), adLauncherIntentInfoParcel.f2993d);
            }
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f2994e)) {
                intent.setPackage(adLauncherIntentInfoParcel.f2994e);
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f2995f)) {
                String[] split = adLauncherIntentInfoParcel.f2995f.split("/", 2);
                if (split.length < 2) {
                    C0099b.m5643d("Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.f2995f);
                    return i;
                }
                intent.setClassName(split[i], split[1]);
            }
            Object obj = adLauncherIntentInfoParcel.f2996g;
            if (!TextUtils.isEmpty(obj)) {
                try {
                    i = Integer.parseInt(obj);
                } catch (NumberFormatException e) {
                    C0099b.m5643d("Could not parse intent flags.");
                }
                intent.addFlags(i);
            }
            return m5457a(context, intent, c0077t);
        }
    }
}
