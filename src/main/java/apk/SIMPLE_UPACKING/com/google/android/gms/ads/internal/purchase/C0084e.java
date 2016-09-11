package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.fi;
import java.util.Locale;

@fi
/* renamed from: com.google.android.gms.ads.internal.purchase.e */
public class C0084e {
    private static final String f3080a;
    private static final Object f3081c;
    private static C0084e f3082d;
    private final C0085f f3083b;

    static {
        f3080a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
        f3081c = new Object();
    }

    C0084e(Context context) {
        this.f3083b = new C0085f(this, context, "google_inapp_purchase.db");
    }

    public static C0084e m5580a(Context context) {
        C0084e c0084e;
        synchronized (f3081c) {
            if (f3082d == null) {
                f3082d = new C0084e(context);
            }
            c0084e = f3082d;
        }
        return c0084e;
    }

    public SQLiteDatabase m5582a() {
        try {
            return this.f3083b.getWritableDatabase();
        } catch (SQLiteException e) {
            C0099b.m5643d("Error opening writable conversion tracking database");
            return null;
        }
    }

    public C0083d m5583a(Cursor cursor) {
        return cursor == null ? null : new C0083d(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void m5584a(C0083d c0083d) {
        if (c0083d != null) {
            synchronized (f3081c) {
                SQLiteDatabase a = m5582a();
                if (a == null) {
                    return;
                }
                a.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[]{"purchase_id", Long.valueOf(c0083d.f3077a)}), null);
            }
        }
    }

    public int m5585b() {
        Cursor cursor = null;
        int i = 0;
        synchronized (f3081c) {
            SQLiteDatabase a = m5582a();
            if (a == null) {
            } else {
                try {
                    cursor = a.rawQuery("select count(*) from InAppPurchase", null);
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (SQLiteException e) {
                    C0099b.m5643d("Error getting record count" + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }

    public void m5586b(C0083d c0083d) {
        if (c0083d != null) {
            synchronized (f3081c) {
                SQLiteDatabase a = m5582a();
                if (a == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("product_id", c0083d.f3079c);
                contentValues.put("developer_payload", c0083d.f3078b);
                contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
                c0083d.f3077a = a.insert("InAppPurchase", null, contentValues);
                if (((long) m5585b()) > 20000) {
                    m5587c();
                }
            }
        }
    }

    public void m5587c() {
        SQLiteException e;
        synchronized (f3081c) {
            SQLiteDatabase a = m5582a();
            if (a == null) {
                return;
            }
            Cursor query;
            try {
                query = a.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            m5584a(m5583a(query));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            C0099b.m5643d("Error remove oldest record" + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                C0099b.m5643d("Error remove oldest record" + e.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th2 = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        }
    }
}
