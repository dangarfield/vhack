package com.google.android.gms.p051b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C0056g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.b.cl */
public class cl {
    private final hb f3525a;

    public cl(hb hbVar) {
        this.f3525a = hbVar;
    }

    public Intent m6236a(Context context, Map map) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str = (String) map.get("u");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f3525a != null) {
            str = C0056g.m5439c().m6527a(this.f3525a, str);
        }
        Uri parse = Uri.parse(str);
        boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
        boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
        Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
        ArrayList arrayList = new ArrayList();
        Intent a = m6238a(parse);
        Intent a2 = m6238a(build);
        ResolveInfo a3 = m6240a(context, a, arrayList);
        if (a3 != null) {
            return m6237a(a, a3);
        }
        if (a2 != null) {
            ResolveInfo a4 = m6239a(context, a2);
            if (a4 != null) {
                Intent a5 = m6237a(a, a4);
                if (m6239a(context, a5) != null) {
                    return a5;
                }
            }
        }
        if (arrayList.size() == 0) {
            return a;
        }
        if (parseBoolean2 && activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ResolveInfo resolveInfo = (ResolveInfo) it.next();
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                            return m6237a(a, resolveInfo);
                        }
                    }
                }
            }
        }
        return parseBoolean ? m6237a(a, (ResolveInfo) arrayList.get(0)) : a;
    }

    public Intent m6237a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    public Intent m6238a(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    public ResolveInfo m6239a(Context context, Intent intent) {
        return m6240a(context, intent, new ArrayList());
    }

    public ResolveInfo m6240a(Context context, Intent intent, ArrayList arrayList) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        ResolveInfo resolveInfo;
        Collection queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                    resolveInfo = resolveActivity;
                    break;
                }
            }
        }
        resolveInfo = null;
        arrayList.addAll(queryIntentActivities);
        return resolveInfo;
    }
}
