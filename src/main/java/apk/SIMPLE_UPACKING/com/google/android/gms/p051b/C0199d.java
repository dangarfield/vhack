package com.google.android.gms.p051b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

/* renamed from: com.google.android.gms.b.d */
public class C0199d {
    public static iq m6264a(Context context) {
        return C0199d.m6265a(context, null);
    }

    public static iq m6265a(Context context, mz mzVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (mzVar == null) {
            mzVar = VERSION.SDK_INT >= 9 ? new na() : new mw(AndroidHttpClient.newInstance(str));
        }
        iq iqVar = new iq(new ms(file), new mp(mzVar));
        iqVar.m6821a();
        return iqVar;
    }
}
