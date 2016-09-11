package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.support.v4.p005e.AsyncTaskCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v7.widget.z */
class ActivityChooserModel extends DataSetObservable {
    private static final String f2380a;
    private static final Object f2381b;
    private static final Map f2382c;
    private final Object f2383d;
    private final List f2384e;
    private final List f2385f;
    private final Context f2386g;
    private final String f2387h;
    private Intent f2388i;
    private ac f2389j;
    private int f2390k;
    private boolean f2391l;
    private boolean f2392m;
    private boolean f2393n;
    private boolean f2394o;
    private ae f2395p;

    static {
        f2380a = ActivityChooserModel.class.getSimpleName();
        f2381b = new Object();
        f2382c = new HashMap();
    }

    public int m4812a() {
        int size;
        synchronized (this.f2383d) {
            m4806e();
            size = this.f2384e.size();
        }
        return size;
    }

    public ResolveInfo m4814a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2383d) {
            m4806e();
            resolveInfo = ((ab) this.f2384e.get(i)).f1842a;
        }
        return resolveInfo;
    }

    public int m4813a(ResolveInfo resolveInfo) {
        synchronized (this.f2383d) {
            m4806e();
            List list = this.f2384e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((ab) list.get(i)).f1842a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent m4815b(int i) {
        synchronized (this.f2383d) {
            if (this.f2388i == null) {
                return null;
            }
            m4806e();
            ab abVar = (ab) this.f2384e.get(i);
            ComponentName componentName = new ComponentName(abVar.f1842a.activityInfo.packageName, abVar.f1842a.activityInfo.name);
            Intent intent = new Intent(this.f2388i);
            intent.setComponent(componentName);
            if (this.f2395p != null) {
                if (this.f2395p.m3903a(this, new Intent(intent))) {
                    return null;
                }
            }
            m4801a(new ad(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m4816b() {
        synchronized (this.f2383d) {
            m4806e();
            if (this.f2384e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((ab) this.f2384e.get(0)).f1842a;
            return resolveInfo;
        }
    }

    public void m4817c(int i) {
        synchronized (this.f2383d) {
            float f;
            m4806e();
            ab abVar = (ab) this.f2384e.get(i);
            ab abVar2 = (ab) this.f2384e.get(0);
            if (abVar2 != null) {
                f = (abVar2.f1843b - abVar.f1843b) + 5.0f;
            } else {
                f = 1.0f;
            }
            m4801a(new ad(new ComponentName(abVar.f1842a.activityInfo.packageName, abVar.f1842a.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void m4805d() {
        if (!this.f2392m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2393n) {
            this.f2393n = false;
            if (!TextUtils.isEmpty(this.f2387h)) {
                AsyncTaskCompat.m1430a(new af(), new ArrayList(this.f2385f), this.f2387h);
            }
        }
    }

    private void m4806e() {
        int g = m4808g() | m4809h();
        m4810i();
        if (g != 0) {
            m4807f();
            notifyChanged();
        }
    }

    private boolean m4807f() {
        if (this.f2389j == null || this.f2388i == null || this.f2384e.isEmpty() || this.f2385f.isEmpty()) {
            return false;
        }
        this.f2389j.m3902a(this.f2388i, this.f2384e, Collections.unmodifiableList(this.f2385f));
        return true;
    }

    private boolean m4808g() {
        if (!this.f2394o || this.f2388i == null) {
            return false;
        }
        this.f2394o = false;
        this.f2384e.clear();
        List queryIntentActivities = this.f2386g.getPackageManager().queryIntentActivities(this.f2388i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2384e.add(new ab(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m4809h() {
        if (!this.f2391l || !this.f2393n || TextUtils.isEmpty(this.f2387h)) {
            return false;
        }
        this.f2391l = false;
        this.f2392m = true;
        m4811j();
        return true;
    }

    private boolean m4801a(ad adVar) {
        boolean add = this.f2385f.add(adVar);
        if (add) {
            this.f2393n = true;
            m4810i();
            m4805d();
            m4807f();
            notifyChanged();
        }
        return add;
    }

    private void m4810i() {
        int size = this.f2385f.size() - this.f2390k;
        if (size > 0) {
            this.f2393n = true;
            for (int i = 0; i < size; i++) {
                ad adVar = (ad) this.f2385f.remove(0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4811j() {
        /*
        r9 = this;
        r8 = 1;
        r0 = r9.f2386g;	 Catch:{ FileNotFoundException -> 0x00d3 }
        r1 = r9.f2387h;	 Catch:{ FileNotFoundException -> 0x00d3 }
        r1 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x00d3 }
        r2 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = "UTF-8";
        r2.setInput(r1, r0);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = 0;
    L_0x0013:
        if (r0 == r8) goto L_0x001d;
    L_0x0015:
        r3 = 2;
        if (r0 == r3) goto L_0x001d;
    L_0x0018:
        r0 = r2.next();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        goto L_0x0013;
    L_0x001d:
        r0 = "historical-records";
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = r0.equals(r3);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r0 != 0) goto L_0x0052;
    L_0x0029:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r2 = "Share records file does not start with historical-records tag.";
        r0.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        throw r0;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x0031:
        r0 = move-exception;
        r2 = f2380a;	 Catch:{ all -> 0x00c8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r3.<init>();	 Catch:{ all -> 0x00c8 }
        r4 = "Error reading historical recrod file: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r9.f2387h;	 Catch:{ all -> 0x00c8 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c8 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r1.close();	 Catch:{ IOException -> 0x00cf }
    L_0x0051:
        return;
    L_0x0052:
        r0 = r9.f2385f;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0.clear();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x0057:
        r3 = r2.next();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r3 != r8) goto L_0x0065;
    L_0x005d:
        if (r1 == 0) goto L_0x0051;
    L_0x005f:
        r1.close();	 Catch:{ IOException -> 0x0063 }
        goto L_0x0051;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0051;
    L_0x0065:
        r4 = 3;
        if (r3 == r4) goto L_0x0057;
    L_0x0068:
        r4 = 4;
        if (r3 == r4) goto L_0x0057;
    L_0x006b:
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = "historical-record";
        r3 = r4.equals(r3);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r3 != 0) goto L_0x00a2;
    L_0x0077:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r2 = "Share records file not well-formed.";
        r0.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        throw r0;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x007f:
        r0 = move-exception;
        r2 = f2380a;	 Catch:{ all -> 0x00c8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r3.<init>();	 Catch:{ all -> 0x00c8 }
        r4 = "Error reading historical recrod file: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r9.f2387h;	 Catch:{ all -> 0x00c8 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c8 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x0051;
    L_0x009c:
        r1.close();	 Catch:{ IOException -> 0x00a0 }
        goto L_0x0051;
    L_0x00a0:
        r0 = move-exception;
        goto L_0x0051;
    L_0x00a2:
        r3 = 0;
        r4 = "activity";
        r3 = r2.getAttributeValue(r3, r4);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = 0;
        r5 = "time";
        r4 = r2.getAttributeValue(r4, r5);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = java.lang.Long.parseLong(r4);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r6 = 0;
        r7 = "weight";
        r6 = r2.getAttributeValue(r6, r7);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r6 = java.lang.Float.parseFloat(r6);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r7 = new android.support.v7.widget.ad;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r7.<init>(r3, r4, r6);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0.add(r7);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        goto L_0x0057;
    L_0x00c8:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ce;
    L_0x00cb:
        r1.close();	 Catch:{ IOException -> 0x00d1 }
    L_0x00ce:
        throw r0;
    L_0x00cf:
        r0 = move-exception;
        goto L_0x0051;
    L_0x00d1:
        r1 = move-exception;
        goto L_0x00ce;
    L_0x00d3:
        r0 = move-exception;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.z.j():void");
    }
}
