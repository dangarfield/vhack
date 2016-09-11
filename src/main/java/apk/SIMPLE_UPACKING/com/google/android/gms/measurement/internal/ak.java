package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.support.v4.p014g.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p051b.la;
import com.google.android.gms.p051b.lb;
import com.google.android.gms.p051b.le;
import com.google.android.gms.p051b.ln;
import com.google.android.gms.p051b.lo;
import com.google.android.gms.p051b.lq;
import com.google.android.gms.p051b.lr;
import com.google.android.gms.p051b.mh;
import com.google.android.gms.p051b.mi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ak extends cl {
    private static final Map f4665a;
    private final an f4666b;
    private final ac f4667c;

    static {
        f4665a = new ArrayMap(13);
        f4665a.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        f4665a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        f4665a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        f4665a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        f4665a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        f4665a.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        f4665a.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        f4665a.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        f4665a.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        f4665a.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        f4665a.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        f4665a.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        f4665a.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
    }

    ak(bx bxVar) {
        super(bxVar);
        this.f4667c = new ac(m8213l());
        this.f4666b = new an(this, m8214m(), m8380I());
    }

    private String m8380I() {
        if (!m8222u().m8332N()) {
            return m8222u().m8329K();
        }
        if (m8222u().m8333O()) {
            return m8222u().m8329K();
        }
        m8220s().m8602v().m8607a("Using secondary database");
        return m8222u().m8330L();
    }

    private boolean m8381J() {
        return m8214m().getDatabasePath(m8380I()).exists();
    }

    @TargetApi(11)
    static int m8382a(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long m8383a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = m8429w().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            m8220s().m8582b().m8609a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long m8384a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = m8429w().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            m8220s().m8582b().m8609a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void m8386a(String str, la laVar) {
        Object obj = null;
        m8225G();
        m8207f();
        bf.m7875a(str);
        bf.m7873a((Object) laVar);
        bf.m7873a(laVar.f3894c);
        bf.m7873a(laVar.f3893b);
        if (laVar.f3892a == null) {
            m8220s().m8583c().m8607a("Audience with no ID");
            return;
        }
        int intValue = laVar.f3892a.intValue();
        for (lb lbVar : laVar.f3894c) {
            if (lbVar.f3896a == null) {
                m8220s().m8583c().m8609a("Event filter with no ID. Audience definition ignored. appId, audienceId", str, laVar.f3892a);
                return;
            }
        }
        for (le leVar : laVar.f3893b) {
            if (leVar.f3912a == null) {
                m8220s().m8583c().m8609a("Property filter with no ID. Audience definition ignored. appId, audienceId", str, laVar.f3892a);
                return;
            }
        }
        Object obj2 = 1;
        for (lb a : laVar.f3894c) {
            if (!m8387a(str, intValue, a)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (le a2 : laVar.f3893b) {
                if (!m8388a(str, intValue, a2)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            m8416b(str, intValue);
        }
    }

    private boolean m8387a(String str, int i, lb lbVar) {
        m8225G();
        m8207f();
        bf.m7875a(str);
        bf.m7873a((Object) lbVar);
        if (TextUtils.isEmpty(lbVar.f3897b)) {
            m8220s().m8583c().m8609a("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(lbVar.f3896a));
            return false;
        }
        try {
            byte[] bArr = new byte[lbVar.m6966e()];
            mi a = mi.m7134a(bArr);
            lbVar.m6976a(a);
            a.m7168b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", lbVar.f3896a);
            contentValues.put("event_name", lbVar.f3897b);
            contentValues.put("data", bArr);
            try {
                if (m8429w().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    m8220s().m8582b().m8607a("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                m8220s().m8582b().m8608a("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            m8220s().m8582b().m8608a("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    private boolean m8388a(String str, int i, le leVar) {
        m8225G();
        m8207f();
        bf.m7875a(str);
        bf.m7873a((Object) leVar);
        if (TextUtils.isEmpty(leVar.f3913b)) {
            m8220s().m8583c().m8609a("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(leVar.f3912a));
            return false;
        }
        try {
            byte[] bArr = new byte[leVar.m6966e()];
            mi a = mi.m7134a(bArr);
            leVar.m6993a(a);
            a.m7168b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", leVar.f3912a);
            contentValues.put("property_name", leVar.f3913b);
            contentValues.put("data", bArr);
            try {
                if (m8429w().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                m8220s().m8582b().m8607a("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                m8220s().m8582b().m8608a("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            m8220s().m8582b().m8608a("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    public long m8390A() {
        return m8384a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long m8391B() {
        return m8384a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean m8392C() {
        return m8383a("select count(1) > 0 from raw_events", null) != 0;
    }

    public al m8393a(long j, String str, boolean z, boolean z2) {
        Object e;
        Throwable th;
        bf.m7875a(str);
        m8207f();
        m8225G();
        String[] strArr = new String[]{str};
        al alVar = new al();
        Cursor query;
        try {
            SQLiteDatabase w = m8429w();
            query = w.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        alVar.f4669b = query.getLong(1);
                        alVar.f4668a = query.getLong(2);
                        alVar.f4670c = query.getLong(3);
                    }
                    alVar.f4669b++;
                    if (z) {
                        alVar.f4668a++;
                    }
                    if (z2) {
                        alVar.f4670c++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(alVar.f4668a));
                    contentValues.put("daily_events_count", Long.valueOf(alVar.f4669b));
                    contentValues.put("daily_conversions_count", Long.valueOf(alVar.f4670c));
                    w.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return alVar;
                }
                m8220s().m8583c().m8608a("Not updating daily counts, app is not known", str);
                if (query != null) {
                    query.close();
                }
                return alVar;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    m8220s().m8582b().m8608a("Error updating daily counts", e);
                    if (query != null) {
                        query.close();
                    }
                    return alVar;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            m8220s().m8582b().m8608a("Error updating daily counts", e);
            if (query != null) {
                query.close();
            }
            return alVar;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public as m8394a(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        bf.m7875a(str);
        bf.m7875a(str2);
        m8207f();
        m8225G();
        try {
            Cursor query = m8429w().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    as asVar = new as(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        m8220s().m8582b().m8607a("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return asVar;
                    }
                    query.close();
                    return asVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    m8220s().m8582b().m8610a("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            m8220s().m8582b().m8610a("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List m8395a(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        bf.m7875a(str);
        m8207f();
        m8225G();
        List arrayList = new ArrayList();
        try {
            Cursor query = m8429w().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(m8222u().m8324F()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object b = m8413b(query, 2);
                        if (b == null) {
                            m8220s().m8582b().m8607a("Read invalid user property value, ignoring it");
                        } else {
                            arrayList.add(new af(str, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                m8220s().m8582b().m8609a("Error querying user properties", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List m8396a(java.lang.String r12, int r13, int r14) {
        /*
        r11 = this;
        r10 = 0;
        r1 = 1;
        r9 = 0;
        r11.m8207f();
        r11.m8225G();
        if (r13 <= 0) goto L_0x004e;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        com.google.android.gms.common.internal.bf.m7881b(r0);
        if (r14 <= 0) goto L_0x0050;
    L_0x0011:
        com.google.android.gms.common.internal.bf.m7881b(r1);
        com.google.android.gms.common.internal.bf.m7875a(r12);
        r0 = r11.m8429w();	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00d6 }
        r1 = "queue";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00d6 }
        r3 = 0;
        r4 = "rowid";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00d6 }
        r3 = 1;
        r4 = "data";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00d6 }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00d6 }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00d6 }
        r5 = 0;
        r6 = 0;
        r7 = "rowid";
        r8 = java.lang.String.valueOf(r13);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00d6 }
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00d6 }
        r0 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        if (r0 != 0) goto L_0x0052;
    L_0x0044:
        r0 = java.util.Collections.emptyList();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        if (r2 == 0) goto L_0x004d;
    L_0x004a:
        r2.close();
    L_0x004d:
        return r0;
    L_0x004e:
        r0 = r9;
        goto L_0x000c;
    L_0x0050:
        r1 = r9;
        goto L_0x0011;
    L_0x0052:
        r0 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r0.<init>();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r3 = r9;
    L_0x0058:
        r1 = 0;
        r4 = r2.getLong(r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r1 = 1;
        r1 = r2.getBlob(r1);	 Catch:{ IOException -> 0x007a }
        r6 = r11.m8216o();	 Catch:{ IOException -> 0x007a }
        r1 = r6.m8285b(r1);	 Catch:{ IOException -> 0x007a }
        r6 = r0.isEmpty();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        if (r6 != 0) goto L_0x0093;
    L_0x0070:
        r6 = r1.length;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r6 = r6 + r3;
        if (r6 <= r14) goto L_0x0093;
    L_0x0074:
        if (r2 == 0) goto L_0x004d;
    L_0x0076:
        r2.close();
        goto L_0x004d;
    L_0x007a:
        r1 = move-exception;
        r4 = r11.m8220s();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r4 = r4.m8582b();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r5 = "Failed to unzip queued bundle";
        r4.m8609a(r5, r12, r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r1 = r3;
    L_0x0089:
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        if (r3 == 0) goto L_0x0074;
    L_0x008f:
        if (r1 > r14) goto L_0x0074;
    L_0x0091:
        r3 = r1;
        goto L_0x0058;
    L_0x0093:
        r6 = com.google.android.gms.p051b.mh.m7104a(r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r7 = new com.google.android.gms.b.lq;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r7.<init>();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r7.m7043a(r6);	 Catch:{ IOException -> 0x00c6 }
        r1 = r1.length;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r1 = r1 + r3;
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r3 = android.util.Pair.create(r7, r3);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r0.add(r3);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        goto L_0x0089;
    L_0x00ad:
        r0 = move-exception;
        r1 = r2;
    L_0x00af:
        r2 = r11.m8220s();	 Catch:{ all -> 0x00e0 }
        r2 = r2.m8582b();	 Catch:{ all -> 0x00e0 }
        r3 = "Error querying bundles";
        r2.m8609a(r3, r12, r0);	 Catch:{ all -> 0x00e0 }
        r0 = java.util.Collections.emptyList();	 Catch:{ all -> 0x00e0 }
        if (r1 == 0) goto L_0x004d;
    L_0x00c2:
        r1.close();
        goto L_0x004d;
    L_0x00c6:
        r1 = move-exception;
        r4 = r11.m8220s();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r4 = r4.m8582b();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r5 = "Failed to merge queued bundle";
        r4.m8609a(r5, r12, r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00de }
        r1 = r3;
        goto L_0x0089;
    L_0x00d6:
        r0 = move-exception;
        r2 = r10;
    L_0x00d8:
        if (r2 == 0) goto L_0x00dd;
    L_0x00da:
        r2.close();
    L_0x00dd:
        throw r0;
    L_0x00de:
        r0 = move-exception;
        goto L_0x00d8;
    L_0x00e0:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00d8;
    L_0x00e3:
        r0 = move-exception;
        r1 = r10;
        goto L_0x00af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ak.a(java.lang.String, int, int):java.util.List");
    }

    protected void m8397a() {
    }

    public void m8398a(long j) {
        m8207f();
        m8225G();
        if (m8429w().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            m8220s().m8582b().m8607a("Deleted fewer rows from queue than expected");
        }
    }

    void m8399a(ContentValues contentValues, String str, Object obj) {
        bf.m7875a(str);
        bf.m7873a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Float) {
            contentValues.put(str, (Float) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void m8400a(lq lqVar) {
        m8207f();
        m8225G();
        bf.m7873a((Object) lqVar);
        bf.m7875a(lqVar.f3964o);
        bf.m7873a(lqVar.f3955f);
        m8431y();
        long a = m8213l().m6913a();
        if (lqVar.f3955f.longValue() < a - m8222u().m8334P() || lqVar.f3955f.longValue() > m8222u().m8334P() + a) {
            m8220s().m8583c().m8609a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(a), lqVar.f3955f);
        }
        try {
            byte[] bArr = new byte[lqVar.m6966e()];
            mi a2 = mi.m7134a(bArr);
            lqVar.m7044a(a2);
            a2.m7168b();
            bArr = m8216o().m8282a(bArr);
            m8220s().m8606z().m8608a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", lqVar.f3964o);
            contentValues.put("bundle_end_timestamp", lqVar.f3955f);
            contentValues.put("data", bArr);
            try {
                if (m8429w().insert("queue", null, contentValues) == -1) {
                    m8220s().m8582b().m8607a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                m8220s().m8582b().m8608a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            m8220s().m8582b().m8608a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void m8401a(ar arVar, long j) {
        m8207f();
        m8225G();
        bf.m7873a((Object) arVar);
        bf.m7875a(arVar.f4680a);
        ln lnVar = new ln();
        lnVar.f3940d = Long.valueOf(arVar.f4684e);
        lnVar.f3937a = new lo[arVar.f4685f.m8195a()];
        Iterator it = arVar.f4685f.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            lo loVar = new lo();
            int i2 = i + 1;
            lnVar.f3937a[i] = loVar;
            loVar.f3943a = str;
            m8216o().m8277a(loVar, arVar.f4685f.m8196a(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[lnVar.m6966e()];
            mi a = mi.m7134a(bArr);
            lnVar.m7027a(a);
            a.m7168b();
            m8220s().m8606z().m8609a("Saving event, name, data size", arVar.f4681b, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", arVar.f4680a);
            contentValues.put("name", arVar.f4681b);
            contentValues.put("timestamp", Long.valueOf(arVar.f4683d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (m8429w().insert("raw_events", null, contentValues) == -1) {
                    m8220s().m8582b().m8607a("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                m8220s().m8582b().m8608a("Error storing raw event", e);
            }
        } catch (IOException e2) {
            m8220s().m8582b().m8608a("Data loss. Failed to serialize event params/data", e2);
        }
    }

    public void m8402a(as asVar) {
        bf.m7873a((Object) asVar);
        m8207f();
        m8225G();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", asVar.f4686a);
        contentValues.put("name", asVar.f4687b);
        contentValues.put("lifetime_count", Long.valueOf(asVar.f4688c));
        contentValues.put("current_bundle_count", Long.valueOf(asVar.f4689d));
        contentValues.put("last_fire_timestamp", Long.valueOf(asVar.f4690e));
        try {
            if (m8429w().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                m8220s().m8582b().m8607a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            m8220s().m8582b().m8608a("Error storing event aggregates", e);
        }
    }

    public void m8403a(C0360b c0360b) {
        bf.m7873a((Object) c0360b);
        m8207f();
        m8225G();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c0360b.m8508b());
        contentValues.put("app_instance_id", c0360b.m8511c());
        contentValues.put("gmp_app_id", c0360b.m8514d());
        contentValues.put("resettable_device_id_hash", c0360b.m8517e());
        contentValues.put("last_bundle_index", Long.valueOf(c0360b.m8533m()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(c0360b.m8520f()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c0360b.m8522g()));
        contentValues.put("app_version", c0360b.m8524h());
        contentValues.put("app_store", c0360b.m8526i());
        contentValues.put("gmp_version", Long.valueOf(c0360b.m8528j()));
        contentValues.put("dev_cert_hash", Long.valueOf(c0360b.m8530k()));
        contentValues.put("measurement_enabled", Boolean.valueOf(c0360b.m8532l()));
        contentValues.put("day", Long.valueOf(c0360b.m8537q()));
        contentValues.put("daily_public_events_count", Long.valueOf(c0360b.m8538r()));
        contentValues.put("daily_events_count", Long.valueOf(c0360b.m8539s()));
        contentValues.put("daily_conversions_count", Long.valueOf(c0360b.m8540t()));
        contentValues.put("config_fetched_time", Long.valueOf(c0360b.m8534n()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(c0360b.m8535o()));
        try {
            if (m8429w().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                m8220s().m8582b().m8607a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            m8220s().m8582b().m8608a("Error storing app", e);
        }
    }

    public void m8404a(String str, int i) {
        bf.m7875a(str);
        m8207f();
        m8225G();
        try {
            m8429w().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            m8220s().m8582b().m8609a("Error pruning currencies", str, e);
        }
    }

    void m8405a(String str, int i, lr lrVar) {
        m8225G();
        m8207f();
        bf.m7875a(str);
        bf.m7873a((Object) lrVar);
        try {
            byte[] bArr = new byte[lrVar.m6966e()];
            mi a = mi.m7134a(bArr);
            lrVar.m7050a(a);
            a.m7168b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (m8429w().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    m8220s().m8582b().m8607a("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                m8220s().m8582b().m8608a("Error storing filter results", e);
            }
        } catch (IOException e2) {
            m8220s().m8582b().m8608a("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    public void m8406a(String str, long j, am amVar) {
        Object string;
        Object e;
        Throwable th;
        Cursor cursor = null;
        bf.m7873a((Object) amVar);
        m8207f();
        m8225G();
        Cursor cursor2;
        try {
            String str2;
            SQLiteDatabase w = m8429w();
            String string2;
            if (TextUtils.isEmpty(str)) {
                cursor = w.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (cursor.moveToFirst()) {
                    string = cursor.getString(0);
                    string2 = cursor.getString(1);
                    cursor.close();
                    str2 = string2;
                    cursor2 = cursor;
                } else if (cursor != null) {
                    cursor.close();
                    return;
                } else {
                    return;
                }
            }
            cursor = w.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
            if (cursor.moveToFirst()) {
                string2 = cursor.getString(0);
                cursor.close();
                str2 = string2;
                cursor2 = cursor;
            } else if (cursor != null) {
                cursor.close();
                return;
            } else {
                return;
            }
            try {
                cursor2 = w.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", "2");
                if (cursor2.moveToFirst()) {
                    mh a = mh.m7104a(cursor2.getBlob(0));
                    lq lqVar = new lq();
                    try {
                        lqVar.m7043a(a);
                        if (cursor2.moveToNext()) {
                            m8220s().m8583c().m8607a("Get multiple raw event metadata records, expected one");
                        }
                        cursor2.close();
                        amVar.m8433a(lqVar);
                        cursor = w.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", null);
                        if (cursor.moveToFirst()) {
                            do {
                                try {
                                    long j2 = cursor.getLong(0);
                                    mh a2 = mh.m7104a(cursor.getBlob(3));
                                    ln lnVar = new ln();
                                    try {
                                        lnVar.m7026a(a2);
                                        lnVar.f3938b = cursor.getString(1);
                                        lnVar.f3939c = Long.valueOf(cursor.getLong(2));
                                        if (!amVar.m8434a(j2, lnVar)) {
                                            if (cursor != null) {
                                                cursor.close();
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (IOException e2) {
                                        m8220s().m8582b().m8609a("Data loss. Failed to merge raw event", string, e2);
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                }
                            } while (cursor.moveToNext());
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                        m8220s().m8583c().m8607a("Raw event data disappeared while in transaction");
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (IOException e22) {
                        m8220s().m8582b().m8609a("Data loss. Failed to merge raw event metadata", string, e22);
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    }
                }
                m8220s().m8582b().m8607a("Raw event metadata record is missing");
                if (cursor2 != null) {
                    cursor2.close();
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = cursor2;
                try {
                    m8220s().m8582b().m8608a("Data loss. Error selecting raw event", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e32) {
            e = e32;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public void m8407a(String str, byte[] bArr) {
        bf.m7875a(str);
        m8207f();
        m8225G();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) m8429w().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                m8220s().m8582b().m8607a("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            m8220s().m8582b().m8608a("Error storing remote config", e);
        }
    }

    void m8408a(String str, la[] laVarArr) {
        m8225G();
        m8207f();
        bf.m7875a(str);
        bf.m7873a((Object) laVarArr);
        SQLiteDatabase w = m8429w();
        w.beginTransaction();
        try {
            m8425e(str);
            for (la a : laVarArr) {
                m8386a(str, a);
            }
            w.setTransactionSuccessful();
        } finally {
            w.endTransaction();
        }
    }

    public void m8409a(List list) {
        bf.m7873a((Object) list);
        m8207f();
        m8225G();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = m8429w().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            m8220s().m8582b().m8609a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public boolean m8410a(af afVar) {
        bf.m7873a((Object) afVar);
        m8207f();
        m8225G();
        if (m8420c(afVar.f4659a, afVar.f4660b) == null) {
            if (ag.m8266a(afVar.f4660b)) {
                if (m8383a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{afVar.f4659a}) >= ((long) m8222u().m8323E())) {
                    return false;
                }
            }
            if (m8383a("select count(1) from user_attributes where app_id=?", new String[]{afVar.f4659a}) >= ((long) m8222u().m8324F())) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", afVar.f4659a);
        contentValues.put("name", afVar.f4660b);
        contentValues.put("set_timestamp", Long.valueOf(afVar.f4661c));
        m8399a(contentValues, "value", afVar.f4662d);
        try {
            if (m8429w().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                m8220s().m8582b().m8607a("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            m8220s().m8582b().m8608a("Error storing user property", e);
        }
        return true;
    }

    public long m8411b(lq lqVar) {
        m8207f();
        m8225G();
        bf.m7873a((Object) lqVar);
        bf.m7875a(lqVar.f3964o);
        try {
            byte[] bArr = new byte[lqVar.m6966e()];
            mi a = mi.m7134a(bArr);
            lqVar.m7044a(a);
            a.m7168b();
            long d = m8216o().m8288d(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", lqVar.f3964o);
            contentValues.put("metadata_fingerprint", Long.valueOf(d));
            contentValues.put("metadata", bArr);
            try {
                m8429w().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return d;
            } catch (SQLiteException e) {
                m8220s().m8582b().m8608a("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            m8220s().m8582b().m8608a("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    public C0360b m8412b(String str) {
        Object e;
        Throwable th;
        bf.m7875a(str);
        m8207f();
        m8225G();
        Cursor query;
        try {
            query = m8429w().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    C0360b c0360b = new C0360b(this.n, str);
                    c0360b.m8506a(query.getString(0));
                    c0360b.m8510b(query.getString(1));
                    c0360b.m8513c(query.getString(2));
                    c0360b.m8518e(query.getLong(3));
                    c0360b.m8505a(query.getLong(4));
                    c0360b.m8509b(query.getLong(5));
                    c0360b.m8516d(query.getString(6));
                    c0360b.m8519e(query.getString(7));
                    c0360b.m8512c(query.getLong(8));
                    c0360b.m8515d(query.getLong(9));
                    c0360b.m8507a((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    c0360b.m8525h(query.getLong(11));
                    c0360b.m8527i(query.getLong(12));
                    c0360b.m8529j(query.getLong(13));
                    c0360b.m8531k(query.getLong(14));
                    c0360b.m8521f(query.getLong(15));
                    c0360b.m8523g(query.getLong(16));
                    c0360b.m8504a();
                    if (query.moveToNext()) {
                        m8220s().m8582b().m8607a("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return c0360b;
                    }
                    query.close();
                    return c0360b;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    m8220s().m8582b().m8609a("Error querying app", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            m8220s().m8582b().m8609a("Error querying app", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Object m8413b(Cursor cursor, int i) {
        int a = m8382a(cursor, i);
        switch (a) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                m8220s().m8582b().m8607a("Loaded invalid null value from database");
                return null;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return Long.valueOf(cursor.getLong(i));
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return Float.valueOf(cursor.getFloat(i));
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return cursor.getString(i);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                m8220s().m8582b().m8607a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                m8220s().m8582b().m8608a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    public String m8414b(long j) {
        Object e;
        Throwable th;
        String str = null;
        m8207f();
        m8225G();
        Cursor rawQuery;
        try {
            rawQuery = m8429w().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    m8220s().m8606z().m8607a("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    m8220s().m8582b().m8608a("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            m8220s().m8582b().m8608a("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public void m8415b() {
        m8225G();
        m8429w().beginTransaction();
    }

    void m8416b(String str, int i) {
        m8225G();
        m8207f();
        bf.m7875a(str);
        SQLiteDatabase w = m8429w();
        w.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        w.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    public void m8417b(String str, String str2) {
        bf.m7875a(str);
        bf.m7875a(str2);
        m8207f();
        m8225G();
        try {
            m8220s().m8606z().m8608a("Deleted user attribute rows:", Integer.valueOf(m8429w().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            m8220s().m8582b().m8610a("Error deleting user attribute", str, str2, e);
        }
    }

    public long m8418c(String str) {
        bf.m7875a(str);
        m8207f();
        m8225G();
        try {
            SQLiteDatabase w = m8429w();
            String valueOf = String.valueOf(m8222u().m8356e(str));
            return (long) w.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            m8220s().m8582b().m8608a("Error deleting over the limit events", e);
            return 0;
        }
    }

    lr m8419c(String str, int i) {
        Cursor query;
        Object e;
        Throwable th;
        m8225G();
        m8207f();
        bf.m7875a(str);
        try {
            query = m8429w().query("audience_filter_values", new String[]{"current_results"}, "app_id=? AND audience_id=?", new String[]{str, String.valueOf(i)}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    mh a = mh.m7104a(query.getBlob(0));
                    lr lrVar = new lr();
                    try {
                        lrVar.m7049a(a);
                    } catch (IOException e2) {
                        m8220s().m8582b().m8609a("Failed to merge filter results", str, e2);
                    }
                    if (query == null) {
                        return lrVar;
                    }
                    query.close();
                    return lrVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    m8220s().m8582b().m8608a("Database error querying filter results", e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            m8220s().m8582b().m8608a("Database error querying filter results", e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public af m8420c(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        bf.m7875a(str);
        bf.m7875a(str2);
        m8207f();
        m8225G();
        try {
            Cursor query = m8429w().query("user_attributes", new String[]{"set_timestamp", "value"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    af afVar = new af(str, str2, query.getLong(0), m8413b(query, 1));
                    if (query.moveToNext()) {
                        m8220s().m8582b().m8607a("Got multiple records for user property, expected one");
                    }
                    if (query == null) {
                        return afVar;
                    }
                    query.close();
                    return afVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    m8220s().m8582b().m8610a("Error querying user property", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            m8220s().m8582b().m8610a("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public void m8421c() {
        m8225G();
        m8429w().setTransactionSuccessful();
    }

    Map m8422d(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        m8225G();
        m8207f();
        bf.m7875a(str);
        bf.m7875a(str2);
        Map arrayMap = new ArrayMap();
        try {
            query = m8429w().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    mh a = mh.m7104a(query.getBlob(1));
                    lb lbVar = new lb();
                    try {
                        lbVar.m6975a(a);
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(lbVar);
                    } catch (IOException e2) {
                        try {
                            m8220s().m8582b().m8609a("Failed to merge filter", str, e2);
                        } catch (SQLiteException e3) {
                            e = e3;
                        }
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            }
            Map emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                m8220s().m8582b().m8608a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public byte[] m8423d(String str) {
        Object e;
        Throwable th;
        bf.m7875a(str);
        m8207f();
        m8225G();
        Cursor query;
        try {
            query = m8429w().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        m8220s().m8582b().m8607a("Got multiple records for app config, expected one");
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    m8220s().m8582b().m8609a("Error querying remote config", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            m8220s().m8582b().m8609a("Error querying remote config", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Map m8424e(String str, String str2) {
        Object e;
        Throwable th;
        m8225G();
        m8207f();
        bf.m7875a(str);
        bf.m7875a(str2);
        Map arrayMap = new ArrayMap();
        Cursor query;
        try {
            query = m8429w().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    mh a = mh.m7104a(query.getBlob(1));
                    le leVar = new le();
                    try {
                        leVar.m6992a(a);
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(leVar);
                    } catch (IOException e2) {
                        try {
                            m8220s().m8582b().m8609a("Failed to merge filter", str, e2);
                        } catch (SQLiteException e3) {
                            e = e3;
                        }
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            }
            Map emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                m8220s().m8582b().m8608a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    void m8425e(String str) {
        m8225G();
        m8207f();
        bf.m7875a(str);
        SQLiteDatabase w = m8429w();
        w.delete("property_filters", "app_id=?", new String[]{str});
        w.delete("event_filters", "app_id=?", new String[]{str});
    }

    public void m8426f(String str) {
        try {
            m8429w().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            m8220s().m8582b().m8608a("Failed to remove unused event metadata", e);
        }
    }

    public long m8427g(String str) {
        bf.m7875a(str);
        return m8384a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public void m8428v() {
        m8225G();
        m8429w().endTransaction();
    }

    SQLiteDatabase m8429w() {
        m8207f();
        try {
            return this.f4666b.getWritableDatabase();
        } catch (SQLiteException e) {
            m8220s().m8583c().m8608a("Error opening database", e);
            throw e;
        }
    }

    public String m8430x() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = m8429w().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    m8220s().m8582b().m8608a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            m8220s().m8582b().m8608a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void m8431y() {
        m8207f();
        m8225G();
        if (m8381J()) {
            long a = m8221t().f4799f.m8663a();
            long b = m8213l().m6914b();
            if (Math.abs(b - a) > m8222u().m8335Q()) {
                m8221t().f4799f.m8664a(b);
                m8432z();
            }
        }
    }

    void m8432z() {
        m8207f();
        m8225G();
        if (m8381J()) {
            int delete = m8429w().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(m8213l().m6913a()), String.valueOf(m8222u().m8334P())});
            if (delete > 0) {
                m8220s().m8606z().m8608a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }
}
