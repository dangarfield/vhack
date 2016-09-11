package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.bf;

@fi
/* renamed from: com.google.android.gms.b.ad */
public class ad {
    private final Context f3387a;

    public ad(Context context) {
        bf.m7874a((Object) context, (Object) "Context can not be null");
        this.f3387a = context;
    }

    public static boolean m6077e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean m6078a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m6079a(intent);
    }

    public boolean m6079a(Intent intent) {
        bf.m7874a((Object) intent, (Object) "Intent can not be null");
        return !this.f3387a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean m6080b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m6079a(intent);
    }

    public boolean m6081c() {
        return ad.m6077e() && this.f3387a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public boolean m6082d() {
        return true;
    }

    @TargetApi(14)
    public boolean m6083f() {
        return VERSION.SDK_INT >= 14 && m6079a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
